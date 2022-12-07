package com.surpricecars.opentravelservice.dto.opentravel;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import lombok.*;

import jakarta.xml.bind.annotation.XmlAttribute;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@XmlAccessorType(XmlAccessType.FIELD)
public class RateDistance {

    // Attributes
    @XmlAttribute(name = "Unlimited", required = true)
    private Boolean unlimited;
    @XmlAttribute(name = "Quantity")
    private int quantity;
    @XmlAttribute(name = "DistUnitName")
    private OpenTravelDistanceUnitName distanceUnit;
    @XmlAttribute(name = "VehiclePeriodUnitName")
    private String periodUnit;
}
