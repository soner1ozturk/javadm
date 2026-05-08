package com.myapp.demo;

public class CreditCardPayment extends Payment{
    private String cardNumber;

    public CreditCardPayment(Long id, double amount, String customerEmail,String cardNumber){
        super(id,amount,customerEmail);
        this.cardNumber = cardNumber;
    }

    @Override
    public String processPayment(){
        return "Processing credit card ending in " + cardNumber.strip().substring(cardNumber.length()-4);
    }
}
