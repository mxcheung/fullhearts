package com.maxcheung.comms;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thymeleaf.context.Context;

import com.icegreen.greenmail.util.GreenMail;
import com.icegreen.greenmail.util.ServerSetup;
import com.maxcheung.comms.service.EmailHtmlSender;
import com.maxcheung.comms.service.EmailSender;

import au.com.maxcheung.emailservice.model.EmailStatus;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SendMailTests {
	
	private GreenMail smtpServer;
	

	
	
    @Autowired
    private EmailHtmlSender emailHtmlSender;
    
    @Autowired
    private EmailSender emailSender;
    
    
    @Value("${mail.to}")
    private String mailTo;
	
    @Before
    public void setUp() throws Exception {
        smtpServer = new GreenMail(new ServerSetup(25, null, "smtp"));
        smtpServer.start();
    }
	
    @After
    public void tearDown() throws Exception {
        smtpServer.stop();
    }
    
    
    @Test
	public void shouldSendMail() throws Exception {
	    //given
	    String recipient = "name@dolszewski.com";
	    String message = "Test message content";
	    //when
	    

		Context context = new Context();
		context.setVariable("title", "Lorem Ipsum");
		context.setVariable("description", "Lorem Lorem Lorem");
	//	EmailStatus emailStatus = emailHtmlSender.send(mailTo, "Spring boot app", "email/template-1", context);
		emailSender.sendPlainText(mailTo, "Spring boot app", message);
		
//	    mailClient..prepareAndSend(recipient, message);
	    //then
	    assertReceivedMessageContains(message);
	}
	 
	private void assertReceivedMessageContains(String expected) throws IOException, MessagingException {
	    MimeMessage[] receivedMessages = smtpServer.getReceivedMessages();
	    assertEquals(1, receivedMessages.length);
	    String content = (String) receivedMessages[0].getContent();
	    assertTrue(content.contains(expected));
	}
	
	
}
