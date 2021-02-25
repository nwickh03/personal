package com.lennys.model.places;

import com.lennys.model.things.Car;

public class Lot {
    private Car[] lot;
    private int currentIndex = -1;

    public boolean add(Car car){
        if(currentIndex+1 <= lot.length){
            lot[++currentIndex] = car;
            return true;

        }
        return false;
    }

    public Lot(Car[] lot, int currentIndex) {
        this.lot = lot;
        this.currentIndex = currentIndex;
    }
}
