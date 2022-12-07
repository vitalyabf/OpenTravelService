package com.surpricecars.opentravelservice.dto.opentravel;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
@XmlAccessorType(XmlAccessType.FIELD)
public class VehAvailRSInfo {
    @XmlElement(name = "customer", namespace = "ot:service")
    private CustomerPrimaryAdditional customer; // Information on the one primary driver and, optionally, several additional drivers. This may be used to provide a frequent renter number.Information on the one primary driver and, optionally, several additional drivers. This may be used to provide a frequent renter number.
}
