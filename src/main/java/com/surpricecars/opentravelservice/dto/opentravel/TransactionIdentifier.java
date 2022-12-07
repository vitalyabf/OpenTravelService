package com.surpricecars.opentravelservice.dto.opentravel;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;

@XmlEnum
public enum TransactionIdentifier {
    @XmlEnumValue("MCA") MULTI_COMPANY_AVAILABILITY, // Multi company availability for Availability operation
    @XmlEnumValue("SCA") SINGLE_COMPANY_AVAILABILITY, // Single company availability for Availability operation
    @XmlEnumValue("Book") BOOK, // for Booking operation
    @XmlEnumValue("Commit") COMMIT, // for Commit (End of transaction) operation
    @XmlEnumValue("Ignore") IGNORE, // for Ignore operation
    @XmlEnumValue("Modify") MODIFY, // for Modify operation
    @XmlEnumValue("Cancel") CANCEL // for Cancel operation
}
