package com.lennys.model.places;

import com.lennys.model.LennyDataModel;
import com.lennys.model.things.Car;
import com.lennys.util.LennyLinkedTreeSet;

public class Lot extends LennyDataModel implements Comparable<Lot> {
    private String lotName;
    private LennyLinkedTreeSet<Car> lot;
    private int currentSize;

    public boolean add(Car car){
        if(currentSize+1 <= lot.size()){
            lot.add(car);
            return true;

        }
        return false;
    }

    public Lot(LennyLinkedTreeSet<Car> lot, int size, String name) {
        this.lot = lot;
        this.currentSize = size;
        this.lotName = name;
    }

    @Override
    public int compareTo(Lot l) {
        return this.lotName.compareTo(l.lotName);
    }
}
