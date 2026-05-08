package com.myapp.demo;

import java.util.List;

public class PaymentProcessor {
    //A PaymentProcessor class with a method void processAll(List<Payment> payments)
    // that loops through and calls processPayment() on each one, printing the result.
    // This method should NOT know about CreditCard, PayPal, or Crypto — it only knows Payment.
    public PaymentProcessor(){}

    public void processAll(List<Payment> payments){
        for (Payment payment : payments){
            String result = payment.processPayment();
            System.out.println(result);
        }
    }
}
