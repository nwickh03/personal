package com.lennys.model.things;

import com.lennys.model.LennyDataModel;
import com.lennys.service.LotService;

import javax.annotation.Generated;
import java.util.Objects;

public class Car extends LennyDataModel implements Comparable<Car> {
    private String owner;
    private Integer vin, year, pid;
    private String make, model;
    private Payment carPayment;



    public Car(int vin, int year, String make, String model) {
        this.owner = "lenny";
        this.vin = vin;
        this.year = year;
        this.make = make;
        this.model = model;
        this.pid = null;

    }
    public Car(String owner,int vin, int year, String make, String model) {
        this.owner = owner;
        this.vin = vin;
        this.year = year;
        this.make = make;
        this.model = model;
        this.pid = null;

    }

    public Car(String owner,int vin, int year, String make, String model,Integer pid) {
        this.owner = owner;
        this.vin = vin;
        this.year = year;
        this.make = make;
        this.model = model;
        carPayment = LotService.getInstance().getPayment(pid);

    }
    public Car(int vin){
        this.vin = vin;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Integer getVin() {
        return vin;
    }

    public int getYear() {
        return year;
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

    public void setVin(Integer vin) {
        this.vin = vin;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    @Override
    public int compareTo(Car c) {
        return this.vin -((c).getVin());
    }

    public String toString() {
        return "Owner: " + owner + " Vin: " +vin + " Desc: " + year +" " + make +
                " " + model;

    }
    public String toStringSimple(){
        return " Vin: " +vin + " Desc: " + year +" " + make +
                " " + model;
    }


    @Override
    public boolean equals(Object o) {
        if (this.vin == (int)o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return vin.equals(car.vin);
    }

    public boolean equals(int vin){
        return this.vin == vin;
    }

    @Override
    public int hashCode() {
        return Objects.hash(vin);
    }

    public String toStringWithPayment() {
        return toString() + "    " + carPayment.toString();
    }
}


