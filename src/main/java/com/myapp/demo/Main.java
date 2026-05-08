package com.myapp.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main {
    public static String Main(String[] args){
        EmailSender email = new EmailSender("jim","hello");
        SmsSender sms = new SmsSender("pam","heyoo");

        List<NotificationSender> notificationSenders = new ArrayList<>();
        notificationSenders.add(email);
        notificationSenders.add(sms);


        NotificationService notificationService = new NotificationService(notificationSenders);

        notificationService.notifyAll("me","test");
        notificationService.notifyWith(email,"you","heyooo");
    }
}
