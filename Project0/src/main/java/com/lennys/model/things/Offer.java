package com.lennys.model.things;

import com.lennys.model.LennyDataModel;

public class Offer extends LennyDataModel implements Comparable<Offer> {
    private int id;

    private Double total;

    private int downPayment;

    private int term;

    private int vin;

    private String username;

    private OfferStatus status;

    public Offer(Double total, int downPayment, int term, int vin, String username) {
        this.total = total;
        this.downPayment = downPayment;
        this.term = term;
        this.vin = vin;
        this.username = username;
    }
    public Offer(int id, int vin, Double total, int downPayment, int term, String username, int status) {
        this(total,downPayment,term,vin,username);
        this.id = id;
        switch (status){
            case 0: this.status = OfferStatus.PENDING;
                break;
            case 1: this.status = OfferStatus.ACCEPTED;
                break;
            case 2: this.status = OfferStatus.REJECTED;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + status);
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
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
        if (this.total.equals(o.total)) {
            if(this.term == o.term){
                if(this.vin == o.vin) return 0;
                else return this.vin - o.vin;
            }else{
                return this.term - o.term;
            }
        } else{
            return (int)(this.total - o.total);
        }
    }

    public int compareTo(int id){
        return this.id - id;
    }

    @Override
    public String toString() {
        return "Offer Id: " + id +
                ", vin: " + vin +
                ", total: " + total +
                ", downPayment: " + downPayment +
                ", term: " + term +
                ", username: '" + username + '\'' +
                ", status: " + status;
    }
}
