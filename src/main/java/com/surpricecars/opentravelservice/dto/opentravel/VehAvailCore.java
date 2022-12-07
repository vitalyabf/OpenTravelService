package com.surpricecars.opentravelservice.dto.opentravel;

import jakarta.xml.bind.annotation.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@XmlAccessorType(XmlAccessType.FIELD)
public class VehAvailCore {

    // Elements
    @XmlElement(name = "RentalRate")
    private List<RentalRate> rentalRates; // Information on the rates associated with this vehicle. Rate information can include the distance and the base rental cost, along with information on the various factors that may infuence this rate. This element may repeat to allow different distances to be made available for different charges. For example, $20.00 with 100 miles per day or $30.00 for unlimited mileage.This describes time, mileage and other charges.
    @XmlElement(name = "Vehicle", required = true)
    private Vehicle vehicle; // Information on one specific vehicle along with detailed information on the charges associated with this vehicle.The VehicleType complex type identifie sthe data that fully describes a vehicle. This includes the core information along with supplemental information such as make and model, and a link to a picture.
    @XmlElement(name = "TotalCharge")
    private List<TotalCharge> totalCharge; // The anticipated total cost of a reservation, the sum of the individual charges, optional charges and associated fees.
    @XmlElementWrapper(name = "PricedEquips")
    @XmlElement(name = "PricedEquip", required = true)
    private List<PricedEquipment> equipments; // A collection of special equipment that is part of this quote, along with the charges associated with this equipment. A specific piece of special equipment, along with the quantity, restrictions and charge.The VehicleEquipmentPricedType complex type identifies the data that describes a priced piece of special equipment in association with the rental of a vehicle. The data consists of the equipment and the corresponding charge.

    // Attributes
    @XmlAttribute(name = "Status", required = true)
    private String status;

    public VehAvailCore(String availabilityStatus) {
        status = availabilityStatus;
    }

    public void addRentalRate(RentalRate rentalRate) {
        if (rentalRates == null) {
            rentalRates = new ArrayList<>();
        }
        rentalRates.add(rentalRate);
    }

    public void addPricedEquipment(PricedEquipment pricedEquipment) {
        if (equipments == null) {
            equipments = new ArrayList<>();
        }
        equipments.add(pricedEquipment);
    }
}
