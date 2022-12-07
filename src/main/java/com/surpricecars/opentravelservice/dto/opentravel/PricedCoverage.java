package com.surpricecars.opentravelservice.dto.opentravel;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import lombok.*;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@XmlAccessorType(XmlAccessType.FIELD)
public class PricedCoverage {

    // Elements
    @XmlElement(name = "Coverage")
    private Coverage coverage; // Details about a coverage, such as text or description.The CoverageType complex type describes the data that is needed to fully describe a vehicle coverage, including the core details along with optional descriptions.
    @XmlElement(name = "Charge")
    private Charge charge; // The charges as they relate to a single coverage, such as minimum or maximum amounts, taxes, or information on how the charge was calculated.Identifies specific charges.

    // Attributes
    @XmlAttribute(name = "Required")
    private Boolean required;
}
