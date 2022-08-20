package com.email.model;

public class EmailResponse {
	 String response;

	public EmailResponse(String response) {
		super();
		this.response = response;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	@Override
	public String toString() {
		return "EmailResponse [response=" + response + "]";
	}
	
	
}
