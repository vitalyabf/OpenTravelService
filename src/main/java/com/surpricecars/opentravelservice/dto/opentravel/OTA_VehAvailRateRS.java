package com.surpricecars.opentravelservice.dto.opentravel;

import com.surpricecars.opentravelservice.services.validation.Valid;
import lombok.*;

import jakarta.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@XmlRootElement(namespace = "ot:service")
@XmlAccessorType(XmlAccessType.FIELD)
public class OTA_VehAvailRateRS extends OTA_Message implements Valid<OTA_VehAvailRateRS> {

    // Elements: Success
    @XmlElement(name = "Success", namespace = "ot:service")
    private Boolean Success;
    @XmlElement(name = "VehAvailRSCore", namespace = "ot:service")
    private VehAvailRSCore vehAvailRSCore; // Identifies the common, or core, information associated with the response providing information on the availability of rental vehicles.The VehicleAvailRSType complex type identifies the data that is considered common when describing the availability and rates of rental vehicles.
    @XmlElement(name = "VehAvailRSInfo", namespace = "ot:service")
    private VehAvailRSInfo vehAvailRSInfo;

    // Elements: Error
    // Elements
    @XmlElementWrapper(name = "Errors", namespace = "ot:service")
    @XmlElement(name = "Error", namespace = "ot:service")
    private List<OTA_Error> errors; // Indicates that an error occurred in the processing of the incoming request message. An error is defined as a malformed XML message that could not be processed.A collection of errors that occurred during the processing of a message.

    public OTA_VehAvailRateRS(String echoToken, String primaryLangID, String sequenceNumber, OTA_Target target, TransactionIdentifier transactionIdentifier, String version) {
        super(echoToken, primaryLangID, sequenceNumber, target, transactionIdentifier, version);
    }

    public void addError(OTA_Error error) {
        if (this.errors == null) {
            this.errors = new ArrayList<>();
        }
        this.errors.add(error);
    }
}
