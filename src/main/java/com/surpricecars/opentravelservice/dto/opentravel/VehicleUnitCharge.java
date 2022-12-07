package com.surpricecars.opentravelservice.dto.opentravel;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;

@XmlEnum
public enum VehicleUnitCharge {
    @XmlEnumValue("Bundle") BUNDLE,
    @XmlEnumValue("Day") DAY,
    @XmlEnumValue("RentalPeriod") RENTAL_PERIOD
}
