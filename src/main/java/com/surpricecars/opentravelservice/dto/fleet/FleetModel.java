package com.surpricecars.opentravelservice.dto.fleet;

import jakarta.xml.bind.annotation.*;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@XmlRootElement(name = "model")
@XmlAccessorType(XmlAccessType.FIELD)
public class FleetModel {

    private final static String codeContext = "ACRISS";

    // Elements
    @XmlElement(name = "SIPPCode")
    private String vehicleCode; // HDMR
    @XmlElement(name = "cgroup")
    private String vehicleGroup; // "B1"
    @XmlElement(name = "aircondition")
    private Boolean airCondition; // 1
    @XmlElement(name ="persons")
    private int passengers; // 4
    @XmlElement(name = "radiocd")
    private Boolean radioCD; // 1
    @XmlElement(name = "doors")
    private int doors;  // 4
    @XmlElement(name = "TransmissionType")
    private FleetTransmissionType transmissionType; // M
    @XmlElement(name = "type")
    private String modelName; // Suzuki Swift, Hyundai i10 or similar
    @XmlElement(name ="cc")
    private int vehicleSubgroup; // 1100
    @XmlElement(name = "cdw")
    private double collisionDamageWaiver; // 800
    @XmlElement(name = "fdw_o_excess")
    private double fullDamageWaiver; // 16
    @XmlElement(name ="size")
    private String size; //Economy Elite
    @XmlElement(name = "photo_url")
    private String photoUrl; // https://www.surpricecars.com/images/carphotos/B1_SuzukiSwift_GR.jpg

    public static String getCodeContext() {
        return codeContext;
    }
}
