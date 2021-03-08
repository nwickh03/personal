package com.lennys.model.things;

import com.lennys.model.LennyDataModel;

public class Offer extends LennyDataModel implements Comparable<Offer> {
    private int id;

    private int total;

    private int downPayment;

    private int term;

    private int vin;

    private String username;

    public Offer(int total, int downPayment, int term, int vin) {
        this.total = total;
        this.downPayment = downPayment;
        this.term = term;
        this.vin = vin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getDownPayment() {
        return downPayment;
    }

    public void setDownPayment(int downPayment) {
        this.downPayment = downPayment;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public int getVin() {
        return vin;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public int compareTo(Offer o) {
        if (this.total == o.total) {
            if(this.term == o.term){
                if(this.vin == o.vin) return 0;
                else return this.vin - o.vin;
            }else{
                return this.term - o.term;
            }
        } else{
            return this.total - o.total;
        }
    }
}
