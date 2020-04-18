package com.mongo.proj.data_seeder;

import com.mongo.proj.domain.Aircraft;
import com.mongo.proj.domain.FlightInformation;
import com.mongo.proj.domain.FlightType;
import com.mongo.proj.repo.FlightInfoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Order(1)
@Component
public class DataSeeder implements CommandLineRunner {

    private final FlightInfoRepository flightInfoRepository;

    public DataSeeder(FlightInfoRepository flightInfoRepository) {
        this.flightInfoRepository = flightInfoRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        empty();
        seed();
    }

    public void empty() {
        flightInfoRepository.deleteAll();
    }

    public void seed() {
        FlightInformation flightInformation1 = new FlightInformation();
        flightInformation1.setDelayed(false);
        flightInformation1.setDepartureCity("Rome");
        flightInformation1.setDestinationCity("Paris");
        flightInformation1.setDepartureDate(LocalDate.of(2019, 3, 12));
        flightInformation1.setFlightType(FlightType.International);
        flightInformation1.setDuration(80);
        flightInformation1.setAircraft(new Aircraft("737", 180));
        flightInformation1.setDescription("Flight from Rome to Paris");


        FlightInformation flightInformation2 = new FlightInformation();
        flightInformation2.setDelayed(false);
        flightInformation2.setDepartureCity("New York");
        flightInformation2.setDestinationCity("Copenhagen");
        flightInformation2.setDepartureDate(LocalDate.of(2019, 5, 11));
        flightInformation2.setFlightType(FlightType.International);
        flightInformation2.setDuration(600);
        flightInformation2.setAircraft(new Aircraft("737", 300));
        flightInformation2.setDescription("Flight from NY to Copenhagen via Rome");

        FlightInformation flightInformation3 = new FlightInformation();
        flightInformation3.setDelayed(true);
        flightInformation3.setDepartureCity("Bruxelles");
        flightInformation3.setDestinationCity("Bucharest");
        flightInformation3.setDepartureDate(LocalDate.of(2019, 6, 12));
        flightInformation3.setFlightType(FlightType.International);
        flightInformation3.setDuration(150);
        flightInformation3.setAircraft(new Aircraft("A320", 170));
        flightInformation3.setDescription("Flight from NY to Copenhagen via Rome");

        FlightInformation flightInformation4 = new FlightInformation();
        flightInformation4.setDelayed(true);
        flightInformation4.setDepartureCity("Madrid");
        flightInformation4.setDestinationCity("Barcelona");
        flightInformation4.setDepartureDate(LocalDate.of(2019, 6, 12));
        flightInformation4.setFlightType(FlightType.Internal);
        flightInformation4.setDuration(120);
        flightInformation4.setAircraft(new Aircraft("A319", 150));

        FlightInformation flightInformation5 = new FlightInformation();
        flightInformation5.setDelayed(false);
        flightInformation5.setDepartureCity("Las Vegas");
        flightInformation5.setDestinationCity("Washington");
        flightInformation5.setDepartureDate(LocalDate.of(2019, 6, 11));
        flightInformation5.setFlightType(FlightType.Internal);
        flightInformation5.setDuration(400);
        flightInformation5.setAircraft(new Aircraft("A319", 150));
        flightInformation5.setDescription("Flight from LA to Washington");

        FlightInformation flightInformation6 = new FlightInformation();
        flightInformation6.setDelayed(false);
        flightInformation6.setDepartureCity("Bucharest");
        flightInformation6.setDestinationCity("Rome");
        flightInformation6.setDepartureDate(LocalDate.of(2019, 6, 13));
        flightInformation6.setFlightType(FlightType.International);
        flightInformation6.setDuration(110);
        flightInformation6.setAircraft(new Aircraft("A321 Neo", 200));


        //seed
        List<FlightInformation> flightInformations = Arrays.asList(
                flightInformation1,
                flightInformation2,
                flightInformation3,
                flightInformation4,
                flightInformation5,
                flightInformation6
        );

        flightInfoRepository.insert(flightInformations);


        //count
        long count = flightInfoRepository.count();
        System.out.println("Total flights in db: " + count);

        //print
        List<FlightInformation> flightInformations1 = flightInfoRepository.findAll(Sort.by("departureCity").ascending());
        for (FlightInformation information: flightInformations1) {
            System.out.println(information);
        }

    }


}
