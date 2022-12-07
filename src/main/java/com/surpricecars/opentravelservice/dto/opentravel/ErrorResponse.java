package com.surpricecars.opentravelservice.dto.opentravel;

import lombok.*;

import jakarta.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@XmlRootElement(name = "OTA_VehAvailRateRS")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OTA_VehAvailRateRS")
public class ErrorResponse extends OTA_Message {

    // Elements
    @XmlElementWrapper(name = "Errors", required = true)
    @XmlElement(name = "Error")
    private List<OTA_Error> errors = new ArrayList<OTA_Error>(); // Indicates that an error occurred in the processing of the incoming request message. An error is defined as a malformed XML message that could not be processed.A collection of errors that occurred during the processing of a message.

    public ErrorResponse(String echoToken, String primaryLangID, String sequenceNumber, OTA_Target target, TransactionIdentifier transactionIdentifier, String version) {
        super(echoToken, primaryLangID, sequenceNumber, target, transactionIdentifier, version);
    }

    public void addError(OTA_Error error) {
        errors.add(error);
    }
}
