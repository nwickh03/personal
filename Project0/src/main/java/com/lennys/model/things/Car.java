package com.lennys.model.things;

public class Car {
    private int vin, year;
    private String make, model;

    private Offer[] offers;

    public Car(int vin, int year, String make, String model) {
        this.vin = vin;
        this.year = year;
        this.make = make;
        this.model = model;
        this.offers = new Offer[10];
    }

    public Car(int vin, int year, String make, String model, Offer[] offers) {
        this.vin = vin;
        this.year = year;
        this.make = make;
        this.model = model;
        this.offers = offers;
    }
}
