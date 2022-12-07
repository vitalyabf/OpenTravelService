package com.surpricecars.opentravelservice.dto.opentravel;

import jakarta.xml.bind.annotation.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Getter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@XmlAccessorType(XmlAccessType.FIELD)
public class VehAvailRQInfo {

    // Elements
    @XmlElement(name = "ArrivalDetails")
    private ArrivalDetails arrivalDetails; // Details of the arrival transportation, if applicable.The VehicleArrivalDetailsType complex type defines the information that describes an arriving mode of transportation which is associated with the rental of a vehicle. This is typically used to identify how the customer will be arriving at the vehicle rental facility.
    @XmlElementWrapper(name = "CoveragePrefs")
    @XmlElement(name = "CoveragePref", required = true)
    private List<CoveragePreference> coveragePreferences; // Indicates the preferences for one or more types of coverage (insurance).
    @XmlElement(name = "Customer")
    private CustomerPrimaryAdditional customer; // Information on the one primary driver and, optionally, several additional drivers. This may be used to provide a frequent renter number.Information on the one primary driver and, optionally, several additional drivers. This may be used to provide a frequent renter number.
    @XmlElement(name = "OffLocService")
    private List<OffLocService> offLocServices; // Information on requested off-airport location services, for example, vehicle delivery, customer pickup.The OffLocationServiceType complex type defines a specific off-location service.
    @XmlElement(name = "SpecialReqPref")
    private String specialReqPref; // Indicates the preference associated with special needs or requirements of the customer, described using free textThe VehicleSpecialReqPrefType complex type defines a preference for a particular special request. The preference is expressed using the attribute group PreferLevelType.
    @XmlElement(name = "TourInfo")
    private String TourInfo; // Details of a tour with which this availability information is associated. Availability and rate information may vary if associated with a tour.The VehicleTourInfoType provides information about a tour that includes a vehicle rental.
    @XmlElementWrapper(name = "TPA_Extension")
    @XmlElement(name = "any", required = true)
    private List<TPA_Extension> extensions; // A placeholder in the schema to allow for additional elements and attributes to be included per Trading Partner Agreement (TPA).Allows extensions to be added to the OpenTravel specification per trading partner agreement.

    // Attributes
    @XmlAttribute(name = "GasPrePay")
    private Boolean gasPrePay; // The GasPrePay attribute defines a set of valid values for the choice of prepaying for gas at the time of the pick up of the rental vehicle. This information is useful in that it allows a customer's preference to be made known to the vendor. It also allows the vendor to provide more detailed and accurate pricing up front.
    @XmlAttribute(name = "LuggageQty")
    private int luggageQuantity;
    @XmlAttribute(name = "PassengerQty")
    private int PassengerQuantity;
    @XmlAttribute(name = "SingleQuote")
    private Boolean SingleQuote; //	Allows the requestor to indicate if the response should contain a single rate for each product or multiple rates for each product. Multiple rates may be offered when different terms and conditions may apply, for example pre-paid versus payment at time of rental. The use of multiple rates may vary from vendor to vendor and is by agreement of the trading partners.
    @XmlAttribute(name = "SmokingAllowed")
    private Boolean SmokingAllowed; // Indicates smoking is allowed when true and is not allowed when false.

}
