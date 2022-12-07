package com.surpricecars.opentravelservice.dto.opentravel;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;

@XmlEnum
public enum OpenTravelTransmissionType {
    @XmlEnumValue("Automatic") AUTOMATIC,
    @XmlEnumValue("Manual") MANUAL
}
