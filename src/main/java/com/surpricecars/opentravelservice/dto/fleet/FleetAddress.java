package com.surpricecars.opentravelservice.dto.fleet;

import lombok.*;

import jakarta.xml.bind.annotation.*;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@XmlRootElement(name = "address")
@XmlAccessorType(XmlAccessType.FIELD)
public class FleetAddress {

    // Elements
    @XmlElement(name = "AddressLine")
    private String AddressLine; // Heraklion International Airport N. Kazantzakis 71601 Heraklion Crete (35.336087 , 25.172282)
    @XmlElement(name = "CityName")
    private String cityName; // Heraklion
    @XmlElement(name = "PostalCode")
    private String postalCode; // 71306
    @XmlElement(name = "CountryName")
    private String countryName;
    @XmlElementWrapper(name = "Telephone")
    @XmlElement(name = "item")
    private List<FleetTelephone> telephones;
    @XmlElement(name = "MeetingPoint")
    private String meetingPoint; // The customer will walk to the parking lot,50 meters opposite from the airport building and then he will be transferred to our office, which is 700 meters away, with shuttle bus

}
