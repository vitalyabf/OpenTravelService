package com.surpricecars.opentravelservice.dto.opentravel;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import lombok.*;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@XmlAccessorType(XmlAccessType.FIELD)
public class PricedEquipment {

    // Elements
    @XmlElement(name = "Equipment", required = true)
    private Equipment equipment; // Details about a equipment, such as text or description.The VehicleEquipmentType complex type identifies the data that fully describes a piece of special equipment, including the description and any restrictions that may apply to its rental.
    @XmlElement(name = "Charge", required = true)
    private Charge charge; // The charges as they relate to a single piece of equipment, such as minimum or maximum amounts, taxes, or information on how the charge was calculated.Identifies specific charges.

    // Attributes
    @XmlAttribute(name = "Required")
    private Boolean required; // An indication if this particular equipment is required in the vehicle reservation, or is optional, based upon renter preference.
}
