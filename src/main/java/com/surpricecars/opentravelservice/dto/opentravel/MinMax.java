package com.surpricecars.opentravelservice.dto.opentravel;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import lombok.*;

import jakarta.xml.bind.annotation.XmlAttribute;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode
@ToString
@XmlAccessorType(XmlAccessType.FIELD)
public class MinMax {
    // Attributes
    @NonNull
    @XmlAttribute(name = "MinCharge")
    private Double minCharge;
    @NonNull
    @XmlAttribute(name = "MaxCharge")
    private Double maxCharge;
    @XmlAttribute(name = "MaxChargeDays")
    private int maxChargeDays; // 	Maximum number of days for which a charge will be applied.
}
