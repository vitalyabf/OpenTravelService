package com.surpricecars.opentravelservice.dto.opentravel;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import lombok.*;

import jakarta.xml.bind.annotation.XmlElement;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@XmlAccessorType(XmlAccessType.FIELD)
public class VehAvail {

    // Elements
    @XmlElement(name = "VehAvailCore", required = true)
    private VehAvailCore vehAvailCore; // The VehicleAvailCoreType complex type identifies the data that describes common, or core, information made available as part of describing the availability and rate of one or more vehicles.The VehicleAvailCoreType complex type identifies the data that describes common, or core, information made available as part of describing the availability and rate of one or more vehicles.
    @XmlElement(name = "VehAvailInfo", required = true)
    private VehAvailInfo vehAvailInfo; // The VehicleAvailAdditionalInfoType complex type identifies the data that describes supplemental information made available as part of describing the availability and rate of one or more vehicles.The VehicleAvailAdditionalInfoType complex type identifies the data that describes supplemental information made available as part of describing the availability and rate of one or more vehicles.

    public VehAvail(VehAvailCore core) {
        this.vehAvailCore = core;
    }
}
