package com.myapp.demo;

public class PayPalPayment extends Payment{
    private String paypalEmail;

    public PayPalPayment(Long id, double amount, String customerEmail, String payPalEmail){
        super(id,amount,customerEmail);
        this.paypalEmail = payPalEmail;
    }

    @Override
    public String processPayment(){
        return "Processing PayPal payment via " + paypalEmail;
    }
}
