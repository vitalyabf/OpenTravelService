package com.surpricecars.opentravelservice.dto.opentravel;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.xml.bind.annotation.XmlAttribute;

@Getter
@NoArgsConstructor
@EqualsAndHashCode
@XmlAccessorType(XmlAccessType.FIELD)
public class EquipmentPreference {

    // Attributes
    @XmlAttribute(name = "Action")
    private String action; // Identifes an action to take place. Typically used to modify the EquipType and/or Quantity.Identifies an action to take place.
    @XmlAttribute(name = "EquipType", required = true)
    private String equipType; // Identifies the specific type of special equipment. Refer to OpenTravel Code List Equipment Type (EQP).
    @XmlAttribute(name = "PreferLevel")
    private String preferLevel; // Used to indicate a level of preference for an associated item.
    @XmlAttribute(name = "Quantity")
    private int quantity;
}
