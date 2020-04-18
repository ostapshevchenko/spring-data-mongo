package com.mongo.proj;

import com.mongo.proj.repo.FlightInfoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements CommandLineRunner {

    private final FlightInfoRepository flightInfoRepository;
    private MongoTemplate mongoTemplate;

    public AppRunner(FlightInfoRepository flightInfoRepository, MongoTemplate mongoTemplate) {
        this.flightInfoRepository = flightInfoRepository;
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public void run(String... args) {
        // full text search
//        FlightInformation flightInformation = new FlightInformation();
//        mongoTemplate.save(flightInformation);
//        Profile profile1 = new Profile("Dan", "Java Develop3r", "I am programmer");
//        Profile profile2 = new Profile("Java Guru","C# Develop3r", "I am programmer");
//        Profile profile3 = new Profile("John", "Developr", "I am Java programmer");
//
//        mongoTemplate.save(profile1);
//        mongoTemplate.save(profile2);
//        mongoTemplate.save(profile3);
//        TextCriteria textCriteria = TextCriteria
//                .forDefaultLanguage()
//                .matching("Java");
//
//        Query query = TextQuery.queryText(textCriteria)
//                .sortByScore()
//                .with(PageRequest.of(0, 3));
//
//        List<Profile> profiles = mongoTemplate.find(query, Profile.class);
//        System.out.println(profiles);

        printByMinNbSeats(200);

        System.out.println("app started..");
    }

    private void printByMinNbSeats(int nbSeats) {
        System.out.println("------------------------------------");
        System.out.println(flightInfoRepository.findByMinAircraftNbSeats(nbSeats));
        System.out.println("------------------------------------");

    }
}
