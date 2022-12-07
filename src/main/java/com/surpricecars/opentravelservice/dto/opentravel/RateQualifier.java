package com.surpricecars.opentravelservice.dto.opentravel;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import lombok.*;

import jakarta.xml.bind.annotation.XmlAttribute;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@XmlAccessorType(XmlAccessType.FIELD)
public class RateQualifier {

    // Attributes
    @XmlAttribute(name = "CorpDiscountNmbr")
    private String CorpDiscountNmbr; // This is the vendor specific code used to identify a special rate associated with a specific organization.
    @XmlAttribute(name = "privGuaranteedInd")
    private Boolean privGuaranteedInd; // When true, only guaranteed rates should be returned. When false, all rates should be returned.
//    @XmlAttribute(name = "PromotionCode")
//    private String PromotionCode; // Promotion code is the identifier used by the host to link directly with a specific named advertising campaign. By including the required code, the client is able to gain access to special offers which may have been created for a specifically targeted group via a CRM system or for a wider advertising campaign using Television or press adverts.
//    @XmlAttribute(name = "PromotionVendorCode")
//    private String[] PromotionVendorCode; // List of the vendor codes associated with a promotion.
    @XmlAttribute(name = "RateCategory")
    private OpenTravelRateCategory RateCategory; //The RateCategory attribute defines a set of valid values for the category of a rate. Typically rates are offered as either Leisure rates or Business (Corporate) rates, with a business rate usually including additional costs such as the cost of insurance, etc. This set of values defines the rate categories. Refer to OpenTravel Code List Rate Category (RTC).
    @XmlAttribute(name = "RatePeriod")
    private OpenTravelRatePeriod RatePeriod; // The RatePeriod attribute defines the type of rate that may be applied. For example, typically car rental rates differ based upon the duration of the rental, and the actual rate is then expressed in terms of the period of the rental.
    @XmlAttribute(name = "RateQualifier")
    @Size(min = 1, max = 6)
    @Pattern(regexp = "[a-zA-Z0-9]+")
    private String RateQualifier; //	This is the vendor specific code for rate codes (e.g. WES, 2A, DLY00).
    @XmlAttribute(name = "VendorRateID")
    @Size(min = 1, max = 10)
    @Pattern(regexp = "[a-zA-Z0-9]+")
    private String vendorRateID; // The identifier assigned to this rate by the vendor.

    @XmlAttribute(name = "TravelPurpose")
    private String TravelPurpose; // Used to indicate the purpose, whether for business, personal or other. Refer to OpenTravel Code List Travel Purpose (TVP).
}
