package com.lennys.service;

import com.lennys.model.things.Car;
import com.lennys.model.places.Lot;

public class LotService {
    private Lot lot;

    public LotService(Lot lot) {
        this.lot = lot;
    }

    public boolean add(Car car){
       return lot.add(car);
    }
}
