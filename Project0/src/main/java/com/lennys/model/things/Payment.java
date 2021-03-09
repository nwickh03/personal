package com.lennys.model.things;

import com.lennys.model.LennyDataModel;

public class Payment extends LennyDataModel implements Comparable<Payment> {
    private Double balance;
    private Double amount;
    private int termsRemaining;
    public Payment(Offer o){
        balance = Double.valueOf(o.getTotal() - o.getDownPayment());
        amount = balance/o.getTerm();
        termsRemaining = o.getTerm();
    };

    @Override
    public String toString() {
        return "Balance: " + String.format("%,.2f", balance) + "Monthly Payment: " + String.format("%,.2f",amount)
                + " TermsRemaining: " +  termsRemaining;
    }

    public Payment(Double balance, Double amount, int termsRemaining) {
        this.balance = balance;
        this.amount = amount;
        this.termsRemaining = termsRemaining;
    }

    public void processPayment(){
        balance = balance - amount;
        --termsRemaining;
    }

    @Override
    public int compareTo(Payment o) {
      return this.amount.compareTo(o.amount);
    }
}
