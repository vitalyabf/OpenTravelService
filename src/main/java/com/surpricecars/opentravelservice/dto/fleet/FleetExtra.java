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
@XmlRootElement(name = "item")
@XmlAccessorType(XmlAccessType.FIELD)
public class FleetExtra {

    // Elements
    @XmlElement(name = "EquipmentId")
    private String equipmentId; // 1
    @XmlElement(name = "Charge")
    private Double charge; // 4
    @XmlElement(name = "PricingPolicy")
    private String pricingPolicy; // per day
    @XmlElement(name = "MaxPrice") // 0
    private Double maxPrice;
    @XmlElement(name = "TotalCharge")
    private Double totalCharge; // 12
    @XmlElement(name = "Prepaid")
    private Boolean prepaid; // 0
    @XmlElement(name = "Description")
    private String description; // babyseats
    @XmlElement(name = "CurrencyCode")
    private String currencyCode; // EUR
    @XmlElement(name = "IncludedInRate")
    private Boolean includedInRate; // 0

}
