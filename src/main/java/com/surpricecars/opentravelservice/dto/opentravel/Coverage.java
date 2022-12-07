package com.surpricecars.opentravelservice.dto.opentravel;

import jakarta.validation.constraints.NotNull;
import jakarta.xml.bind.annotation.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@XmlAccessorType(XmlAccessType.FIELD)
public class Coverage {

    // Elements
    @XmlElement(name = "Details")
    private List<Coverage_Details> details; // Textual information about coverage, such as coverage limit or descriptions.The CoverageDetailsType complex type provides information on a specfic aspect of coverage, for example, supplemental coverage, description, etc.

    // Attributes
    @XmlAttribute(name = "CoverageType")
    private OpenTravelVehicleCoverageType coverageType; // Identifies the type of coverage, for example, collision damage waiver. Refer to OpenTravel Code List Vehicle Coverage Type (VCT).

    public Coverage(OpenTravelVehicleCoverageType coverageType) {
        this.coverageType = coverageType;
    }

    public void addDetails(String coverageTextType, String text) {
        if (details == null) {
            details = new ArrayList<>();
        }
        details.add(new Coverage_Details(coverageTextType, text));
    }

}
