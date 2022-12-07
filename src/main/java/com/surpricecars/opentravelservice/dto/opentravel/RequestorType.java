package com.surpricecars.opentravelservice.dto.opentravel;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;

@XmlType
@XmlEnum
public enum RequestorType {
    @XmlEnumValue("5") TRAVEL_AGENCY,
    @XmlEnumValue("6") AIRLINE,
    @XmlEnumValue("22") ELECTRONIC_RESERVATION_SERVICE_PROVIDER,
    @XmlEnumValue("28") ALLIANCE,
    @XmlEnumValue("29") BOOKING_AGENCY;
}
