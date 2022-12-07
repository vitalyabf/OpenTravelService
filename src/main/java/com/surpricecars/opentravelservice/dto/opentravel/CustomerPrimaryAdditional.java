package com.surpricecars.opentravelservice.dto.opentravel;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import jakarta.xml.bind.annotation.XmlElement;
import java.util.List;

@Getter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerPrimaryAdditional {

    // Elements
    @XmlElement(name = "Additional")
    private List<Driver> additionalDrivers; // Information on additional driver(s), possibly including frequent renter number.
    @XmlElement(name = "Primary", required = true)
    private Driver primaryDriver; // Information on the primary driver, possibly including frequent renter number.
}
