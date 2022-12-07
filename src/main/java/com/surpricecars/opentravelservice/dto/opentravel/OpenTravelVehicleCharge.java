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
public class OpenTravelVehicleCharge {

    // Elements
    @XmlElement(name = "Calculation")
    private List<Calculation> calculations; // Information on how this charge was calculated, for example, a daily rate multiplied by the number of days, a percentage, etc.
    @XmlElement(name = "MinMax")
    private MinMax minMax; // Information on any minimum or maximum amounts, if appropriate.

    // Attributes
    @XmlAttribute(name = "Purpose", required = true)
    private OpenTravelChargePurpose purpose; // Refer to OpenTravel Code List Vehicle Charge Purpose Type (VCP).
    @XmlAttribute(name = "Description")
    private String description;
    @XmlAttribute(name = "Amount")
    private Double amount;
    @XmlAttribute(name = "CurrencyCode")
    private String currency;
    @XmlAttribute(name = "GuaranteedInd")
    private Boolean guaranteed; // 	If TRUE, a guarantee payment or hold is required.
    @XmlAttribute(name = "IncludedInEstTotalInd")
    private Boolean includedInEstTotal; // When true, indicates the item's charges are included in the estimated total amount (in TotalCharge) and when false, the item is not included in the estimated total amount.
    @XmlAttribute(name = "IncludedInRate")
    private Boolean includedInRate;
    @XmlAttribute(name = "TaxInclusive")
    private Boolean taxInclusive;

    public void addCalculation(Calculation calculation) {
        if (calculations == null) {
            this.calculations = new ArrayList<>();
        }
        calculations.add(calculation);
    }

    public OpenTravelVehicleCharge(OpenTravelChargePurpose purpose, String description, Double amount, String currency) {
        this.purpose = purpose;
        this.description = description;
        this.amount = amount;
        this.currency = currency;
        this.guaranteed = guaranteed;
        this.includedInEstTotal = includedInEstTotal;
        this.includedInRate = includedInRate;
        this.taxInclusive = taxInclusive;
    }
}
