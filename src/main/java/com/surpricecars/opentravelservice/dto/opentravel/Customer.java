package com.surpricecars.opentravelservice.dto.opentravel;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Customer {

    // Elements
    @XmlElement(name = "CompanyName")
    private CompanyName companyName;
    @XmlElement(name = "TPA_Extensions")
    private TPA_Extension extensions;

    // Attributes
    @XmlAttribute(name = "ID", required = true)
    private String id;
    @XmlAttribute(name = "ID_Context")
    private String contextId;
    @XmlAttribute(name = "Instance")
    private String instance;
    @XmlAttribute(name = "Type", required = true)
    private String type;
    @XmlAttribute(name = "URL")
    private String url;

}
