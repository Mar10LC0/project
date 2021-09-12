package com.mario.luftansa.luftansaProject.serviceImpl;


import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mario.luftansa.luftansaProject.dao.PunonjesDao;
import com.mario.luftansa.luftansaProject.entity.Punonjes;

@Service
public class UserService implements UserDetailsService 
{
	@Autowired
	PunonjesDao dao;


	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException
	{
		Punonjes punonjes = dao.findByEmail(email);
		
		if(email == null)
		{
			throw new UsernameNotFoundException("User not found for specified email" + email);
		}
		return new org.springframework.security.core.userdetails.User(punonjes.getEmail(), punonjes.getPassword(), (Collection<? extends GrantedAuthority>) punonjes.getRole());
	}

}
