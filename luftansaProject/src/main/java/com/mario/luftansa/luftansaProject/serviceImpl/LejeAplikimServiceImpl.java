package com.mario.luftansa.luftansaProject.serviceImpl;

import java.io.IOException;
import java.util.List;


import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import com.mario.luftansa.luftansaProject.dao.LejeAplikimDao;
import com.mario.luftansa.luftansaProject.dao.LejetDao;
import com.mario.luftansa.luftansaProject.dto.LejeAplikimDto;
import com.mario.luftansa.luftansaProject.entity.LejeAplikim;
import com.mario.luftansa.luftansaProject.service.LejeAplikimService;

@Service
public class LejeAplikimServiceImpl implements LejeAplikimService 
{
	@Autowired
	LejeAplikimDao dao;
	
	@Autowired
	LejetDao lDao;
	
	@Autowired
    private JavaMailSender javaMailSender;

	@Override
	@Transactional
	public LejeAplikim addLejeApplication(LejeAplikimDto lejeAplikim) throws MessagingException 
	{
		 LejeAplikim l = new LejeAplikim();
		 if (lejeAplikim.getId()!= null) 
		 {
			    l.setEmail(lejeAplikim.getEmail());
				l.setPershkrim(lejeAplikim.getPershkrim());
				l.setLeje(lejeAplikim.getLeje());
		 }
		
		l = dao.save(l);
		return l;
	}

	@Override
	public List<LejeAplikim> getAll() 
	{
		return dao.findAll();
	}

	@Override
	public LejeAplikim getFileName(Integer jobApp) 
	{
		return null;
	}
	
	void sendEmail(String id, String email,String pershkrim) throws MessagingException, IOException 
	{
		
		String email1 = dao.findByEmail(email);
		
		MimeMessage message = javaMailSender.createMimeMessage();
	    MimeMessageHelper helper = new MimeMessageHelper(message, true);
	    helper.setTo(email1);
	   
	    helper.setSubject("Kthim pergjigje per Leje");
	    helper.setText("Email: " + email +
                	   "Pershkrim: " + pershkrim );
	    
	    
	    javaMailSender.send(message);
	}

	@Override
	@Transactional
	public LejeAplikim postLejeKthimPergjigje(Integer lejeId, String pershkrim, String email)
			throws MessagingException, IOException
	{
		LejeAplikim l = new LejeAplikim();
		
		l.setPershkrim(pershkrim);
		l.setEmail(email);
		l.setLeje(lDao.findById(lejeId).get());
		
		
		l = dao.save(l);
		this.sendEmail( l.getId().toString(),pershkrim, email);
		return l;
	}

}
