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
public class Source {

    // Elements
//    @XmlElement(name = "BookingChannel")
//    private BookingChannel bookingChannel;
//    @XmlElement(name = "Position")
//    private Position position;
    @XmlElement(name = "RequestorID")
    private RequestorID requestorID;
    @XmlElement(name = "TPA_Extensions")
    private TPA_Extension extensions;

    // Attributes
    @XmlAttribute(name = "PseudoCityCode") // An identification code assigned to an office/agency by a reservation system.
    private String pseudoCityCode;
    @XmlAttribute(name = "ISOCountry")	// The country code of the requesting party in ISO 3166-3 encoding.
    private String countryCode;
    @XmlAttribute(name = "ISOCurrency")	// The currency code in which the reservation will be ticketed in ISO 4217-3 encoding.
    private String currencyCode;
    @XmlAttribute(name = "AirlineVendorID")	// The IATA assigned airline code.Used for an Upper Alpha String and Numeric, length 2 to 3.
    private String airlineVendorID;
    @XmlAttribute(name = "AirportCode")	// The IATA assigned airport code.Used for an Upper Alpha String and Numeric, length 3 to 5.
    private String airportCode;

    @XmlAttribute(name = "AgentDutyCode") //An authority code assigned to a requestor.
    private String AgentDutyCode;
    @XmlAttribute(name = "AgentSine") // Identifies the party within the requesting entity.
    private String agentSine;
    @XmlAttribute(name = "ERSP_UserID")	// Electronic Reservation Service Provider (ERSP) assigned identifier used to identify the individual using the ERSP system.
    private String erspUserID;
    @XmlAttribute(name = "FirstDepartPoint") // The point of first departure in a trip.Used for Strings, length exactly 3.
    private String firstDepartPoint;
    @XmlAttribute(name = "TerminalID")	// This is the electronic address of the device from which information is entered.
    private String terminalID;

}
