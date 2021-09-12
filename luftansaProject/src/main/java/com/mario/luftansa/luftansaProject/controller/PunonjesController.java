package com.mario.luftansa.luftansaProject.controller;

import java.util.List;



import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mario.luftansa.luftansaProject.dao.PunonjesDao;
import com.mario.luftansa.luftansaProject.dto.PunonjesDto;
import com.mario.luftansa.luftansaProject.entity.Punonjes;
import com.mario.luftansa.luftansaProject.service.PunonjesService;

import ch.qos.logback.classic.Logger;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/")
@Api(value = "PunonjesController")
@Slf4j
public class PunonjesController 
{
	@Autowired
	PunonjesService punonjesService;
	
	@Autowired
	PunonjesDao dao;
	
	//@Autowired
	//SecurityService securityService;
	
	//@Autowired
	//private BCryptPasswordEncoder encoder;
	
	private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(PunonjesController.class);
	
	@RequestMapping("/showReg")
	public String showRegistrationPage()
	{
		return "index.html";
	}
	
	@PostMapping("/registerUser")
	public String register(@ModelAttribute("user") Punonjes punonjes)
	{
		LOGGER.info("Po regjistrohemi");
		//punonjes.setPassword(encoder.encode(punonjes.getPassword()));
		punonjes.setPassword(punonjes.getPassword());
		dao.save(punonjes);
		return "login/login";		
	}
	
	@RequestMapping("/showLogin")
	public String showLoginPage()
	{
		return "login/login";
	}
	
	@GetMapping("/showAllPunonjes")
	public List<PunonjesDto> getAll()
	{
		log.debug("Te gjithe punonjesit");
		return punonjesService.getAll();
	}
	
	@GetMapping("punonjes/id")
	public PunonjesDto findByIdPunonjes(@RequestParam Integer id) 
	{
		PunonjesDto dto = punonjesService.findById(id);	
			
		log.debug("Gjej sipas id");
			
		return dto;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(@RequestParam("email") String email, 
						@RequestParam("password") String password,
						ModelMap modelMap)
	{

		//boolean loginResponse = securityService.login(email, password);
		Punonjes p = dao.findByEmail(email);
		LOGGER.info("Brenda loginit dhe emaili eshte: " + email);
		if(p.getPassword().equals(password))
		{
			return "shikoAplikimet";
		}
		else
		{
			modelMap.addAttribute("msg", "Kredinciale te gabuara. Provo perseri");
		}
		
		return "login/login";
		
	}
	
	@GetMapping("/authenticate")
	public Punonjes getUser(@RequestParam String email,@RequestParam String password) 
	{
		Punonjes user = punonjesService.authenticate(email, password);
		return user;
	}

}
