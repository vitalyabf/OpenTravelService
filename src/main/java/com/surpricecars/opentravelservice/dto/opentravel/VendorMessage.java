package com.surpricecars.opentravelservice.dto.opentravel;

import jakarta.xml.bind.annotation.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@XmlAccessorType(XmlAccessType.FIELD)
public class VendorMessage {

    // Elements
    @XmlElementWrapper(name = "SubSection", required = true)
    @XmlElement(name = "Paragraph", required = true)
    private List<Paragraph> paragraphs;
    // Attributes
    @XmlAttribute(name = "InfoType", required = true)
    private String infoType;
}
