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
public class VehiclePreference {

    // Elements
    @XmlElement(name = "VehClass")
    private String vehClass; // The class of vehicle, for example, intermediate, compact.
    @XmlElement(name = "VehMakeModel")
    private String vehMakeModel; // The make and model of the vehicle (e.g., Ford Focus). The Code attribute may be used for the SIPP code.
    @XmlElement(name = "VehType")
    private String vehType; // The type of vehicle, for example, truck, car.

    // Attributes
    @XmlAttribute(name = "AirConditionInd")
    private Boolean airConditionInd;
    @XmlAttribute(name = "AirConditionPref")
    private String airConditionPref;
    @XmlAttribute(name = "ClassPref")
    private String classPref;
    @XmlAttribute(name = "DriveType")
    private String driveType; // Used to define the drive type of a vehicle.
    @XmlAttribute(name = "FuelType")
    private String fuelType; //	The kind of fuel the vehicle uses.
    @XmlAttribute(name = "TransmissionPref")
    private String transmissionPref;
    @XmlAttribute(name = "TransmissionType")
    private String transmissionType; // The VehicleTransmissionSimpleType simple type defines a set of valid values for the transmission type of a vehicle. The valid values are automatic and manual. Use of this attribute can help in describing a vehicle.
    @XmlAttribute(name = "TypePref")
    private String typePref;
    @XmlAttribute(name = "UpSellInd")
    private Boolean upSellInd; // When true, a higher class of vehicle than those specified, may be returned.
    @XmlAttribute(name = "VehicleQty")
    private int vehicleQuantity; // The total number of cars a customer is eventually interested in reserving. This is not used by suppliers and is in no way intended to imply that multiple cars may be booked in a single reservation.
    @XmlAttribute(name = "VendorCarType")
    private String vendorCarType; // An internal car type assigned by the vendor. This is not the SIPP code.
    @XmlAttribute(name = "Code")
    private String code; // Any code used to specify an item, for example, type of traveler, service code, room amenity, etc.
    @XmlAttribute(name = "CodeContext")
    private String codeContext; // Identifies the source authority for the code.
}
