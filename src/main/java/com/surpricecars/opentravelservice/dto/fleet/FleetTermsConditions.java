package com.surpricecars.opentravelservice.dto.fleet;

import lombok.*;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@XmlRootElement(name = "termsConditions")
@XmlAccessorType(XmlAccessType.FIELD)
public class FleetTermsConditions {

    // Elements
    @XmlElement(name = "title")
    private String title;
    @XmlElement(name = "text")
    private String text;
}
