package com.surpricecars.opentravelservice.dto.opentravel;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import lombok.*;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@XmlAccessorType(XmlAccessType.FIELD)
public class Vehicle {

    // Elements
    @XmlElement(name = "VehMakeModel")
    private VehMakeModel vehMakeModel; // The make and model of the vehicle (e.g., Ford Focus). The Code attribute may be used for the SIPP code.
    @XmlElement(name = "VehType")
    private VehType vehType; // The type of vehicle, for example, truck, car.
    @XmlElement(name = "PictureURL")
    private String pictureUrl;

    // Attributes
    @XmlAttribute(name = "Code")
    private String code; // Any code used to specify an item, for example, type of traveler, service code, room amenity, etc.
    @XmlAttribute(name = "VendorCarType")
    private String vendorCarType; // Any code used to specify an item, for example, type of traveler, service code, room amenity, etc.
    @XmlAttribute(name = "CodeContext")
    private String codeContext; // Identifies the source authority for the code.
    @XmlAttribute(name = "PassengerQuantity")
    private int passengerQuantity; // Number of passengers that can be accommodated by this vehicle. This may be an exact number or may be a range, i.e., 4-5, 5-6.
//    @XmlAttribute(name = "BaggageQuantity")
//    private int baggageQuantity; // Number of bags/suitcases that can be accommodated by this vehicle.
//    @XmlAttribute(name = "UnitOfMeasureQuantity")
//    private int unitOfMeasureQuantity; // This is the numeric value associated with the measurement.
//    @XmlAttribute(name = "UnitOfMeasure")
    private String unitOfMeasure; // This is the standard unit of measure name (e.g., it could be generic such as metric or imperial or specific such as inches, feet, yards, miles, millimeters, centimeters, meters, kilometers- according to usage).
    @XmlAttribute(name = "AirConditionInd")
    private Boolean airCondition;
    @XmlAttribute(name = "TransmissionType")
    private OpenTravelTransmissionType transmissionType;
}
