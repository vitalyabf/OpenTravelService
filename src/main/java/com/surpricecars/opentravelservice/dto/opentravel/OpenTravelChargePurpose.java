package com.surpricecars.opentravelservice.dto.opentravel;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;

@XmlEnum
public enum OpenTravelChargePurpose {
    @XmlEnumValue("1") VEHICLE_RENTAL("Vehicle rental"),
    @XmlEnumValue("4") COVERAGE("Coverage"),
    @XmlEnumValue("13") YOUNG_DRIVER("Young driver"),
    @XmlEnumValue("14") YOUNGER_DRIVER("Younger driver"),
    @XmlEnumValue("15") SENIOR("Senior"),
    @XmlEnumValue("21") EQUIPMENT("Equipment");

    private String description;

    OpenTravelChargePurpose(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}
