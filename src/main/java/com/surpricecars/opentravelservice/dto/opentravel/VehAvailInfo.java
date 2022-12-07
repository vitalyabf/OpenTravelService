package com.surpricecars.opentravelservice.dto.opentravel;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import lombok.*;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@XmlAccessorType(XmlAccessType.FIELD)
public class VehAvailInfo {

    // Elements
    @XmlElementWrapper(name = "PricedCoverages")
    @XmlElement(name = "PricedCoverage", required = true)
    private List<PricedCoverage> pricedCoverages; // A collection of coverages, along with associated price and details. One specific vehicle coverage along with the corresponding charge.The CoveragePricedType complex type defines the information that is required to describe a priced coverage, that is, a coverage and a charge.

    @XmlElementWrapper(name = "PaymentRules")
    @XmlElement(name = "PaymentRule")
    private List<PaymentRule> paymentRules;

    public void addPricedCoverage(PricedCoverage pricedCoverage) {
        if (pricedCoverages == null) {
            pricedCoverages = new ArrayList<>();
        }
        pricedCoverages.add(pricedCoverage);
    }

    public void addPaymentRule(PaymentRule paymentRule) {
        if (paymentRules == null) {
            paymentRules = new ArrayList<>();
        }
        paymentRules.add(paymentRule);
    }
}
