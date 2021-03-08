package com.lennys.model.things;

import com.lennys.model.LennyDataModel;

public class Payment extends LennyDataModel implements Comparable<Payment> {
    private int vin;
    private Double balance;
    private Double amount;
    private int termsRemaining;
    public Payment(Offer o){
        balance = Double.valueOf(o.getTotal() - o.getDownPayment());
        amount = balance/o.getTerm();
        termsRemaining = o.getTerm();
    };

    public void processPayment(){
        balance = balance - amount;
        --termsRemaining;
    }

    @Override
    public int compareTo(Payment o) {
      return this.amount.compareTo(o.amount);
    }
}
