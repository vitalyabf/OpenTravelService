package com.surpricecars.opentravelservice.services;

import com.surpricecars.opentravelservice.dto.fleet.FleetCarGroupAvailabilityInfo;
import com.surpricecars.opentravelservice.dto.fleet.FleetCarGroupAvailabilityInfoWrapper;
import com.surpricecars.opentravelservice.dto.fleet.FleetPriceParameters;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.xml.ws.RequestWrapper;
import jakarta.xml.ws.ResponseWrapper;
import java.util.List;

@WebService(name = "service")
public interface Fleet {

    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getAvailableInfo", targetNamespace = "urn:service", className = "com.example.surpricecars.ws.client.AvailabilityRequest")
    @ResponseWrapper(localName = "getAvailableInfoResponse", targetNamespace = "urn:service", className = "com.example.surpricecars.ws.client.AvailabilityResponse")
    //@Action(input = "urn:service/service/getAvailableInfoRequest", output = "urn:service/service/getAvailableInfoResponse")
    public FleetCarGroupAvailabilityInfoWrapper getAvailableInfo (
            @WebParam(name = "parameters", targetNamespace = "")
            FleetPriceParameters parameters);
}

