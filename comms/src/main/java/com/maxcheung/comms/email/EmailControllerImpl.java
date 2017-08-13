package com.maxcheung.comms.email;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.maxcheung.comms.service.EmailService;

import au.com.maxcheung.emailservice.model.EmailDTO;
import au.com.maxcheung.emailservice.model.Greeting;
import au.com.maxcheung.emailservice.server.EmailController;

@RestController
public class EmailControllerImpl implements EmailController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@Autowired
	private EmailService emailService;

	@Override
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") final String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

	@Override
	public void resetPassword(@RequestBody final EmailDTO emailDTO) {
		emailService.sendEmail(emailDTO);
	}

}