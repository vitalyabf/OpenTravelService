package com.surpricecars.opentravelservice.dto.opentravel;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import jakarta.xml.bind.annotation.*;
import java.util.List;
import java.util.OptionalInt;

@Getter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
//@XmlRootElement(name = "VehAvailRQCore")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VehAvailRQCore")
public class VehAvailRQCore {

    //Elements
    @XmlElement(name = "DriverType")
    private List<DriverType> driverTypes;
    @XmlElement(name = "MultimodalOffer")
    private String	MultimodalOffer;
    @XmlElement(name = "RateQualifier")
    private List<RateQualifier>	rateQualifiers;
    @XmlElement(name = "RateRange")
    private RateRange rateRange;
    @XmlElementWrapper(name = "SpecialEquipPrefs")
    @XmlElement(name = "SpecialEquipPref", required = true)
    private List<EquipmentPreference> equipmentPreferences;
    @XmlElementWrapper(name = "TPA_Extensions")
    @XmlElement(name = "any", required = true)
    private List<TPA_Extension> extensions;

    @XmlElementWrapper(name = "VehPrefs")
    @XmlElement(name = "VehPref", required = true)
    private List<VehiclePreference> vehPrefs;
    @XmlElement(name = "VehRentalCore", required = true)
    private VehRentalCore vehRentalCore;
    @XmlElementWrapper(name = "VendorPrefs")
    @XmlElement(name = "VendorPref")
    private List<VendorPreference> vendorPreferences;

    //Attributes
    @XmlAttribute(name = "Status")
    private String status;
    @XmlAttribute(name = "TargetSource")
    private String targetSource;

}
