package com.surpricecars.opentravelservice.dto.fleet;

import com.surpricecars.opentravelservice.services.adapters.LocalDateAdapter;
import com.surpricecars.opentravelservice.services.adapters.LocalTimeAdapter;
import com.surpricecars.opentravelservice.services.validation.Valid;
import lombok.*;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@XmlRootElement(name="priceparameters")
@XmlAccessorType(XmlAccessType.FIELD)
public class FleetPriceParameters implements Serializable, Valid<FleetPriceParameters> {

    @XmlElement(name = "id", required = true)
    private String id;
    @XmlElement(name = "age", required = true)
    private int age;
    @XmlElement(name = "pickuplocationcode", required = true)
    private int pickupLocationCode;
    @XmlElement(name = "pickupdate", required = true)
    @XmlJavaTypeAdapter(type = LocalDate.class, value = LocalDateAdapter.class)
    private LocalDate pickupDate;
    @XmlElement(name = "pickuptime", required = true)
    @XmlJavaTypeAdapter(type = LocalTime.class, value = LocalTimeAdapter.class)
    private LocalTime pickupTime;
    @XmlElement(name = "returnlocationcode", required = true)
    private int returnLocationCode;
    @XmlElement(name = "returndate", required = true)
    @XmlJavaTypeAdapter(type = LocalDate.class, value = LocalDateAdapter.class)
    private LocalDate returnDate;
    @XmlElement(name = "returntime", required = true)
    @XmlJavaTypeAdapter(type = LocalTime.class, value = LocalTimeAdapter.class)
    private LocalTime returnTime;
    @XmlElement(name = "vehiclegroup")
    private String vehicleGroup;

}
