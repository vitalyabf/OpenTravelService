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
public class VehType {

    // Attributes
    @XmlAttribute(name = "DoorCount")
    private String doorCount="2-4"; // The number of doors on a vehicle. This may be an exact number or a range, i.e. 2-4.
    @XmlAttribute(name = "VehicleCategory", required = true)
    private String vehicleCategory="1"; // The VehicleCategory attribute provides the catgeory of a vehicle. Refer to OpenTravel Code List Vehicle Category (VEC).
}
