package au.com.maxcheung.emailservice.model;

import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class EmailDTO {

    private String to;
    private String Subject;
    private List<EmailParameter> emailParams;
    
	public String getTo() {
		return to;
	}
	
	
	public void setTo(String to) {
		this.to = to;
	}
	public String getSubject() {
		return Subject;
	}
	public void setSubject(String subject) {
		Subject = subject;
	}


	public List<EmailParameter> getEmailParams() {
		return emailParams;
	}


	public void setEmailParams(List<EmailParameter> emailParams) {
		this.emailParams = emailParams;
	}

	
	
    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("to", to)
                .append("Subject", Subject)
                .toString();
    }
	


    
    
    
}