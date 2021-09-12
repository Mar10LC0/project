package com.mario.luftansa.luftansaProject.controller;

import java.io.IOException;

import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mario.luftansa.luftansaProject.dto.LejeAplikimDto;
import com.mario.luftansa.luftansaProject.entity.LejeAplikim;
import com.mario.luftansa.luftansaProject.service.LejeAplikimService;

@RestController
@CrossOrigin(origins = "*")
public class LejeAplikimController
{
	 @Autowired
	 LejeAplikimService service;
	
	 @PostMapping("/addLejeApplication")
	  public LejeAplikim addLejeApplication(@RequestBody LejeAplikimDto lejeForm) throws MessagingException
	 {
	    return service.addLejeApplication(lejeForm);
	 }
		
	@GetMapping("/lejeApplications")
	public List<LejeAplikim> getAll() 
    {
		return service.getAll();
	}
	
	@PostMapping("/addJobApplicationn")
	public LejeAplikim postoLejeKthimPergjigje( @RequestParam Integer lejeId, 
												@RequestParam String pershkrim,
												@RequestParam String email) throws MessagingException, IOException 
	{
		HttpHeaders headers = new HttpHeaders();
	    headers.add("Access-Control-Allow-Origin", "*");
	    return service.postLejeKthimPergjigje(lejeId, pershkrim, email);
		
	}

}
