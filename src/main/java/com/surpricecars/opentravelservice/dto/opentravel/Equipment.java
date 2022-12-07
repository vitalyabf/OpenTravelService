package com.surpricecars.opentravelservice.dto.opentravel;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import lombok.*;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@XmlAccessorType(XmlAccessType.FIELD)
public class Equipment {

    // Elements
    @XmlElement(name = "Description")
    private String Description;

    // Attributes
    @XmlAttribute(name = "EquipType", required = true)
    private String EquipType; // Identifies the specific type of special equipment. Refer to OpenTravel Code List Equipment Type (EQP).

}
