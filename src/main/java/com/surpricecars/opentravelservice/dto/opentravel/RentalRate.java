package com.surpricecars.opentravelservice.dto.opentravel;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import lombok.*;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@XmlAccessorType(XmlAccessType.FIELD)
public class RentalRate {

    // Elements
    @XmlElement(name = "RateQualifier")
    private RateQualifier rateQualifier; // Indicates the type of rates applicable to the customer, along with any discount number or promotional codes that affect the quoted rate.
    @XmlElement(name = "RateDistance")
    private List<RateDistance> rateDistance; // Information on the distance that a reserved vehicle may be driven as part of the standard rental charge. Such distance may be unlimited, or a quantity of miles or kilometers for a certain period of time. This may be repeated for situations such as an 8 day rental that has 500 miles per week and 100 miles per additional day.
    @XmlElementWrapper(name = "VehicleCharges")
    @XmlElement(name = "VehicleCharge", required = true)
    private List<OpenTravelVehicleCharge> vehicleCharges; // The VehicleChargePurposeType complex type defines information on a specific charge associated with the rental of a vehicle along with the purpose of the charge.

    public void addVehicleCharge(OpenTravelVehicleCharge vehicleCharge) {
        if (this.vehicleCharges == null) {
            this.vehicleCharges = new ArrayList<>();
        }
        vehicleCharges.add(vehicleCharge);
    }
}
