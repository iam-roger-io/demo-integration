package com.redhat.consulting.fuse.model;

import java.io.Serializable;

public class Email implements Serializable{

	private static final long serialVersionUID = -6265051170353770234L;
	
	private String to;
	private String cc;
	private String bcc;
	private String subject;
	private String text;
	
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getCc() {
		return cc;
	}
	public void setCc(String cc) {
		this.cc = cc;
	}
	public String getBcc() {
		return bcc;
	}
	public void setBcc(String bcc) {
		this.bcc = bcc;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	

	

}
