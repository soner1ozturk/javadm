package com.myapp.demo;

import java.util.List;

public class NotificationService {

    private String to;
    private String message;

    public NotificationService(List<NotificationSender> notificationSenderList){
        this.to = to;
        this.message = message;
    }

    public void notifyAll(String to, String message){
        EmailSender email = new EmailSender(to,message);
        SmsSender sms = new SmsSender(to,message);
        email.send(to,message);
        sms.send(to,message);
    }

    public void notifyWith(NotificationSender sender, String to, String message){
        sender.send(to,message);
    }
}
