package com.surpricecars.opentravelservice.services.adapters;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;

public class DoubleAdapter extends XmlAdapter<String, Double> {

    @Override
    public Double unmarshal(String s) throws Exception {
        return Double.parseDouble(s);

    }

    @Override
    public String marshal(Double value) throws Exception {
        return value.toString();

    }
}
