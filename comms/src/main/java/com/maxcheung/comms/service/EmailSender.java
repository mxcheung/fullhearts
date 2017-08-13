package com.maxcheung.comms.service;
 
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import au.com.maxcheung.emailservice.model.EmailStatus;
 
@Component
public class EmailSender {
 
    private static final Logger LOGGER = LoggerFactory.getLogger(EmailSender.class);
 
    @Autowired
    private JavaMailSender javaMailSender;
    
    
    @Value("${mail.from}")
    private String mailFrom;

 
    public EmailStatus sendPlainText(String recipientEmail, String subject, String text) {
        return sendM(recipientEmail, subject, text, false);
    }
 
    public EmailStatus sendHtml(String recipientEmail, String subject, String htmlBody) {
        return sendM(recipientEmail, subject, htmlBody, true);
    }
 
    private EmailStatus sendM(String recipientEmail, String subject, String text, Boolean isHtml) {
        try {
            final MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            final MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, false);
            helper.setFrom(mailFrom);
            helper.setTo(recipientEmail);
            helper.setSubject(subject);
            helper.setText(text, isHtml);
            javaMailSender.send(mimeMessage);
            LOGGER.info("Send email '{}' to: {}", subject, recipientEmail);
            return new EmailStatus(recipientEmail, subject, text).success();
        } catch (Exception e) {
            LOGGER.error(String.format("Problem with sending email to: {}, error message: {}", recipientEmail, e.getMessage()));
            return new EmailStatus(recipientEmail, subject, text).error(e.getMessage());
        }
    }
}