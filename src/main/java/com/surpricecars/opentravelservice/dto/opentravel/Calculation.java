package com.surpricecars.opentravelservice.dto.opentravel;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import lombok.*;

import jakarta.xml.bind.annotation.XmlAttribute;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@XmlAccessorType(XmlAccessType.FIELD)
public class Calculation {

    // Attributes
    @XmlAttribute(name = "Quantity")
    private int quantity;
    @XmlAttribute(name = "UnitCharge")
    private Double unitCharge;
    @XmlAttribute(name = "UnitName")
    private VehicleUnitCharge unitName;
    @XmlAttribute(name = "MaxQuantity")
    private int maxQuantity;
    @XmlAttribute(name = "Percentage")
    private String percentage;

    public Calculation(int quantity, Double unitCharge, VehicleUnitCharge unitName) {
        this.quantity = quantity;
        this.unitCharge = unitCharge;
        this.unitName = unitName;
    }
}
