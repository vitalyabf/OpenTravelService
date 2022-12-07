package com.surpricecars.opentravelservice.services.adapters;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateAdapter extends XmlAdapter<String, LocalDate> {

    private final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    public String marshal(LocalDate localDate) throws Exception {
        synchronized (dateFormat) {
            return dateFormat.format(localDate);
        }
    }

    @Override
    public LocalDate unmarshal(String s) throws Exception {
        synchronized (dateFormat) {
            return LocalDate.parse(s);
        }
    }

}
