package com.surpricecars.opentravelservice.dto.fleet;

import jakarta.xml.bind.annotation.XmlElement;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@NoArgsConstructor
@Getter
@ToString
public class FleetCarGroupAvailabilityInfoWrapper {
    @XmlElement(name = "item")
    private List<FleetCarGroupAvailabilityInfo> item;
}
