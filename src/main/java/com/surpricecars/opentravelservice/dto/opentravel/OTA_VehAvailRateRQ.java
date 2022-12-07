package com.surpricecars.opentravelservice.dto.opentravel;

import com.surpricecars.opentravelservice.services.adapters.OpenTravelLocalDateTimeAdapter;
import com.surpricecars.opentravelservice.services.validation.Valid;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import lombok.*;

import jakarta.xml.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@Getter
//@Setter
@EqualsAndHashCode
@ToString
@XmlAccessorType(XmlAccessType.FIELD)
public class OTA_VehAvailRateRQ extends OTA_Message implements Valid<OTA_VehAvailRateRQ> {

    // Elements
    @XmlElementWrapper(name = "POS", required = true)
    @XmlElement(name = "Source", required = true)
    private List<Source> sources;
    @XmlElement(name = "CustomerId")
    private List<Customer> customers;
    @XmlElement(name = "VehAvailRQCore", required = true)
    private VehAvailRQCore vehAvailRQCore;
    @XmlElement(name = "VehAvailRQInfo")
    private VehAvailRQInfo vehAvailRQInfo;

    // Attributes
    @XmlAttribute(name = "TimeStamp")
    @XmlJavaTypeAdapter(type = LocalDateTime.class, value = OpenTravelLocalDateTimeAdapter.class)
    private LocalDateTime timeStamp;
    @XmlAttribute(name = "MaxPerVendorInd")
    private Boolean maxPerVendorInd;
    @XmlAttribute(name = "MaxResponses")
    private int maxResponses;
    @XmlAttribute(name = "AltLangID")
    private String altLangID;
    @XmlAttribute(name = "CorrelationID")
    private String correlationID;
    @XmlAttribute(name = "RetransmissionIndicator")
    private Boolean retransmissionIndicator;
    @XmlAttribute(name = "TargetName")
    private String targetName;
    @XmlAttribute(name = "TransactionStatusCode")
    private String transactionStatusCode;

    public OTA_VehAvailRateRQ(String echoToken, String primaryLangID, String sequenceNumber, OTA_Target target, TransactionIdentifier transactionIdentifier, String version) {
        super(echoToken, primaryLangID, sequenceNumber, target, transactionIdentifier, version);
    }
}
