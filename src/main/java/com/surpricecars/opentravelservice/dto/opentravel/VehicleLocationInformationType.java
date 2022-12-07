package com.surpricecars.opentravelservice.dto.opentravel;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;

@XmlEnum
public enum VehicleLocationInformationType {
    @XmlEnumValue("4") DRIVING_DIRECTIONS
}
