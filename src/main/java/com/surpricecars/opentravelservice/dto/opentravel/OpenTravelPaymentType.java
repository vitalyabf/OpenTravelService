package com.surpricecars.opentravelservice.dto.opentravel;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;

@XmlEnum
public enum OpenTravelPaymentType {
    @XmlEnumValue("1") CASH,
    @XmlEnumValue("5") CREDIT_CARD
}
