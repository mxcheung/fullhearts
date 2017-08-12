package com.maxcheung.comms.email;

import java.util.Map;

public class EmailDTO {

    private String to;
    private String Subject;
    
    private Map<String,String> datamap;

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

	public Map<String, String> getDatamap() {
		return datamap;
	}

	public void setDatamap(Map<String, String> datamap) {
		this.datamap = datamap;
	}

    
    
    
}