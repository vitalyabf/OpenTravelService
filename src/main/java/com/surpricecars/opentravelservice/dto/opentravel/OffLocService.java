package com.surpricecars.opentravelservice.dto.opentravel;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;

@Getter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@XmlAccessorType(XmlAccessType.FIELD)
public class OffLocService {

    // Elements
    @XmlElement(name = "Address")
    private String address; // The address for vehicle delivery or collection, or for customer pickup or drop-off.
    @XmlElement(name = "PersonName")
    private String personName; // Name for the contact person for the off location service.This provides name information for a person.
    @XmlElement(name = "Telephone")
    private String telephone; // Phone number for the contact person for the off location service.
    @XmlElement(name = "TrackingID")
    private String trackingID; // Can be used as a tracking number for delivery and collection.An identifier used to uniquely reference an object in a system (e.g. an airline reservation reference, customer profile reference, booking confirmation number, or a reference to a previous availability quote).

    //Attributes
    @XmlAttribute(name = "SpecInstructions")
    private String instructions; //	Provides special instructions regarding the off location service (e.g., keys with receptionist).
    @XmlAttribute(name = "Type", required = true)
    private String type; //	The OffLocationServiceType simple type defines a set of valid values for the services that do not occur at the rental facility.

}
