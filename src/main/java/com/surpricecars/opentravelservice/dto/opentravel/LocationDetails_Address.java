package com.surpricecars.opentravelservice.dto.opentravel;

import jakarta.xml.bind.annotation.*;
import lombok.*;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@XmlAccessorType(XmlAccessType.FIELD)
public class LocationDetails_Address {

    private static int ADDRESS_LINE_LENGTH = 70;
    // Elements
    @XmlElement(name = "AddressLine")
    private String[] addressLine; // When the address is unformatted (FormattedInd="false") these lines will contain free form address details. When the address is formatted and street number and street name must be sent independently, the street number will be sent using StreetNmbr, and the street name will be sent in the first AddressLine occurrence.
    @XmlElement(name = "PostalCode")
    private String postalCode; // Post Office Code number.
//    @XmlElement(name = "StreetNmbr")
//    private String streetNumber;
    @XmlElement(name = "CityName")
    private String cityName;
//    @XmlElementWrapper(name = "StateProv")
//    @XmlElement(name = "StateCode")
//    private String stateProvince; // State or Province name (e.g., Texas).State, province, or region name or code needed to identify location.
    @XmlElement(name = "CountryName")
    private String country; // 	Country name (e.g., Ireland).The name or code of a country (e.g. as used in an address or to specify citizenship of a traveller). ISO 3166 code for a country.

    // Attributes
    @XmlAttribute(name = "FormattedInd")
    private Boolean FormattedInd; // Specifies if the associated data is formatted or not. When true, then it is formatted; when false, then not formatted.

    public LocationDetails_Address(String addressLine, String postalCode, String cityName, String country, Boolean formattedInd) {

        this.addressLine = addressLine.split("(?<=\\G.{" + ADDRESS_LINE_LENGTH + "})");
        this.postalCode = postalCode;
        this.cityName = cityName;
        this.country = country;
        FormattedInd = formattedInd;
    }
}
