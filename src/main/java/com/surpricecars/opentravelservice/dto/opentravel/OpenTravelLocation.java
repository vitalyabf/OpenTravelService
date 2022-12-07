package com.surpricecars.opentravelservice.dto.opentravel;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import lombok.*;

import jakarta.xml.bind.annotation.XmlAttribute;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@XmlAccessorType(XmlAccessType.FIELD)
public class OpenTravelLocation {

    // Attributes
    @XmlAttribute(name = "CodeContext")
    private String codeContext;
    @XmlAttribute(name = "LocationCode")
    private String locationCode;
    @XmlAttribute(name = "ExtendedLocationCode")
    private String extendedLocationCode;

}
