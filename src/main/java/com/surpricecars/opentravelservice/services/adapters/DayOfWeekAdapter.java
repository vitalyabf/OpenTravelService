package com.surpricecars.opentravelservice.services.adapters;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;
import java.time.DayOfWeek;

public class DayOfWeekAdapter extends XmlAdapter<String, DayOfWeek> {

    @Override
    public DayOfWeek unmarshal(String s) throws Exception {
        return switch (s.toUpperCase()){
        case "MON" -> DayOfWeek.MONDAY;
        case "TUE" -> DayOfWeek.TUESDAY;
        case "WED" -> DayOfWeek.WEDNESDAY;
        case "THU" -> DayOfWeek.THURSDAY;
        case "FRI" -> DayOfWeek.FRIDAY;
        case "SUN" -> DayOfWeek.SUNDAY;
        case "SAT" -> DayOfWeek.SATURDAY;
        default -> DayOfWeek.valueOf(s);
        };
        //return DayOfWeek.MONDAY;
    }

    @Override
    public String marshal(DayOfWeek value) throws Exception {
        return value.toString().substring(1,4).toUpperCase();

    }
}
