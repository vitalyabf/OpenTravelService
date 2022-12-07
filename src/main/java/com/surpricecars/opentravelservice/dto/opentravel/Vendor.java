package com.surpricecars.opentravelservice.dto.opentravel;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import lombok.*;

import jakarta.xml.bind.annotation.XmlAttribute;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@XmlAccessorType(XmlAccessType.FIELD)
public class Vendor {

    // Attributes
    @XmlAttribute(name = "Code")
    private String code;
    @XmlAttribute(name = "CompanyShortName")
    private String CompanyShortName;

    public Vendor(String companyCode, String companyName) {
        this.code = companyCode;
        this.CompanyShortName = companyName;
    }
}
