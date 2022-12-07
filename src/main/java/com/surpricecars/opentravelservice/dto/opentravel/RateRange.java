package com.surpricecars.opentravelservice.dto.opentravel;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@ToString
@XmlAccessorType(XmlAccessType.FIELD)
public class RateRange {

    // Attributes
    @XmlAttribute(name = "CurrencyCode")
    private String currencyCode; // An ISO 4217 (3) alpha character code that specifies a monetary unit.
    @XmlAttribute(name = "DecimalPlaces")
    private int decimalPlaces; // The ISO 4217 standard "minor unit" for the number of decimal places for a particular currency.
    @XmlAttribute(name = "FixedRate")
    private Double fixedRate; // The rate amount used in place of MinRate and MaxRate when a specific rate is being requested.
    @XmlAttribute(name = "MaxRate")
    private Double maxRate; // A decimal value that indicates the maximum monetary value to be considered in a request for an available product.
    @XmlAttribute(name = "MinRate")
    private Double minRate; // A decimal value that indicates the minimum monetary value to be considered in a request for an available product.
    @XmlAttribute(name = "RateTimeUnit")
    private String rateTimeUnit; // Used to specify the period of time to which the rates apply.
}
