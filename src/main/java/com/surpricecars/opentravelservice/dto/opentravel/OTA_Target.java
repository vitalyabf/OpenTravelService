package com.surpricecars.opentravelservice.dto.opentravel;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;

@XmlEnum()
public enum OTA_Target {
    @XmlEnumValue("Test") Test,
    @XmlEnumValue("Production") Production
}
