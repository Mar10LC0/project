package com.mario.luftansa.luftansaProject.utilImpl;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.mario.luftansa.luftansaProject.util.EmailUtil;

@Component
public class EmailUtilImpl implements EmailUtil
{
	@Autowired
	private JavaMailSender sender;

	@Override
	public void sendEmail(String toAddress, String subject, String body) 
	{
		MimeMessage message = sender.createMimeMessage();
		//mer mesazhin edhe i perdorim nga kjo
		MimeMessageHelper helper = new MimeMessageHelper(message);
		try 
		{
			helper.setTo(toAddress);
			helper.setSubject(subject);
			helper.setText(body);
		} 
		catch (MessagingException e) 
		{
			e.printStackTrace();
		}
		
		
		sender.send(message);
	}

}
