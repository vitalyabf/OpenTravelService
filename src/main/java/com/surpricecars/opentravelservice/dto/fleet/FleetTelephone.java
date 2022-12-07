package com.surpricecars.opentravelservice.dto.fleet;

import lombok.*;

import jakarta.xml.bind.annotation.*;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@XmlRootElement(name = "item")
@XmlAccessorType(XmlAccessType.FIELD)
public class FleetTelephone {

    // Elements
    @XmlElement(name = "number")
    private String number; // 00306984631835
}
