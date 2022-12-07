package com.surpricecars.opentravelservice.dto.opentravel;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import lombok.*;

import jakarta.xml.bind.annotation.XmlAttribute;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@XmlAccessorType(XmlAccessType.FIELD)
public class CompanyName {

    //Attributes
    @XmlAttribute(name = "Department")
    private String department;
    @XmlAttribute(name = "Division")
    private String division;
    @XmlAttribute(name = "Code")
    private String Code;
    @XmlAttribute(name = "CodeContext")
    private String CodeContext;
    @XmlAttribute(name = "CompanyShortName")
    private String CompanyShortName;
    @XmlAttribute(name = "CountryCode")
    private String CountryCode;
    @XmlAttribute(name = "TravelSector")
    private String TravelSector;
}
