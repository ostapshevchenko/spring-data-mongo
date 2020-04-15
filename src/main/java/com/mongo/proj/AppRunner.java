package com.mongo.proj;

import com.mongo.proj.domain.FlightInformation;
import com.mongo.proj.full.text.search.Profile;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.core.query.TextQuery;
import org.springframework.stereotype.Component;

import javax.xml.soap.Text;
import java.util.List;

@Component
public class AppRunner implements CommandLineRunner {

    private MongoTemplate mongoTemplate;

    public AppRunner(MongoTemplate mongoTemplate) {
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



        System.out.println("app started..");
    }
}
