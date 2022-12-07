
package com.surpricecars.opentravelservice.services;

import com.surpricecars.opentravelservice.dto.fleet.FleetCarGroupAvailabilityInfoWrapper;
import com.surpricecars.opentravelservice.dto.fleet.FleetPriceParameters;
import com.surpricecars.opentravelservice.dto.opentravel.*;

import com.surpricecars.opentravelservice.exceptions.FleetStatusException;
import com.surpricecars.opentravelservice.exceptions.SOAPValidationException;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import jakarta.xml.ws.BindingType;
import org.apache.log4j.Logger;

import static jakarta.xml.ws.soap.SOAPBinding.SOAP12HTTP_BINDING;

@WebService(serviceName = "availability", name = "availability", targetNamespace = "ot:service" /*, wsdlLocation = "http://www.opentravel.org/OTA/2003/05 OTA_VehAvailRateRQ.xsd"*/)
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, parameterStyle = SOAPBinding.ParameterStyle.BARE)
@BindingType(value = SOAP12HTTP_BINDING)
public class OpenTravelController {

    private static final Logger logger = Logger.getLogger(OpenTravelController.class);

    public void test() {}

    @WebResult(name = "OTA_VehAvailRateRS", targetNamespace = "ot:service")
    @WebMethod(operationName = "OTA_VehAvailRateRQ")
    public OTA_VehAvailRateRS getAvailability(@WebParam(name = "OTA_VehAvailRateRQ") OTA_VehAvailRateRQ openTravelRequest) {
        try {
            // Open Travel request validation
            openTravelRequest.validate();

            // Formatting Open Travel -> Fleet
            final FleetPriceParameters fleetRequest = XMLConverter.convert(openTravelRequest);
            // Fleet request validation
            fleetRequest.validate();

            // Sending formatted request to internal API
            final FleetCarGroupAvailabilityInfoWrapper fleetResponse = FleetClient.getAvailability(fleetRequest);
            // TODO filter fleet response by ACRISS codes in case of using regex
            // final List<VehiclePreference> vehiclePreferences = openTravelRQ.getVehAvailRQCore().getVehPrefs();
            //        if (vehiclePreferences != null) {
            //            final Set<String> vehicleCodes = vehiclePreferences.stream().map(VehiclePreference::getCode).collect(Collectors.toSet());
            //            final String vehicleGroup = DBService.getVehicleGroup(vehicleCodes);
            //            fleetRQ.setVehicleGroup(vehicleGroup); //
            //        } else {


            // Formatting Fleet -> Open Travel
            final OTA_VehAvailRateRS openTravelResponse = XMLConverter.convert(fleetResponse, openTravelRequest);
            openTravelResponse.validate();

            return openTravelResponse;

        }
        catch (SOAPValidationException | FleetStatusException e) {
            OTA_VehAvailRateRS errorResponse = new OTA_VehAvailRateRS(
                    openTravelRequest.getEchoToken(),
                    openTravelRequest.getPrimaryLangID(),
                    openTravelRequest.getSequenceNumber(),
                    openTravelRequest.getTarget(),
                    openTravelRequest.getTransactionIdentifier(),
                    openTravelRequest.getVersion());

            OTA_Error error = new OTA_Error();
            error.setType("1");
            error.setShortText(e.getMessage());
            errorResponse.addError(error);
            return errorResponse;
        }
    }

}
