package com.maxcheung.comms.email;
 
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.context.Context;


@RestController
@RequestMapping(value = "/v6/funddata/greeting")
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    
	
    @Autowired
    private EmailHtmlSender emailHtmlSender;
    
    @Autowired
    private EmailSender emailSender;
    
    
    @Value("${mail.to}")
    private String mailTo;

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
     	Map<String, String> datamap = new HashMap<String, String>();
     	datamap.put("title", "Lorem Ipsum ");
     	datamap.put("description", "Lorem Lorem Lorem");
     	sendEmail(name, "Spring boot app", datamap);
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
    
    
    @RequestMapping("/greetmail")
    public Greeting greeting(@RequestBody EmailDTO emailDTO) {
    	String name = emailDTO.getTo();
    	String subject = emailDTO.getSubject();
    	Map<String, String> datamap = emailDTO.getDatamap();
    	sendEmail(name, subject,datamap);
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }


	private void sendEmail(String name, String subject, Map<String, String> datamap) {
		Context context = new Context();
//		context.setVariable("title", "Lorem Ipsum " + name);
//		context.setVariable("description", "Lorem Lorem Lorem");
	//	datamap.keySet()
		for (Map.Entry<String, String> entry : datamap.entrySet()) {
		//	System.out.println("Item : " + entry.getKey() + " Count : " + entry.getValue());
			context.setVariable(entry.getKey(), entry.getValue());
		}
		EmailStatus emailStatus = emailHtmlSender.send(mailTo, subject, "email/template-1", context);
		emailSender.sendPlainText(mailTo, "Spring boot app", "this is not samp");
	}
}