package com.mongo.proj.domain;

public class Aircraft {

    private String model;
    private String nbSeats;

    public Aircraft(String model, String nbSeats) {
        this.model = model;
        this.nbSeats = nbSeats;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getNbSeats() {
        return nbSeats;
    }

    public void setNbSeats(String nbSeats) {
        this.nbSeats = nbSeats;
    }
}
