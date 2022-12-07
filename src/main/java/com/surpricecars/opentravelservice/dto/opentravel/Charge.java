package com.surpricecars.opentravelservice.dto.opentravel;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import lombok.*;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@XmlAccessorType(XmlAccessType.FIELD)
public class Charge {

    // Elements
    @XmlElement(name = "Calculation")
    private List<Calculation> calculations;

    // Attributes
    @XmlAttribute(name = "Amount")
    private Double amount;
    @XmlAttribute(name = "CurrencyCode")
    private String currency;
    @XmlAttribute(name = "Description")
    private String description;
    @XmlAttribute(name = "IncludedInEstTotalInd")
    private Boolean includedInEstTotal;
    @XmlAttribute(name = "IncludedInRate")
    private Boolean includedInRate;

    @XmlAttribute(name = "TaxInclusive")
    private Boolean taxInclusive;

    public Charge(String description, Double amount, String currency, Boolean includedInEstTotal, Boolean includedInRate, Boolean taxInclusive) {
        this.amount = amount;
        this.currency = currency;
        this.description = description;
        this.includedInEstTotal = includedInEstTotal;
        this.includedInRate = includedInRate;
        this.taxInclusive = taxInclusive;
    }

    public void addCalculation(Calculation calculation) {
        if (calculations == null) {
            this.calculations = new ArrayList<>();
        }
        calculations.add(calculation);
    }
}
