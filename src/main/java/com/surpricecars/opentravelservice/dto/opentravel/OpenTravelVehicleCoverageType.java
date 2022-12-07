package com.surpricecars.opentravelservice.dto.opentravel;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;

@XmlEnum
public enum OpenTravelVehicleCoverageType {
    @XmlEnumValue("7") COLLISION_DAMAGE_WAIVER,
    @XmlEnumValue("16") FULL_COVERAGE
}
