package com.email.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.email.model.EmailRequest;
import com.email.model.EmailResponse;
import com.email.service.EmailServiceImpl;

import ch.qos.logback.core.status.Status;

@RestController
@CrossOrigin
public class EmailController {
	@Autowired
	private EmailServiceImpl emailserviceimpl;

	@GetMapping("/welcome")
	public String Welcome() {
		return "Hello This is my Email";
	}
	
	//method to send email
	@CrossOrigin(origins="*",allowedHeaders="*")
	@PostMapping("/sendemail")
	public ResponseEntity<?> sendEmail(@RequestBody EmailRequest emailrequest){
		System.out.println(emailrequest);
		boolean result = this.emailserviceimpl.sendEmail(emailrequest.getSubject(), emailrequest.getMessage(), emailrequest.getTo());
//return ResponseEntity.ok("Email sent successfully...");	
				if(result) {
			return ResponseEntity.ok(new EmailResponse("Email sent successfully..."));	
		}else {
			return (ResponseEntity<?>) ResponseEntity.status(Status.ERROR).body(new EmailResponse("Email not sent"));
		}
			
		
	}
}
