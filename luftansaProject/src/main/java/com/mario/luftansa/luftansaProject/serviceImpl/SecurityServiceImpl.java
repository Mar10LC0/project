package com.mario.luftansa.luftansaProject.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.mario.luftansa.luftansaProject.service.SecurityService;

@Service
public class SecurityServiceImpl implements SecurityService 
{
	@Autowired(required=true)
	UserDetailsService service;
	
	@Autowired(required=true)
	AuthenticationManager authenticationManager;

	@Override
	public boolean login(String username, String password) 
	{
		UserDetails userDetails = service.loadUserByUsername(username);
		
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userDetails, password,
				userDetails.getAuthorities());
		
		authenticationManager.authenticate(token);
		
		boolean result = token.isAuthenticated();
		
		if(result)
		{
			SecurityContextHolder.getContext().setAuthentication(token);
		}
		
		return result;
	}

}
