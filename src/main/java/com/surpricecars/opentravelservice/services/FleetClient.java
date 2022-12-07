package com.surpricecars.opentravelservice.services;

import com.surpricecars.opentravelservice.dto.fleet.FleetCarGroupAvailabilityInfo;
import com.surpricecars.opentravelservice.dto.fleet.FleetCarGroupAvailabilityInfoWrapper;
import com.surpricecars.opentravelservice.dto.fleet.FleetPriceParameters;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class FleetClient {

    public static void main(String[] args) {
        test2();
    }

    public static void test2() {

        FleetService service = new FleetService();
        Fleet port = service.getFleetServicePort();

        FleetPriceParameters priceParameters = new FleetPriceParameters();
        priceParameters.setId("Traveljigsaw");
        priceParameters.setAge(39);
        priceParameters.setPickupLocationCode(26);
        priceParameters.setPickupDate(LocalDate.of(2022, 12,28));
        priceParameters.setPickupTime(LocalTime.of(10, 0));

        priceParameters.setReturnLocationCode(26);
        priceParameters.setReturnDate(LocalDate.of(2022, 12,31));
        priceParameters.setReturnTime(LocalTime.of(10, 0));

        final FleetCarGroupAvailabilityInfoWrapper availableInfo = port.getAvailableInfo(priceParameters);
        System.out.println("getAvailableInfo: " + availableInfo);
    }

    public static FleetCarGroupAvailabilityInfoWrapper getAvailability(FleetPriceParameters parameters) {

        FleetService service = new FleetService();
        Fleet port = service.getFleetServicePort();

        return port.getAvailableInfo(parameters);
    }
}
