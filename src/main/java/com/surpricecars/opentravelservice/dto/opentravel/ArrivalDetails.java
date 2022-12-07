package com.surpricecars.opentravelservice.dto.opentravel;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;

@Getter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@XmlAccessorType(XmlAccessType.FIELD)
public class ArrivalDetails {

    // Elements
    @XmlElement(name = "ArrivalLocation")
    private OpenTravelLocation arrivalLocation; //  Arrival point of the associated transportation.Code and optional string to describe a location point.
    @XmlElement(name = "MarketingCompany")
    private String marketingCompany; // Identification of the company marketing the transportationIdentifies a company by name.
    @XmlElement(name = "OperatingCompany")
    private String operatingCompany; // Identification of the company operating the transportationIdentifies a company by name.

    // Attributes
//    @XmlAttribute(name = "ArrivalDateTime")
//    @XmlJavaTypeAdapter(type = LocalDateTime.class, value = LocalDateTimeAdapter.class)
//    private LocalDateTime arrivalDateTime;
    @XmlAttribute(name = "Number")
    private String number; // Often used in conjunction with TransportationCode to provide greater detail regarding the customer's arrival (e.g., an airline flight number).
    @XmlAttribute(name = "TransportationCode")
    private String transportationCode; // Refer to OpenTravel Code List Transportation Code (TRP).
}
