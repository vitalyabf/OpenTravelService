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
public class OTA_Error {

    // Attributes
    @XmlAttribute(name = "NodeList")
    private String nodeList; // An XPath expression that selects all the nodes whose data caused this error. Further, this expression should have an additional contraint which contains the data of the node. This will provide the offending data back to systems that cannot maintain the original message.
    @XmlAttribute(name = "Type", required = true)
    private String type; //	The Error element MUST contain the Type attribute that uses a recommended set of values to indicate the error type. The validating XSD can expect to accept values that it has NOT been explicitly coded for and process them by using Type ="Unknown". Refer to OpenTravel Code List Error Warning Type (EWT).
    @XmlAttribute(name = "Code")
    private String code; // If present, this refers to a table of coded values exchanged between applications to identify errors or warnings. Refer to OpenTravel Code List Error Codes (ERR).
    @XmlAttribute(name = "DocURL")
    private String docURL; // If present, this URL refers to an online description of the error that occurred.
    @XmlAttribute(name = "RecordID")
    private String recordId; // If present, this attribute allows for batch processing and the identification of the record that failed amongst a group of records. This value may contain a concatenation of a unique failed transaction ID with specific record(s) associated with that transaction.
    @XmlAttribute(name = "ShortText")
    private String shortText; // An abbreviated version of the error in textual format.
    @XmlAttribute(name = "Status")
    private String status;// If present, recommended values are those enumerated in the OTA_ErrorRS, (NotProcessed | Incomplete | Complete | Unknown) however, the data type is designated as string data, recognizing that trading partners may identify additional status conditions not included in the enumeration.
    @XmlAttribute(name = "Tag")
    private String tag; //	If present, this attribute may identify an unknown or misspelled tag that caused an error in processing. It is recommended that the Tag attribute use XPath notation to identify the location of a tag in the event that more than one tag of the same name is present in the document. Alternatively, the tag name alone can be used to identify missing data [Type=ReqFieldMissing].
    @XmlAttribute(name = "Language")
    private String language; // Language identification.
}
