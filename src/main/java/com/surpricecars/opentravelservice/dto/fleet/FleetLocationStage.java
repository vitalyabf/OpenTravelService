package com.surpricecars.opentravelservice.dto.fleet;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;

@XmlEnum
public enum FleetLocationStage {
    @XmlEnumValue("pickup") PickUp,
    @XmlEnumValue("dropoff") DropOff,
}
