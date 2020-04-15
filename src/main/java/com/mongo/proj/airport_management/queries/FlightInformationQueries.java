package com.mongo.proj.airport_management.queries;

import com.mongo.proj.domain.FlightInformation;
import com.mongo.proj.domain.FlightType;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.core.query.TextQuery;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightInformationQueries {

    private final MongoTemplate mongoTemplate;

    public FlightInformationQueries(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public List<FlightInformation> findAll(String field, int pageNb, int pageSize) {
        Query allPagedAndOrdered = new Query()
                .with(Sort.by(Sort.Direction.ASC, field))
                .with(PageRequest.of(pageNb, pageSize));

        return mongoTemplate.find(allPagedAndOrdered, FlightInformation.class);
    }

    public FlightInformation findOneById(String id) {
        return mongoTemplate.findById(id, FlightInformation.class);
    }

    public long countInternational() {
        Query international = Query.query(Criteria.where("type")
        .is(FlightType.International));

        return mongoTemplate.count(international, FlightInformation.class);
    }

    public List<FlightInformation> findByDeparture(String departure) {
        Query byDeparture = new Query()
                .addCriteria(Criteria.where("departure").is(departure));

        return mongoTemplate.find(byDeparture, FlightInformation.class);
    }

    public List<FlightInformation> findByDurationBetween(int min, int max) {
        Query byDeparture = Query.query(Criteria.where("durationMin")
        .gte(min)
        .lte(max))
                .with(Sort.by(Sort.Direction.DESC, "durationMin"));

        return mongoTemplate.find(byDeparture, FlightInformation.class);
    }

    public List<FlightInformation> findDelayedAtDeparture(String departure) {
        Query byDeparture = new Query()
                .addCriteria(Criteria.where("departure").is(departure)
                .and("isDelayed").is(true));

        return mongoTemplate.find(byDeparture, FlightInformation.class);
    }

    public List<FlightInformation> findForRelatedToCityAndNotDelayed(String city) {
        Query query = Query.query(new Criteria()
        .orOperator(
                Criteria.where("departure").is(city),
                Criteria.where("destination").is(city))
        .andOperator(
                Criteria.where("isDelayed").is(false))
        );

        return mongoTemplate.find(query, FlightInformation.class);
    }

    public List<FlightInformation> findByAircraft(String aircraft) {
        Query byAircraft = Query.query(Criteria.where("aircraft.model").is(aircraft));

        return mongoTemplate.find(byAircraft, FlightInformation.class);
    }

    public List<FlightInformation> findByText(String text) {
        TextCriteria textCriteria = TextCriteria
                .forDefaultLanguage()
                .matching(text);

        Query query = TextQuery.queryText(textCriteria)
                .sortByScore()
                .with(PageRequest.of(0, 3));

        return mongoTemplate.find(query, FlightInformation.class);
    }

}
