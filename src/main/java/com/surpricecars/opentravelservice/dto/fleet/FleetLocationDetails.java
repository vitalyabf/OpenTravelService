package com.surpricecars.opentravelservice.dto.fleet;

import lombok.*;

import jakarta.xml.bind.annotation.*;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@XmlRootElement(name = "item")
@XmlAccessorType(XmlAccessType.FIELD)
public class FleetLocationDetails {

    // Elements
    @XmlElement(name = "attr")
    private FleetLocationAttributes attributes;
    @XmlElement(name = "address")
    private FleetAddress address;
    @XmlElementWrapper(name = "work_hours")
    @XmlElement(name = "item")
    private List<FleetWorkHours> workHours;
}
