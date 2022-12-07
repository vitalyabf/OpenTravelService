package com.surpricecars.opentravelservice.dto.opentravel;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import lombok.*;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@XmlAccessorType(XmlAccessType.FIELD)
public class AdditionalInfo {


    // Elements
    @XmlElementWrapper(name = "OperationSchedules")
    @XmlElement(name = "OperationSchedule", required = true)
    private List<OperationSchedule> operationSchedule; // A collection of operation schedules, used to define the hours of operation for this rental facility.Collection of operation schedules.

    @XmlElementWrapper(name = "VehRentLocInfos")
    @XmlElement(name = "VehRentLocInfo")
    private List<VehicleRentalLocationInfo> vehicleRentalLocationInfoList; // Descriptive information of one specific aspect of the rental location.Provides formatted textual information relating to the vehicle rental location. The type of information is indicated in the @Type attribute that contains a value from the OpenTravel Vehicle Location Information Type (VLI) code list.

    public void addVehicleRentalLocationInfo(VehicleRentalLocationInfo info) {
        if (vehicleRentalLocationInfoList == null) {
            vehicleRentalLocationInfoList = new ArrayList<>();
        }
        vehicleRentalLocationInfoList.add(info);
    }
}
