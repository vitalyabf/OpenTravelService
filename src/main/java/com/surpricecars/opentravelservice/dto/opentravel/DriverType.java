package com.surpricecars.opentravelservice.dto.opentravel;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@ToString
@XmlAccessorType(XmlAccessType.FIELD)
public class DriverType {

    // Attribute
    @XmlAttribute(name = "Age")
    private int age; // This is used to specify age in years.
    @XmlAttribute(name = "Code")
    private String code; // Refer to OpenTravel Code List Age Qualifying Code (AQC), Rail Passenger Type Code (PXC), or use StringLength1to8 with CodeContext to use a non-OpenTravel Code.
    @XmlAttribute(name = "CodeContext")
    private String codeContext; // Identifies the source authority for the code.
    @XmlAttribute(name = "Quantity")
    private int quantity; // Used to define the quantity for an associated element or attribute.
    @XmlAttribute(name = "URI")
    private String uri; // Identifies the location of the code table.
}
