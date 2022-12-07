package com.surpricecars.opentravelservice.dto.fleet;

import com.surpricecars.opentravelservice.services.adapters.DayOfWeekAdapter;
import com.surpricecars.opentravelservice.services.adapters.LocalTimeAdapter;
import lombok.*;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.DayOfWeek;
import java.time.LocalTime;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement(name = "item")
@XmlAccessorType(XmlAccessType.FIELD)
public class FleetWorkHours {

    // Elements
    @XmlElement(name = "Day")
    @XmlJavaTypeAdapter(type = DayOfWeek.class, value = DayOfWeekAdapter.class)
    private DayOfWeek day; // Mon
    @XmlElement(name = "Start")
    @XmlJavaTypeAdapter(type = LocalTime.class, value = LocalTimeAdapter.class)
    private LocalTime start; // 07:00:00
    @XmlElement(name = "End")
    @XmlJavaTypeAdapter(type = LocalTime.class, value = LocalTimeAdapter.class)
    private LocalTime end; // 22:00:00
}
