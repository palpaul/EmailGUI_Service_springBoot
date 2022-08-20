package com.email.service;

import java.io.File;
import java.io.File;
import java.io.IOException;
import java.net.PasswordAuthentication;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.stereotype.Service;
@Service
public class EmailServiceImpl implements EmailService{

	@Override
	public boolean sendEmail(String subject, String message, String to) {
		boolean flag = false;
		String from = "rkpal12cs39@gmail.com";
	//variable for gmail host
		String host = "smtp.gmail.com";
		//get the system properties
		Properties properties = System.getProperties();
		System.out.println("PROPERTIES "+properties);
		
		//setting importtant informtaiton to propetties object
		
		//host set
		
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");
		
		//step 1 to get the session object after authentication
	
		Session session  = Session.getInstance(properties, new Authenticator() {

			@Override
			protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new javax.mail.PasswordAuthentication("rkpal12cs39@gmail.com", "jitvupyhecestpzv");
			}
			
		});
		
		session.setDebug(true);
		
		//step 2 compose the message [text, attatchement, media]
		MimeMessage m = new MimeMessage(session);
		// from email
		try {
			m.setFrom(from);
			
			//adding recipient
			m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			
			//adding sub to message
			m.setSubject(subject);
			
			//adding text to message
			m.setText(message); 
			
			//send
			//step 3 send the message using transport class
			Transport.send(m);
			
			System.out.println("Sent success...........................");
			flag = true;
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
		
	}
	
}
