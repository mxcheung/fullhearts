package au.com.maxcheung.emailservice.server;
 
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.*;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import au.com.maxcheung.emailservice.model.EmailDTO;
import au.com.maxcheung.emailservice.model.Greeting;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping(value = EmailController.EMAIL_BASE_CONTEXT)
public interface EmailController {

    String EMAIL_BASE_CONTEXT = "/v6/email";

    String TEST_MAPPING = "/test";
	String RESET_PASSWORD_MAPPING = "/resetPwd";


	@RequestMapping(value = TEST_MAPPING, method = GET)
	@ResponseStatus(OK)
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name);

    
    @RequestMapping(value = RESET_PASSWORD_MAPPING, method = POST, consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(OK)
    public void resetPassword(@RequestBody EmailDTO emailDTO);


}