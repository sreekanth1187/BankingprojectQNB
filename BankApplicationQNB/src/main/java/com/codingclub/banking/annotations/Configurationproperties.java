package com.codingclub.banking.annotations;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix="combo")
@Component
public class Configurationproperties {
	
	private String mailType;
	private String mailbody;
	private String mailsign;
	
	
	
	public String getMailType() {
		return mailType;
	}
	public void setMailType(String mailType) {
		this.mailType = mailType;
	}
	public String getMailbody() {
		return mailbody;
	}
	public void setMailbody(String mailbody) {
		this.mailbody = mailbody;
	}
	public String getMailsign() {
		return mailsign;
	}
	public void setMailsign(String mailsign) {
		this.mailsign = mailsign;
	}
	
	

}
