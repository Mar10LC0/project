package com.mario.luftansa.luftansaProject.service;

import java.io.IOException;

import java.util.List;

import javax.mail.MessagingException;

import org.springframework.web.multipart.MultipartFile;

import com.mario.luftansa.luftansaProject.dto.LejeAplikimDto;
import com.mario.luftansa.luftansaProject.entity.LejeAplikim;

public interface LejeAplikimService 
{
	public LejeAplikim addLejeApplication(LejeAplikimDto jobApplication) throws MessagingException ;
	
	public List<LejeAplikim> getAll();
	
	public LejeAplikim getFileName(Integer jobApp);
	
	public LejeAplikim postLejeKthimPergjigje( Integer lejeId,  String pershkrim, String email) throws MessagingException, IOException  ;


}
