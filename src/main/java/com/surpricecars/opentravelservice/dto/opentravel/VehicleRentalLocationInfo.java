package com.surpricecars.opentravelservice.dto.opentravel;

import jakarta.xml.bind.annotation.*;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@XmlAccessorType(XmlAccessType.FIELD)
public class VehicleRentalLocationInfo {

    // Elements
    @XmlElementWrapper(name = "SubSection")
    @XmlElement(name = "Paragraph")
    private List<Paragraph> sections;

    // Attributes
    @XmlAttribute(name = "Title")
    @Length(max = 64)
    private String title;
    @XmlAttribute(name = "Type", required = true)
    private VehicleLocationInformationType type;

    public void addSection(Paragraph paragraph) {
        if (sections == null) {
            sections = new ArrayList<>();
        }
        sections.add(paragraph);
    }
}
