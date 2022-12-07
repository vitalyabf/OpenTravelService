package com.surpricecars.opentravelservice.dto.opentravel;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import lombok.*;

import jakarta.xml.bind.annotation.XmlAttribute;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@XmlAccessorType(XmlAccessType.FIELD)
public class Coverage_Details {

    // Attributes
    @XmlAttribute(name = "CoverageTextType")
    private String coverageTextType; // The CoverageTextType identifes the type of free text that is provided as part of coverage (insurance) information.The CoverageTextSimpleType simple type identifes the type of free text that is provided as part of coverage (insurance) information.
    @XmlAttribute(name = "Formatted")
    private String Formatted; // Textual information, which may be formatted as a line of information, or unformatted, as a paragraph of text.
}
