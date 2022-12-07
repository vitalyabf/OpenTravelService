package com.surpricecars.opentravelservice.dto.opentravel;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;

@XmlEnum
public enum OpenTravelPhoneType {
    @XmlEnumValue("1") VOICE,
    @XmlEnumValue("2") DATA,
    @XmlEnumValue("3") FAX,
    @XmlEnumValue("4") PAGER,
    @XmlEnumValue("5") MOBILE,
    @XmlEnumValue("6") TTY,
    @XmlEnumValue("7") TELEX,
    @XmlEnumValue("8") IP_VOICE
}
