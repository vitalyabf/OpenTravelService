package com.surpricecars.opentravelservice.services.adapters;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class LocalTimeAdapter extends XmlAdapter<String, LocalTime> {

    private final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("HH:mm");

    @Override
    public LocalTime unmarshal(String s) throws Exception {
        synchronized (dateFormat) {
            if (s == null) {
                return null;
            }
            return LocalTime.parse(s);
        }
    }

    @Override
    public String marshal(LocalTime localTime) throws Exception {
        synchronized (dateFormat) {
            if (localTime == null) {
                return null;
            }
            return dateFormat.format(localTime);
        }
    }
}
