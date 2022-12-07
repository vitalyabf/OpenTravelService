package com.surpricecars.opentravelservice.dto.opentravel;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import jakarta.xml.bind.annotation.XmlAttribute;

@Getter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@XmlAccessorType(XmlAccessType.FIELD)
public class CoveragePreference {

    // Attributes
    @XmlAttribute(name = "Code")
    private String code; // Allows for an industry-specific code that describes this coverage to be specified, for example, CDW may be indicated when the coverage type is Collision Damage Waiver.
    @XmlAttribute(name = "CoverageType", required = true)
    private String coverageType; // Identifies the type of coverage, for example, collision damage waiver. Refer to OpenTravel Code List Vehicle Coverage Type (VCT).
    @XmlAttribute(name = "PreferLevel")
    private String preferLevel; // Used to indicate a level of preference for an associated item.
}
