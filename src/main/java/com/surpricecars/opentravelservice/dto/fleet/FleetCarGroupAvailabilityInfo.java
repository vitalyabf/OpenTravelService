package com.surpricecars.opentravelservice.dto.fleet;

import lombok.*;

import jakarta.xml.bind.annotation.*;
import java.util.List;
import java.util.function.Predicate;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@XmlRootElement(name = "item")
@XmlAccessorType(XmlAccessType.FIELD)
public class FleetCarGroupAvailabilityInfo {

    // Elements
    @XmlElement(name = "status")
    private Boolean status;
    @XmlElement(name = "status_message")
    private String statusMessage;
    @XmlElement(name = "model")
    private FleetModel model;
    @XmlElement(name = "charge")
    private FleetCharge charge;
    @XmlElementWrapper(name = "extras")
    @XmlElement(name = "item")
    private List<FleetExtra> extras;
    @XmlElement(name = "oneWayArea")
    private String oneWayArea;
    @XmlElement(name = "oneWayRegion")
    private String oneWayRegion;
    @XmlElement(name = "termsConditions")
//    private FleetTermsConditions termsConditions;
//    @XmlElement(name = "tpa")
    private FleetTradingPartnerAgreement TPA;
    @XmlElementWrapper(name = "locations")
    @XmlElement(name = "item")
    private List<FleetLocationDetails> locations;

    public FleetLocationDetails getReturnLocation() {
        Predicate<FleetLocationDetails> returnStage = (FleetLocationDetails l) -> l.getAttributes().getStage() == FleetLocationStage.DropOff;
        final FleetLocationDetails location = getLocations().stream().filter(returnStage).findFirst().orElse(null);
        return location;
    }

    public FleetLocationDetails getPickUpLocation() {
        Predicate<FleetLocationDetails> returnStage = (FleetLocationDetails l) -> l.getAttributes().getStage() == FleetLocationStage.PickUp;
        final FleetLocationDetails location = getLocations().stream().filter(returnStage).findFirst().orElse(null);
        return location;
    }
}
