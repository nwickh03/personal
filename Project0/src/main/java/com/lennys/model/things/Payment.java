package com.lennys.model.things;

public class Payment implements Comparable<Payment> {
    private Double balance;
    private Double amount;
    private int termsRemaining;
    public Payment(Offer o){
        balance = o.getTotal() - o.getDownPayment();
        amount = balance/o.getTerm();
        termsRemaining = o.getTerm();
    }

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

    //ToDo: Let the user make payments through the portal, let employees credit cash payments to a users Payment.
    //ToDo:Larger refactor to allow variable sized payments.
    public void processPayment(){
        balance = balance - amount;
        --termsRemaining;
    }

    @Override
    public int compareTo(Payment o) {
      return this.amount.compareTo(o.amount);
    }
}
