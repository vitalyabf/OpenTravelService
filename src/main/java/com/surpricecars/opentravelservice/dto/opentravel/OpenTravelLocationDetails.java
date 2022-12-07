package com.surpricecars.opentravelservice.dto.opentravel;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import lombok.*;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;


import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@RequiredArgsConstructor
@ToString
@XmlAccessorType(XmlAccessType.FIELD)
public class OpenTravelLocationDetails {

    // Elements
    @XmlElement(name = "AdditionalInfo")
    private AdditionalInfo additionalInfo; // Supplemental information about the rental facility.The VehicleLocationAdditionalDetailsType complex type defines the supplemental information that describes a vehicle rental facility. Such information may include the operation schedules and services offered.
    @XmlElement(name = "Address")
    private List<LocationDetails_Address> address; // Information about the physical address of the locationInformation about an address that identifies a location for a specific purposes.
    @XmlElement(name = "Telephone")
    private List<Telephone> telephone; // Information about the telephone numbers for this location.

    // Attributes
    @XmlAttribute(name = "ExtendedLocationCode")
    @NonNull
    private String extendedLocationCode; // Used for extended OAG code in conjunction with the OAG code which is sent in Code.
    @XmlAttribute(name = "AtAirport")
    @NonNull
    private Boolean atAirport; // The AtAirport attribute identifies if the associated rental location serves an airport.
    @XmlAttribute(name = "Name")
    @NonNull
    private String name; // Name used to refer to the car rental location.
}
