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
@XmlRootElement(name = "attr")
@XmlAccessorType(XmlAccessType.FIELD)
public class FleetLocationAttributes {

    // Elements
    @XmlElement(name = "Code")
    private int extendedLocationCode; // 26
    @XmlElement(name = "Name")
    private String name; // Heraklion Airport
    @XmlElement(name = "Stage")
    private FleetLocationStage stage; // pickup
    @XmlElement(name = "AtAirport")
    private Boolean atAirport;
}
