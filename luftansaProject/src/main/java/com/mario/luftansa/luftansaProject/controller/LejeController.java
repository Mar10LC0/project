package com.mario.luftansa.luftansaProject.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mario.luftansa.luftansaProject.entity.Leje;
import com.mario.luftansa.luftansaProject.service.LejeService;
import com.mario.luftansa.luftansaProject.serviceImpl.ExporterServiceImpl;



@RestController
@CrossOrigin(origins = "*")
public class LejeController 
{
	@Autowired
	ExporterServiceImpl exporterService;
	
	@Autowired
	LejeService service;
	
	@GetMapping("/lejet")
    public Page<Leje> getAllLejet(@RequestParam(required = false) Integer offset) 
	{
		return service.getAllPaginated(offset);
	}
    
    @GetMapping("/leje")
    public Leje getById(@RequestParam Integer leje) 
    {
		return service.getById(leje);
	}
    
    @GetMapping("/lejetList")
    public List<Leje> getAll()
    {
		return service.getAll();
	}
    
    @PostMapping("/shtoLeje")
    public Leje addLeje(@RequestBody Leje leje) {
		return service.shtoLeje(leje);
	}
    
    @PutMapping("/perditsoLeje")
    public Leje updateLeje(@RequestBody Leje leje) {
		return service.update(leje);
	}
    
    @DeleteMapping("/deleteLeje")
    public boolean deleteLeje(@RequestParam Integer lejeId) {
		return service.delete(lejeId);
	}
	
    @PutMapping("/ktheRefuzimLeje")
    public Leje refuzoLeje(@RequestParam Integer lejeId) {
		return service.logicalDelete(lejeId);
	}
    
    @GetMapping("/activeLeje")
    public List<Leje> getActiveLeje() {
		return service.getActive();
	}
    
    @PostMapping(value = "leje/csvT")
	public void stampaFornitoreCsvT(HttpServletResponse response,
			 @RequestBody final List<Leje> params)
    {

		//exporterService(response, params);
	}

}
