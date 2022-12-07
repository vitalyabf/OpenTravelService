package com.surpricecars.opentravelservice.dto.opentravel;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import lombok.*;

import jakarta.xml.bind.annotation.XmlAttribute;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@XmlAccessorType(XmlAccessType.FIELD)
public class Telephone {

    // Attributes
    @XmlAttribute(name = "PhoneNumber", required = true)
    private String phoneNumber; // Telephone number assigned to a single location.
    @XmlAttribute(name = "PhoneTechType")
    private OpenTravelPhoneType PhoneTechType; // Indicates type of technology associated with this telephone number, such as Voice, Data, Fax, Pager, Mobile, TTY, etc. Refer to OpenTravel Code List Phone Technology Type (PTT).

}
