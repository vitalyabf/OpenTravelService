package com.surpricecars.opentravelservice.dto.fleet;

import lombok.*;

import jakarta.xml.bind.annotation.*;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@XmlRootElement(name = "tpa")
@XmlAccessorType(XmlAccessType.FIELD)
public class FleetTradingPartnerAgreement {

    @XmlElement(name = "MinimumAge")
    private int minAge;
    @XmlElement(name = "MaximumAge")
    private int maxAge;

}
