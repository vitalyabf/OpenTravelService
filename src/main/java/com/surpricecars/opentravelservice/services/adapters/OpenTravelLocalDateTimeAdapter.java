package com.surpricecars.opentravelservice.services.adapters;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class OpenTravelLocalDateTimeAdapter extends XmlAdapter<String, LocalDateTime> {

    private final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

    @Override
    public LocalDateTime unmarshal(String s) throws Exception {
        synchronized (dateFormat) {
            if (dateFormat == null) {
                return null;
            }
            return LocalDateTime.parse(s);
        }
    }

    @Override
    public String marshal(LocalDateTime localTime) throws Exception {
        synchronized (dateFormat) {
            if (localTime == null) {
                return "";
            }
            return dateFormat.format(localTime);
        }
    }
}
