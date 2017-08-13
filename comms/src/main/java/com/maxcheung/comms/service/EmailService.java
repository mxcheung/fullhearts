package com.maxcheung.comms.service;


 
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;

import au.com.maxcheung.emailservice.model.EmailDTO;
import au.com.maxcheung.emailservice.model.EmailParameter;
import au.com.maxcheung.emailservice.model.EmailStatus;
import au.com.maxcheung.emailservice.model.Greeting;
 
@Service
public class EmailService {
 
    
    @Value("${mail.to}")
    private String mailTo;
	
    @Autowired
    private EmailHtmlSender emailHtmlSender;
    
    @Autowired
    private EmailSender emailSender;
    
    
    public void sendEmail(String name, String subject, Map<String, String> datamap) {
		Context context = new Context();
		for (Map.Entry<String, String> entry : datamap.entrySet()) {
			context.setVariable(entry.getKey(), entry.getValue());
		}
		EmailStatus emailStatus = emailHtmlSender.send(mailTo, subject, "email/template-1", context);
		emailSender.sendPlainText(mailTo, "Spring boot app", "this is not samp");
	}
    
    
	private Map<String, String> translate(List<EmailParameter> params) {
		Map<String, String> datamap = new HashMap<String, String>();
		for (EmailParameter param : params) {
			datamap.put(param.getKey(), param.getValue());
		}
		return datamap;
	}


	public void sendEmail(EmailDTO emailDTO) {
		String name = emailDTO.getTo();
    	String subject = emailDTO.getSubject();
		Map<String, String> datamap = translate(emailDTO.getEmailParams());
		sendEmail(name,subject,datamap);
		
	}

}