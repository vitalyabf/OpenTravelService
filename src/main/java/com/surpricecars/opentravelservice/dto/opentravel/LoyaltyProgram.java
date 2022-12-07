package com.surpricecars.opentravelservice.dto.opentravel;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import jakarta.xml.bind.annotation.XmlAttribute;

@Getter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@XmlAccessorType(XmlAccessType.FIELD)
public class LoyaltyProgram {
    // Elements

    // Attributes
    @XmlAttribute(name = "ProgramID")
    private String programId; // Identifier to indicate the company owner of the loyalty program.
    @XmlAttribute(name = "MembershipID")
    private String membershipId; // Unique identifier of the member in the program (membership number, account number, etc.).
}
