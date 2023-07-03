package com.portfolio.service;

import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service
public class EmailService {

    public boolean sendEmail(String subject,String message,String to){

        boolean f=false;
        String from="supranshus@gmail.com";


        //Variable for gmail
        String host="smtp.gmail.com";

        //get the system properties
        Properties props=System.getProperties();
        System.out.println("Properties: "+props);

        //setting important information to properties object

        //host set
        props.put("mail.smtp.host",host);
        props.put("mail.smtp.port","465");
        props.put("mail.smtp.ssl.enable","true");
        props.put("mail.smtp.auth","true");

        //Step 1: to get the session object
        Session session=Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("supranshus@gmail.com","bxldquoidjvbcdpb");
            }
        });

        session.setDebug(true);

        //Step 2: compose the message [text,multimedia]
        MimeMessage m=new MimeMessage(session);

        try{
            m.setFrom(from);

            m.addRecipient(Message.RecipientType.TO,new InternetAddress(to));

            m.setSubject(subject);

            m.setText(message);

            //Step 3:send message using Transport class
            Transport.send(m);

            System.out.println("Sent successs!!!!");
            f=true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return f;
    }

    public boolean sendEmailToPersonalAccount(String subject, String message,String to) {
        boolean f = false;
        String from = to; // The email entered by the user

        // Variable for your personal Gmail account
        String personalEmail = "supranshus@gmail.com";
        String personalEmailPassword = "bxldquoidjvbcdpb";

        // Get the system properties
        Properties props = System.getProperties();
        System.out.println("Properties: " + props);

        // Set the properties for your personal Gmail account
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.auth", "true");

        // Create the session using your personal Gmail account credentials
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(personalEmail, personalEmailPassword);
            }
        });

        session.setDebug(true);

        // Compose the message
        MimeMessage m = new MimeMessage(session);

        try {
            m.setFrom(from);
            m.addRecipient(Message.RecipientType.TO, new InternetAddress(personalEmail));
            m.setSubject(subject);
            m.setText(message);

            // Send the message using Transport class
            Transport.send(m);

            System.out.println("Sent to personal email successfully!");
            f = true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return f;
    }
   

}
