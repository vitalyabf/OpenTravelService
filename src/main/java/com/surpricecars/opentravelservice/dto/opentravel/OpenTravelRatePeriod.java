package com.surpricecars.opentravelservice.dto.opentravel;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;

@XmlEnum
public enum OpenTravelRatePeriod {
    @XmlEnumValue("Day") DAILY,
    @XmlEnumValue("Week") WEEKLY
}
