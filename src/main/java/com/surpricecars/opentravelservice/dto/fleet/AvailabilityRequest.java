package com.surpricecars.opentravelservice.dto.fleet;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.NoArgsConstructor;

@XmlRootElement(name="getAvailableInfo")
@XmlAccessorType(XmlAccessType.FIELD)
public class AvailabilityRequest {
    @XmlElement(name = "parameters")
    protected FleetPriceParameters parameters;

    public AvailabilityRequest() {
    }

    public AvailabilityRequest(FleetPriceParameters priceParameters) {
        this.parameters = priceParameters;
    }


    public FleetPriceParameters getParameters() {
        return parameters;
    }

    public void setParameters(FleetPriceParameters parameters) {
        this.parameters = parameters;
    }

    @Override
    public String toString() {
        return "AvailabilityRequest{" +
                "priceParameters=" + parameters +
                '}';
    }
}
