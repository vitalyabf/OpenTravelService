package com.surpricecars.opentravelservice.dto.opentravel;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import lombok.*;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@XmlAccessorType(XmlAccessType.FIELD)
public class VehAvailRSCore {

    @XmlElement(name = "VehRentalCore", required = true)
    private VehRentalCore vehRentalCore; // Information that is common, or core, to all requests and responses associated with the reservation of a vehicle.The VehicleRentalCoreType complex type identifies the data that is common, or core, to almost every transaction associated with the rental of a vehicle.
    @XmlElementWrapper(name = "VehVendorAvails", required = true)
    @XmlElement(name = "VehVendorAvail", required = true)
    private List<VehVendorAvail> vehVendorAvails; // A collection of vendors for which vehicle availability is available.

}
