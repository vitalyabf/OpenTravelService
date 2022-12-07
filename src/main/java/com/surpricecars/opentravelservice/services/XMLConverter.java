package com.surpricecars.opentravelservice.services;

import com.surpricecars.opentravelservice.dao.DBService;
import com.surpricecars.opentravelservice.dto.fleet.*;
import com.surpricecars.opentravelservice.dto.opentravel.*;
import com.surpricecars.opentravelservice.exceptions.FleetStatusException;
import org.apache.log4j.Logger;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class XMLConverter {
    private static int DEFAULT_DRIVER_AGE = 25;
    private static final String FLEET_USER_ID = "Traveljigsaw";
    public static final String AVAILABILITY_STATUS = "Availability";
    private static final OpenTravelPhoneType TECH_PHONE_TYPE = OpenTravelPhoneType.VOICE;
    public static final String CALCULATION_UNIT_NAME = "Day";
    private static final BiFunction<Double, Double, Integer> quantityFunction = (total, charge) -> {
        try {
            return (int) (total / charge);
        } catch (ArithmeticException e) {
            return 1;
        }};

    private static Logger logger = Logger.getLogger(XMLConverter.class);
    public static FleetPriceParameters convert(OTA_VehAvailRateRQ openTravelRQ) {

        FleetPriceParameters fleetRQ = new FleetPriceParameters();

        final int driverAge;
        final List<DriverType> driverTypes = openTravelRQ.getVehAvailRQCore().getDriverTypes();
        if (driverTypes == null) {
            driverAge = DEFAULT_DRIVER_AGE; // TODO determine default age if not specified in the request
        } else {
            driverAge = driverTypes.stream().mapToInt(DriverType::getAge).max().orElse(DEFAULT_DRIVER_AGE);
        }

        fleetRQ.setAge(driverAge);
        fleetRQ.setId(FLEET_USER_ID); // amadeus

        final LocalDateTime pickUpDate = openTravelRQ.getVehAvailRQCore().getVehRentalCore().getPickUpDateTime();
        fleetRQ.setPickupDate(pickUpDate.toLocalDate());
        fleetRQ.setPickupTime(pickUpDate.toLocalTime());

        final OpenTravelLocation pickUpLocation = openTravelRQ.getVehAvailRQCore().getVehRentalCore().getPickUpLocations().stream().findFirst().get();
        final int pickUpLocationId = DBService.getLocationId(pickUpLocation.getCodeContext(), pickUpLocation.getLocationCode(), pickUpLocation.getExtendedLocationCode());
        fleetRQ.setPickupLocationCode(pickUpLocationId);

        final LocalDateTime returnDate = openTravelRQ.getVehAvailRQCore().getVehRentalCore().getReturnDateTime();
        fleetRQ.setReturnDate(returnDate.toLocalDate());
        fleetRQ.setReturnTime(returnDate.toLocalTime());

        final OpenTravelLocation returnLocation = openTravelRQ.getVehAvailRQCore().getVehRentalCore().getReturnLocation();
        final int returnLocationId = DBService.getLocationId(returnLocation.getCodeContext(), returnLocation.getLocationCode(), returnLocation.getExtendedLocationCode());
        fleetRQ.setReturnLocationCode(returnLocationId);

        fleetRQ.setVehicleGroup("");

        logger.info("FleetPriceParameters: " + fleetRQ);
        return fleetRQ;
    }

    public static OTA_VehAvailRateRS convert(FleetCarGroupAvailabilityInfoWrapper fleetRS, OTA_VehAvailRateRQ openTravelRequest) throws FleetStatusException {

        List<FleetCarGroupAvailabilityInfo> fleetCarGroups = fleetRS.getItem();

        // TODO - status code exception handling
        if (fleetCarGroups.stream().anyMatch(element -> !element.getStatus())) {
            throw new FleetStatusException("Wrong response: ");
        } else if (fleetCarGroups.size() == 0) {
            throw new FleetStatusException("Wrong response: no cars found");
        }

        OTA_VehAvailRateRS openTravelResponse = new OTA_VehAvailRateRS(openTravelRequest.getEchoToken(),
                openTravelRequest.getPrimaryLangID(),
                openTravelRequest.getSequenceNumber(),
                openTravelRequest.getTarget(),
                openTravelRequest.getTransactionIdentifier(),
                openTravelRequest.getVersion());
        openTravelResponse.setSuccess(true);

        VehRentalCore rentalCore = new VehRentalCore();

        FleetLocationDetails fleetPickUpLocation = fleetCarGroups.get(0).getPickUpLocation();
        FleetLocationDetails fleetReturnLocation = fleetCarGroups.get(0).getReturnLocation();

        final LocalDateTime pickUpDate = openTravelRequest.getVehAvailRQCore().getVehRentalCore().getPickUpDateTime();
        final LocalDateTime returnDate = openTravelRequest.getVehAvailRQCore().getVehRentalCore().getReturnDateTime();
        int rentalPeriodDays = (int) Duration.between(pickUpDate, returnDate).toDays();

        fillCoreRentalPeriodAndLocations(fleetPickUpLocation, fleetReturnLocation, pickUpDate, returnDate, rentalCore);

        List<VehVendorAvail> vendorAvailabilityList = new ArrayList<>();
        VehVendorAvail vendorAvailability = new VehVendorAvail();
        fillCoreVendorInfo(vendorAvailability);

        vendorAvailability.setInfo(new VehVendorAvail_Info());
        List<OpenTravelLocationDetails> openTravelLocationDetails = new ArrayList<>();
        addLocationDetails(fleetPickUpLocation, openTravelLocationDetails);
        addLocationDetails(fleetReturnLocation, openTravelLocationDetails);
        vendorAvailability.getInfo().setLocationDetails(openTravelLocationDetails);

        List<VehAvail> vehicles = new ArrayList<>();

        logger.info("cars: " + fleetCarGroups.size());
        for (FleetCarGroupAvailabilityInfo fleetCarGroup : fleetCarGroups) {
            addVehicleAvailability(fleetCarGroup, rentalPeriodDays, vehicles);
        }

        vendorAvailability.setVehAvails(vehicles);
        vendorAvailabilityList.add(vendorAvailability);

        openTravelResponse.setVehAvailRSCore(new VehAvailRSCore(rentalCore, vendorAvailabilityList));

        return openTravelResponse;
    }

    private static void fillCoreVendorInfo(VehVendorAvail vendorAvail){
        vendorAvail.setVendor(new Vendor("companyCode","companyName")); // TODO: get vendor info from request or properties
    }
    private static void fillCoreRentalPeriodAndLocations(FleetLocationDetails fleetPickUpLocation, FleetLocationDetails fleetReturnLocation, LocalDateTime pickUpDate, LocalDateTime returnDate, VehRentalCore rentalCore) {

        rentalCore.setPickUpDateTime(pickUpDate);
        rentalCore.setReturnDateTime(returnDate);

        // VehAvailRSCore_VehRentalCore_PickUpLocation
        OpenTravelLocation pickUpLocation = DBService.getOpenTravelLocation(fleetPickUpLocation.getAttributes().getExtendedLocationCode());
        List<OpenTravelLocation> locations = new ArrayList<>();
        locations.add(pickUpLocation);
        rentalCore.setPickUpLocations(locations);

        // VehAvailRSCore_VehRentalCore_ReturnLocation
        OpenTravelLocation returnLocation = DBService.getOpenTravelLocation(fleetReturnLocation.getAttributes().getExtendedLocationCode());
        rentalCore.setReturnLocation(returnLocation);
    }
    private static void addLocationDetails(FleetLocationDetails fleetLocation, List<OpenTravelLocationDetails> openTravelLocationDetails) {

        OpenTravelLocationDetails locationDetails = new OpenTravelLocationDetails(
                Integer.toString(fleetLocation.getAttributes().getExtendedLocationCode()), // TODO use ExtendedLocationCode from DB
                fleetLocation.getAttributes().getAtAirport(),
                fleetLocation.getAttributes().getName());

        // LocationDetails/Address
        LocationDetails_Address address = new LocationDetails_Address(
                fleetLocation.getAddress().getAddressLine(),
                fleetLocation.getAddress().getPostalCode(),
                fleetLocation.getAddress().getCityName(),
                fleetLocation.getAddress().getCountryName(),
                false);

        List<LocationDetails_Address> addressList = new ArrayList<>();
        addressList.add(address);
        locationDetails.setAddress(addressList);

        // LocationDetails/Phones
        List<Telephone> phoneList = fleetLocation.getAddress().getTelephones().stream()
                .map(e -> new Telephone(e.getNumber(), TECH_PHONE_TYPE)).toList();
        locationDetails.setTelephone(phoneList);

        // LocationDetails/AdditionalInfo/OperationSchedule
        AdditionalInfo locationAdditionalInfo = new AdditionalInfo(); // TODO: ask Amadeus to provide an example with Meeting point address
        List<OpenTravelOperationTime> operationTimes = fleetLocation.getWorkHours().stream()
                .map(e -> {OpenTravelOperationTime time = new OpenTravelOperationTime();
                    time.setStart(e.getStart());
                    time.setEnd(e.getEnd());
                    time.setMon(e.getDay() == DayOfWeek.MONDAY);
                    time.setTue(e.getDay() == DayOfWeek.TUESDAY);
                    time.setWeds(e.getDay() == DayOfWeek.WEDNESDAY);
                    time.setThur(e.getDay() == DayOfWeek.THURSDAY);
                    time.setFri(e.getDay() == DayOfWeek.FRIDAY);
                    time.setSun(e.getDay() == DayOfWeek.SUNDAY);
                    time.setSat(e.getDay() == DayOfWeek.SATURDAY);
                    return time;})
                .toList();
        List<OperationSchedule> schedule = new ArrayList<>();
        schedule.add(new OperationSchedule(operationTimes));
        locationAdditionalInfo.setOperationSchedule(schedule);

        final VehicleRentalLocationInfo rentalLocationInfo = new VehicleRentalLocationInfo();
        rentalLocationInfo.setTitle("Meeting point");
        rentalLocationInfo.setType(VehicleLocationInformationType.DRIVING_DIRECTIONS);
        rentalLocationInfo.addSection(new Paragraph(fleetLocation.getAddress().getMeetingPoint()));
        locationAdditionalInfo.addVehicleRentalLocationInfo(rentalLocationInfo);

        locationDetails.setAdditionalInfo(locationAdditionalInfo);

        openTravelLocationDetails.add(locationDetails);
    }
    private static void addVehicleAvailability(FleetCarGroupAvailabilityInfo fleetCarGroupInfo, int rentalPeriodDays, List<VehAvail> vehicleAvailabilityList) {

        FleetModel fleetModel = fleetCarGroupInfo.getModel();

        VehAvail vehicleAvailability = new VehAvail();
        VehAvailCore vehicleCore = new VehAvailCore(AVAILABILITY_STATUS);

        RentalRate rentalRate = new RentalRate();
        fillRateQualifier(rentalRate);
        fillRateDistance(rentalRate);
        fillVehicleCharges(fleetCarGroupInfo.getCharge(), fleetCarGroupInfo.getExtras(), rentalPeriodDays, rentalRate);
        vehicleCore.addRentalRate(rentalRate);

        fillPricedEquipment(fleetCarGroupInfo.getExtras(), rentalPeriodDays, vehicleCore);
        fillTotalCharge(fleetCarGroupInfo, vehicleCore);
        fillVehicleModelInfo(fleetModel, vehicleCore);
        vehicleAvailability.setVehAvailCore(vehicleCore);

        VehAvailInfo vehicleAvailabilityInto = new VehAvailInfo();

        fillPricedCoverage(fleetCarGroupInfo, rentalPeriodDays, vehicleAvailabilityInto);

        fillPaymentRules(vehicleAvailabilityInto);
        vehicleAvailability.setVehAvailInfo(vehicleAvailabilityInto);

        vehicleAvailabilityList.add(vehicleAvailability);

    }

    private static void fillPaymentRules(VehAvailInfo vehicleAvailabilityInfo) {
        // TODO PaymentRule: RuleType, PaymentType
        PaymentRule paymentRule = new PaymentRule(OpenTravelPaymentRuleType.GUARANTEE, OpenTravelPaymentType.CREDIT_CARD);
        vehicleAvailabilityInfo.addPaymentRule(paymentRule);
    }

    private static void fillPricedCoverage(FleetCarGroupAvailabilityInfo fleetCarGroupInfo, int rentalPeriodDays, VehAvailInfo vehicleAvailabilityInfo) {

        final String currencyCode = fleetCarGroupInfo.getCharge().getCurrencyCode();
        final Boolean taxIncluded = fleetCarGroupInfo.getCharge().getTaxInclusive();
        FleetModel fleetModel = fleetCarGroupInfo.getModel();

        // TODO: PricedCoverage - CDW (deposit) & FDW (per day)

        Charge charge;

        if (fleetModel.getCollisionDamageWaiver() > 0) {
            PricedCoverage pricedCoverage = new PricedCoverage();
            charge = new Charge("Collision Damage Waiver", fleetModel.getCollisionDamageWaiver(), currencyCode, false, false, taxIncluded);
            charge.addCalculation(new Calculation(1, fleetModel.getCollisionDamageWaiver(), VehicleUnitCharge.BUNDLE));
            pricedCoverage.setCharge(charge);
            pricedCoverage.setRequired(false);
            pricedCoverage.setCoverage(new Coverage(OpenTravelVehicleCoverageType.COLLISION_DAMAGE_WAIVER));
            vehicleAvailabilityInfo.addPricedCoverage(pricedCoverage);
        }

        if (fleetModel.getFullDamageWaiver() > 0) {
            PricedCoverage pricedCoverage = new PricedCoverage();
            charge = new Charge("Full Damage Waiver", fleetModel.getFullDamageWaiver(), currencyCode, false, false, taxIncluded);
            charge.addCalculation(new Calculation(rentalPeriodDays, fleetModel.getFullDamageWaiver(), VehicleUnitCharge.DAY));
            pricedCoverage.setCharge(charge);
            pricedCoverage.setRequired(false);
            pricedCoverage.setCoverage(new Coverage(OpenTravelVehicleCoverageType.FULL_COVERAGE));
            vehicleAvailabilityInfo.addPricedCoverage(pricedCoverage);
        }

    }

    private static void fillVehicleModelInfo(FleetModel fleetModel, VehAvailCore vehicleCore) {
        Vehicle vehicle = new Vehicle();
        vehicle.setCode(fleetModel.getVehicleCode());
        vehicle.setVendorCarType(fleetModel.getVehicleCode());
        // TODO ask Amadeus about VehAvail.VehAvailCore.Vehicle.VehClass.Size
        // vehicle.set <VehClass Size="3"/>.
        vehicle.setCodeContext(fleetModel.getCodeContext());
        vehicle.setVehMakeModel(new VehMakeModel(fleetModel.getModelName()));
        vehicle.setPassengerQuantity(fleetModel.getPassengers());
        vehicle.setAirCondition(fleetModel.getAirCondition());
        vehicle.setTransmissionType(OpenTravelTransmissionType.valueOf(fleetModel.getTransmissionType().toString()));
        vehicle.setPictureUrl(fleetModel.getPhotoUrl());
        vehicleCore.setVehicle(vehicle);
    }

    private static void fillTotalCharge(FleetCarGroupAvailabilityInfo fleetCarGroupInfo, VehAvailCore vehicleCore) {
        List<TotalCharge> totalCharges = new ArrayList<>();
        TotalCharge totalCharge = new TotalCharge();

        final Double rentalCharge = fleetCarGroupInfo.getCharge().getPrice();
        final Double mandatoryExtras = fleetCarGroupInfo.getExtras().stream()
                .filter(e -> e.getIncludedInRate())
                .mapToDouble(e -> e.getTotalCharge())
                .sum();

        totalCharge.setRateTotalAmount(rentalCharge);
        totalCharge.setEstimatedTotalAmount(rentalCharge + mandatoryExtras);
        totalCharge.setCurrency(fleetCarGroupInfo.getCharge().getCurrencyCode());
        totalCharges.add(totalCharge);
        vehicleCore.setTotalCharge(totalCharges);
    }

    private static void fillPricedEquipment(List<FleetExtra> fleetExtras, int rentalPeriodDays, VehAvailCore vehicleCore) {

        // TODO PricedEquipments - filter by; IncludedInRate, IncludedInEstTotal, Guaranteed, TaxInclusive, DecimalPlaces; calculation (unit, quantity)?
        List<PricedEquipment> pricedEquipments = fleetExtras.stream()
            .map(e -> {
                PricedEquipment pricedEquipment = new PricedEquipment();
                pricedEquipment.setRequired(false);
                pricedEquipment.setEquipment(DBService.getOpenTravelEquipment(e.getEquipmentId(), e.getDescription()));
                Charge charge = new Charge();
                charge.setAmount(e.getTotalCharge());
                charge.setCurrency(e.getCurrencyCode());
                charge.setDescription(e.getDescription());
                charge.setIncludedInRate(false);
                charge.setIncludedInEstTotal(e.getIncludedInRate());
                charge.addCalculation(new Calculation(rentalPeriodDays, e.getCharge(), VehicleUnitCharge.DAY));
                pricedEquipment.setCharge(charge);
                return pricedEquipment;})
            .toList();

        vehicleCore.setEquipments(pricedEquipments);
    }

    private static void fillVehicleCharges(FleetCharge fleetRentalCharge, List<FleetExtra> fleetExtras, int rentalPeriodDays, RentalRate rentalRate) {

        Boolean taxInclusive = fleetRentalCharge.getTaxInclusive();
        OpenTravelVehicleCharge rentalCharge = new OpenTravelVehicleCharge(OpenTravelChargePurpose.VEHICLE_RENTAL, OpenTravelChargePurpose.VEHICLE_RENTAL.toString(),
                fleetRentalCharge.getPrice(), fleetRentalCharge.getCurrencyCode());
        rentalCharge.setGuaranteed(true);
        rentalCharge.setTaxInclusive(taxInclusive);
        rentalCharge.setIncludedInRate(true);
        rentalCharge.setIncludedInEstTotal(true);
        Double rentalPrice = rentalPeriodDays == 0 ? 1 : fleetRentalCharge.getPrice() / rentalPeriodDays;
        rentalCharge.addCalculation(new Calculation(rentalPeriodDays, rentalPrice, VehicleUnitCharge.DAY));
        rentalRate.addVehicleCharge(rentalCharge);

        // TODO VehicleCharges - filter by; purpose, IncludedInRate, IncludedInEstTotal, Guaranteed, TaxInclusive, DecimalPlaces; calculation (unit, quantity)?
        fleetExtras.stream().filter(e -> e.getIncludedInRate()).forEach(e -> {
                OpenTravelVehicleCharge charge = new OpenTravelVehicleCharge();
                charge.setPurpose(DBService.getChargePurpose(e.getEquipmentId()));
                charge.setCurrency(e.getCurrencyCode());
                charge.setDescription(e.getDescription());
                charge.setAmount(e.getTotalCharge());
                charge.setGuaranteed(e.getPrepaid());
                charge.setIncludedInEstTotal(e.getIncludedInRate());
                charge.setIncludedInRate(false);
                charge.setTaxInclusive(taxInclusive);
                charge.addCalculation(new Calculation(rentalPeriodDays, e.getCharge(), VehicleUnitCharge.DAY));
//                charge.setMinMax(new MinMax(0.0, e.getMaxPrice()));
                rentalRate.addVehicleCharge(charge);});
    }

    private static void fillRateQualifier(RentalRate rentalRate) {
        RateQualifier rateQualifier = new RateQualifier(); // TODO: RateQualifier, VendorRateID - (generate); RateCategory - (confirm)
        rateQualifier.setRateCategory(OpenTravelRateCategory.STANDARD);
        rateQualifier.setRateQualifier("base");
        rateQualifier.setRatePeriod(OpenTravelRatePeriod.DAILY);
        rateQualifier.setVendorRateID("base");
        rentalRate.setRateQualifier(rateQualifier);
    }

    private static void fillRateDistance(RentalRate rentalRate) {
        //TODO get Mileage, Limits by car/ franchise. Ask Nicholas
        String countryCode = "UK";

        List<RateDistance> rateDistances = new ArrayList<>();
        RateDistance rateDistance = DBService.getRateDistance(countryCode);
        rateDistances.add(rateDistance);
        rentalRate.setRateDistance(rateDistances);
    }
}
