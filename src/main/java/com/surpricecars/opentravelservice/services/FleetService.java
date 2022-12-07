package com.surpricecars.opentravelservice.services;

import jakarta.xml.ws.*;

import javax.xml.namespace.QName;
import java.net.MalformedURLException;
import java.net.URL;

@WebServiceClient(name = "service")
public class FleetService extends Service {

    private final static URL WSDL_LOCATION;
    private final static WebServiceException TEST_EXCEPTION;
    private final static QName QNAME = new QName("urn:service", "service");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://zeus.surpriceretrieve.com/service.php?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        WSDL_LOCATION = url;
        TEST_EXCEPTION = e;
    }

    public FleetService() {
        super(WSDL_LOCATION, QNAME);
    }

    @WebEndpoint(name = "servicePort")
    public Fleet getFleetServicePort() {
        return super.getPort(new QName("urn:service", "servicePort"), Fleet.class);
    }

    private static URL getWsdlLocation() {
        if (TEST_EXCEPTION!= null) {
            throw TEST_EXCEPTION;
        }
        return WSDL_LOCATION;
    }
}
