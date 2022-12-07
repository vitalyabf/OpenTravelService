package com.surpricecars.opentravelservice.dao;

import com.surpricecars.opentravelservice.dto.opentravel.*;
import jakarta.persistence.*;
import org.hibernate.query.NativeQuery;
import org.hibernate.transform.AliasToBeanResultTransformer;


public class DBService {

    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("OpenTravel");

    static String SELECT_LOCATION_BY_ID = "SELECT " +
            "   code_context as codeContext, " +
            "   location_code as locationCode, " +
            "   extended_location_code as extendedLocationCode " +
            "FROM locations WHERE " +
            "   location_id = :id ";
    static String SELECT_ID_BY_LOCATION = "SELECT " +
            "   location_id as id " +
            "FROM locations WHERE " +
            "   code_context = :codeContext " +
            "   AND location_code = :locationCode " +
            "   AND extended_location_code = :extendedLocationCode ";

    public static int getLocationId(String codeContext, String locationCode, String extendedLocationCode) {

        EntityManager entityManager = factory.createEntityManager();
        final Query query = entityManager.createNativeQuery(SELECT_ID_BY_LOCATION, Integer.class);
        query.setParameter("codeContext", codeContext);
        query.setParameter("locationCode", locationCode);
        query.setParameter("extendedLocationCode", extendedLocationCode);

        return (int) query.getSingleResult();
    }

    public static OpenTravelLocation getOpenTravelLocation(int fleetLocationId) {

        EntityManager entityManager = factory.createEntityManager();
        Query query = entityManager.createNativeQuery(SELECT_LOCATION_BY_ID);
        query.setParameter("id", fleetLocationId);
        query.unwrap(NativeQuery.class).setTupleTransformer(new AliasToBeanResultTransformer<OpenTravelLocation>(OpenTravelLocation.class));

        return (OpenTravelLocation) query.getSingleResult();
    }

    public static OpenTravelChargePurpose getChargePurpose(String equipmentId) {
        return OpenTravelChargePurpose.EQUIPMENT;
    }

    public static Equipment getOpenTravelEquipment(String fleetId, String fleetDescription) {
        return new Equipment(fleetDescription, "13");
    }

    public static RateDistance getRateDistance(String countryCode) {

        RateDistance rateDistance = new RateDistance();
        rateDistance.setUnlimited(false);
        rateDistance.setQuantity(0);
        rateDistance.setDistanceUnit(OpenTravelDistanceUnitName.KM);
        rateDistance.setPeriodUnit("RentalPeriod");

        return rateDistance;
    }
}
