package com.surpricecars.opentravelservice.dto.fleet;

import jakarta.xml.bind.annotation.XmlElement;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class AvailabilityResponse {
    @XmlElement(name = "return")
    private FleetCarGroupAvailabilityInfoWrapper wrapper;
}
