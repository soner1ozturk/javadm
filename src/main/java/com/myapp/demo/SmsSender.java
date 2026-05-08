package com.myapp.demo;

public class SmsSender implements NotificationSender{
    private String to;
    private String message;

    public SmsSender(String to, String message){
        this.to = to;
        this.message = message;
    }

    @Override
    public void send(String to, String message){
        System.out.println("Sending SMS to " + to + ": " + message);
    }
}
