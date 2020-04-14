package com.mongo.proj;

import com.mongo.proj.domain.FlightInformation;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements CommandLineRunner {

    private MongoTemplate mongoTemplate;

    public AppRunner(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public void run(String... args) {
        FlightInformation flightInformation = new FlightInformation();
        mongoTemplate.save(flightInformation);
        System.out.println("app started..");
    }
}
