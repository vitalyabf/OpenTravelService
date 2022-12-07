package com.surpricecars.opentravelservice.dto.opentravel;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;

@XmlEnum
public enum OpenTravelRateCategory {
    @XmlEnumValue("3") LEISURE,
    @XmlEnumValue("16") STANDARD
}
