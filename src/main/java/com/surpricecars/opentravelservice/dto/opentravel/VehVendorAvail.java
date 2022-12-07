package com.surpricecars.opentravelservice.dto.opentravel;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import lombok.*;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@XmlAccessorType(XmlAccessType.FIELD)
public class VehVendorAvail {
    // Elements
    @XmlElement(name = "Info")
    private VehVendorAvail_Info info; // Supplemental information associated with the vendor and the availability of the vehicles.The VehicleAvailVendorInfoType complex type identifies the data that describes supplemental information relevant to a vendor and made available at the time that availability and rates are checked.
    @XmlElementWrapper(name = "VehAvails", required = true)
    @XmlElement(name = "VehAvail", required = true)
    private List<VehAvail> vehAvails; // A collection of vehicles along with their availability and associated rate information.
    @XmlElement(name = "Vendor")
    private Vendor vendor; // Information on the vendor associated with this availability of vehicles.Identifies a company by name.


}
