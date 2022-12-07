package com.surpricecars.opentravelservice.dto.fleet;

import com.surpricecars.opentravelservice.services.adapters.DoubleAdapter;
import lombok.*;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@XmlRootElement(name = "charge")
@XmlAccessorType(XmlAccessType.FIELD)
public class FleetCharge {
    // Elements
    @XmlElement(name = "price")
    @XmlJavaTypeAdapter(type = Double.class, value = DoubleAdapter.class)
    private Double price; // 51
    @XmlElement(name = "currency")
    private String currencyCode; // EUR
    @XmlElement(name = "TaxInclusive")
    private Boolean taxInclusive; // 1
}
