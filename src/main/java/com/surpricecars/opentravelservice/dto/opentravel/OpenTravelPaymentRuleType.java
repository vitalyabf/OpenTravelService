package com.surpricecars.opentravelservice.dto.opentravel;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;

@XmlEnum
public enum OpenTravelPaymentRuleType {
    @XmlEnumValue("2") PREPAY,
    @XmlEnumValue("4") GUARANTEE
}
