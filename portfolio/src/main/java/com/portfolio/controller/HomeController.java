package com.portfolio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.portfolio.model.EmailRequest;
import com.portfolio.service.EmailService;

@Controller
public class HomeController {


    @Autowired
    private EmailService service;

	
    @GetMapping("/")
    public String home(Model m){


        return "index";
    }
    
    @PostMapping("/send-email")
    public String sendEmail(@RequestParam("to") String to,
                            @RequestParam("subject") String subject,
                            @RequestParam("message") String message) {
    	message="recieved From: "+to+", Subject: "+subject+", Message: "+message;
        // Invoke the EmailService method to send the email to your personal account
        service.sendEmailToPersonalAccount(subject, message,to);

        // Return a response or redirect to another page
        return "success"; // Redirect to the home page or any other desired page
    }

}

