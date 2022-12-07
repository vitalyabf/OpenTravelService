package com.surpricecars.opentravelservice.dto.opentravel;

import com.surpricecars.opentravelservice.services.adapters.OpenTravelLocalDateTimeAdapter;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import lombok.*;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@XmlAccessorType(XmlAccessType.FIELD)
public class VehRentalCore {
    // Elements
    @XmlElement(name = "PickUpLocation")
    private List<OpenTravelLocation> pickUpLocations;
    @XmlElement(name = "ReturnLocation")
    private OpenTravelLocation returnLocation;

    // Attributes
    @XmlAttribute(name = "DistUnitName")
    private String distUnitName;
    @XmlAttribute(name = "MultiIslandRentalDays")
    private int multiIslandRentalDays;
    @XmlAttribute(name = "OneWayIndicator")
    private Boolean oneWay;
    @XmlJavaTypeAdapter(type = LocalDateTime.class, value = OpenTravelLocalDateTimeAdapter.class)
    @XmlAttribute(name = "PickUpDateTime")
    private LocalDateTime pickUpDateTime;
    @XmlAttribute(name = "Quantity")
    private Double quantity;
    @XmlJavaTypeAdapter(type = LocalDateTime.class, value = OpenTravelLocalDateTimeAdapter.class)
    @XmlAttribute(name = "ReturnDateTime")
    private LocalDateTime returnDateTime;
    @XmlJavaTypeAdapter(type = LocalDateTime.class, value = OpenTravelLocalDateTimeAdapter.class)
    @XmlAttribute(name = "StartChargesDateTime")
    private LocalDateTime startChargesDateTime;
    @XmlJavaTypeAdapter(type = LocalDateTime.class, value = OpenTravelLocalDateTimeAdapter.class)
    @XmlAttribute(name = "StopChargesDateTime")
    private LocalDateTime stopChargesDateTime;
}
