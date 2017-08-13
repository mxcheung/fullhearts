package com.maxcheung.comms;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.context.Context;

import com.maxcheung.comms.service.EmailHtmlSender;
import com.maxcheung.comms.service.EmailSender;

import au.com.maxcheung.emailservice.model.EmailStatus;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {
	
    @Autowired
    private EmailHtmlSender emailHtmlSender;
    
    @Autowired
    private EmailSender emailSender;
    
    
    @Value("${mail.to}")
    private String mailTo;


	@Test
	public void contextLoads() {
		Context context = new Context();
		context.setVariable("title", "Lorem Ipsum");
		context.setVariable("description", "Lorem Lorem Lorem");
		EmailStatus emailStatus = emailHtmlSender.send(mailTo, "Spring boot app", "email/template-1", context);
		emailSender.sendPlainText(mailTo, "Spring boot app", "this is not samp");
	}

}
