package com.mongo.proj.repo;

import com.mongo.proj.domain.FlightInformation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface FlightInfoRepository extends MongoRepository<FlightInformation, String> {

    List<FlightInformation> findByDepartureCityAndDestinationCity(String departureCity, String destCity);

    @Query("{'aircraft.nbSeats' : {$gte: ?0}}")
    List<FlightInformation> findByMinAircraftNbSeats(int nbSeats);

}
