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
public class VehVendorAvail_Info {
    // Elements
    @XmlElement(name = "locationDetails")
    private List<OpenTravelLocationDetails> locationDetails; // Detailed information about the associated rental facilities, for example, address, phone number, hours of operation.The VehicleLocationDetailsType complex type defines the core information that describes a vehicle rental facility. Such information may include the code of the facility, the name assigned to that facility, the address and telephone number of the facility.
    @XmlElementWrapper(name = "VendorMessages")
    @XmlElement(name = "VendorMessage", required = true)
    private List<VendorMessage> messages; // A collection of free-format messages associated with this vendor.Collection of vendor messages. A specific message associated with this vendor.Provides formatted textual information that a vendor wishes to make known. The type of information is indicated.
}
