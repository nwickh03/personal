package com.lennys.model.places;

import com.lennys.model.LennyDataModel;
import com.lennys.model.things.Car;
import com.lennys.util.LennyLinkedListSet;

public class Lot extends LennyDataModel {
    private String lotName;
    private LennyLinkedListSet<Car> lot;
    private int currentSize = 0;

    public boolean add(Car car){
        if(currentSize+1 <= lot.size()){
            lot.add(car);
            return true;

        }
        return false;
    }

    public Lot(LennyLinkedListSet<Car> lot, int size, String name) {
        this.lot = lot;
        this.currentSize = size;
        this.lotName = name;
    }

    @Override
    public int compareTo(Object o) {
        return this.lotName.compareTo(((Lot)o).lotName);
    }
}
