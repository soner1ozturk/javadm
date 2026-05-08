package com.myapp.demo;

public abstract class Payment {
    //An abstract class Payment with: Long id, double amount, String customerEmail.
    // Constructor takes all three. Add an abstract method String processPayment()
    // and a concrete method String getReceipt() that returns "Payment of $[amount] by [customerEmail]".
    private Long id;
    private  double amount;
    private String customerEmail;

    public Payment(Long id, double amount, String customerEmail){
        this.id = id;
        this.amount = amount;
        this.customerEmail = customerEmail;
    }

    public abstract String processPayment();

    public String getReceipt(){
        return "Payment of $" + amount + " by " + customerEmail;
    }
}
