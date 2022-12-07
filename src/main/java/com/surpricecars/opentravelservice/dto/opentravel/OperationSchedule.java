package com.surpricecars.opentravelservice.dto.opentravel;

import com.surpricecars.opentravelservice.services.adapters.LocalTimeAdapter;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import lombok.*;

import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@XmlAccessorType(XmlAccessType.FIELD)
public class OperationSchedule {

    // Attributes
    @XmlAttribute(name = "Start")
    @XmlJavaTypeAdapter(type = LocalTime.class, value = LocalTimeAdapter.class)
    private LocalTime start;
    @XmlAttribute(name = "End")
    @XmlJavaTypeAdapter(type = LocalTime.class, value = LocalTimeAdapter.class)
    private LocalTime end;

    @XmlElementWrapper(name = "OperationTimes")
    @XmlElement(name = "OperationTime")
    private List<OpenTravelOperationTime> operationTimes;

    public OperationSchedule(List<OpenTravelOperationTime> operationTimes) {
        this.operationTimes = operationTimes;
    }
}
