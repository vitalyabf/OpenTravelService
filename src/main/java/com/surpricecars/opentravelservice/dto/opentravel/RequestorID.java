package com.surpricecars.opentravelservice.dto.opentravel;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;

@Getter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@XmlAccessorType(XmlAccessType.FIELD)
public class RequestorID {

    // Elements
    @XmlElement(name = "CompanyName")
    private String companyName; // Identifies the company that is associated with the UniqueID.Identifies a company by name.
    @XmlElement(name = "TPA_Extensions")
    private TPA_Extension extensions; // A placeholder in the schema to allow for additional elements and attributes to be included per Trading Partner Agreement (TPA).Allows extensions to be added to the OpenTravel specification per trading partner agreement.

    // Attributes
    @XmlAttribute(name = "MessagePassword")
    private String messagePassword; // This password provides an additional level of security that the recipient can use to validate the sending party's authority to use the message.
    @XmlAttribute(name = "Name")
    private String name; // The name of the person making the request- may be the travel agent, a traveler on a direct booking, or a third party.
    @XmlAttribute(name = "ID", required = true)
    private String id; // A unique identifying value assigned by the creating system. The ID attribute may be used to reference a primary-key value within a database or in a particular implementation.
    @XmlAttribute(name = "ID_Context")
    private String id_context; // Used to identify the source of the identifier (e.g., IATA, ABTA).
    @XmlAttribute(name = "Instance")
    private String instance; //	The identification of a record as it exists at a point in time. An instance is used in update messages where the sender must assure the server that the update sent refers to the most recent modification level of the object being updated.
    @XmlAttribute(name = "Type", required = true)
    private String type; // A reference to the type of object defined by the UniqueID element. Refer to OpenTravel Code List Unique ID Type (UIT).
    @XmlAttribute(name = "URL")
    private String url; // URL that identifies the location associated with the record identified by the UniqueID.
}
