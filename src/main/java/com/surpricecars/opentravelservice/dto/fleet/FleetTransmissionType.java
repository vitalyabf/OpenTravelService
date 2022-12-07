package com.surpricecars.opentravelservice.dto.fleet;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;

@XmlEnum
public enum FleetTransmissionType {
    @XmlEnumValue("A") AUTOMATIC,
    @XmlEnumValue("M") MANUAL
}
