package com.surpricecars.opentravelservice.dto.opentravel;

import jakarta.validation.constraints.NotNull;
import jakarta.xml.bind.annotation.*;
import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class OTA_Message implements Serializable {

    @XmlAttribute(name = "EchoToken", required = true)
    private String echoToken;
    @XmlAttribute(name = "PrimaryLangID", required = true)
    private String primaryLangID;
    @XmlAttribute(name = "SequenceNmbr",required = true)
    private String sequenceNumber;
    @XmlAttribute(name = "Target", required = true)
    @NotNull(message = "incorrect value 'target'")
    private OTA_Target target;
    @XmlAttribute(name = "TransactionIdentifier", required = true)
    private TransactionIdentifier transactionIdentifier;
    @XmlAttribute(name = "Version", required = true)
    private String version;

}
