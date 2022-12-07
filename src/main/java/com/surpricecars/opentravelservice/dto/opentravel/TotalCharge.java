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
public class TotalCharge {

    // Attributes
    @XmlAttribute(name = "EstimatedTotalAmount")
    private Double estimatedTotalAmount; // Total rental charges including any additional mandatory charges (e.g., taxes).
    @XmlAttribute(name = "RateTotalAmount")
    private Double rateTotalAmount; // Total rental charges excluding any additional mandatory charges.
    @XmlAttribute(name = "CurrencyCode")
    private String currency; // An ISO 4217 (3) alpha character code that specifies a monetary unit.

}
