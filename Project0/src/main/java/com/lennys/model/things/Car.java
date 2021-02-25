package com.lennys.model.things;

import com.lennys.model.LennyDataModel;

public class Car<T> extends LennyDataModel<T> {
    private int vin, year;
    private String make, model;


    public Car(int vin, int year, String make, String model) {
        this.vin = vin;
        this.year = year;
        this.make = make;
        this.model = model;

    }


    public int getVin() {
        return vin;
    }

    public void setVin(int vin) {
        this.vin = vin;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }



    @Override
    public int compareTo(Object o) {
        return this.vin -((Car)o).getVin();
    }
}


 class Offer extends LennyDataModel {
     private int total, term, remaining, vin;


     public int getTotal() {
         return total;
     }

     public void setTotal(int total) {
         this.total = total;
     }

     public int getTerm() {
         return term;
     }

     public void setTerm(int term) {
         this.term = term;
     }

     public int getRemaining() {
         return remaining;
     }

     public void setRemaining(int remaining) {
         this.remaining = remaining;
     }

     @Override
     public int compareTo(Object o) {
         if (this.total == ((Offer) o).total) {
             if(this.term == ((Offer) o).term){
                 if(this.vin == ((Offer)o).vin) return 0;
                 else return this.vin - ((Offer)o).vin;
             }else{
                 return this.term - ((Offer) o).term;
             }
         } else{
             return this.total - ((Offer) o).total;
         }
     }
 }