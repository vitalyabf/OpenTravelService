package com.surpricecars.opentravelservice.dto.opentravel;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class PaymentRule {

    // Attributes
    @XmlAttribute(name = "RuleType")
    private OpenTravelPaymentRuleType ruleType;
    @XmlAttribute(name = "PaymentType")
    private OpenTravelPaymentType paymentType;
    @XmlAttribute(name = "Amount")
    private Double amount;
    @XmlAttribute(name = "CurrencyCode")
    private String currencyCode;

    public PaymentRule(OpenTravelPaymentRuleType ruleType, OpenTravelPaymentType paymentType) {
        this.ruleType = ruleType;
        this.paymentType = paymentType;
    }
}
