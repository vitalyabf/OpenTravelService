package com.surpricecars.opentravelservice.dto.opentravel;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import lombok.*;

import java.time.LocalTime;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@XmlAccessorType(XmlAccessType.FIELD)
public class OpenTravelOperationTime {

    // Attributes
    private LocalTime Start;
    private LocalTime End;
    private Boolean Mon = false;
    private Boolean Tue = false;
    private Boolean Weds = false;
    private Boolean Thur = false;
    private Boolean Fri = false;
    private Boolean Sun = false;
    private Boolean Sat = false;

    public OpenTravelOperationTime() {
        Mon = false;
        Tue = false;
        Weds = false;
        Thur = false;
        Fri = false;
        Sun = false;
        Sat = false;
    }
}
