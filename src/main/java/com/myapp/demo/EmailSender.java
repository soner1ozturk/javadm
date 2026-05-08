package com.myapp.demo;

public class EmailSender implements NotificationSender {
    private String to;
    private String message;

    public EmailSender(String to, String message) {
        this.to = to;
        this.message = message;
    }

    @Override
    public void send(String to, String message){
        System.out.println( "Sending email to " + to +  message);
    }
}