package com.maxcheung.comms;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.thymeleaf.context.Context;

import com.maxcheung.comms.email.EmailHtmlSender;
import com.maxcheung.comms.email.EmailSender;
import com.maxcheung.comms.email.EmailStatus;



@SpringBootApplication
public class Application {
	
	
    @Autowired
    private EmailHtmlSender emailHtmlSender;
    
    @Autowired
    private EmailSender emailSender;
    
    
    @Value("${mail.to}")
    private String mailTo;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	
	@PostConstruct
	public void init() {
		// init code goes here
		Context context = new Context();
		context.setVariable("title", "Lorem Ipsum");
		context.setVariable("description", "Lorem Lorem Lorem");
		EmailStatus emailStatus = emailHtmlSender.send(mailTo, "Spring boot app", "email/template-1", context);
		emailSender.sendPlainText(mailTo, "Spring boot app", "this is not samp");
	}

}
