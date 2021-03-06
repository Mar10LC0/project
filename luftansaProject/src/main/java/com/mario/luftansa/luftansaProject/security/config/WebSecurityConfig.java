package com.mario.luftansa.luftansaProject.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter
{
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
	    return super.authenticationManagerBean();
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception
	{
		
		 http.authorizeRequests()
         .antMatchers("/users","/swagger-ui.html#","/addLejeApplication").authenticated()
         .anyRequest().permitAll()
         .and()
         .formLogin()
             .usernameParameter("email")
             .defaultSuccessUrl("/users")
             .permitAll()
         .and()
         .logout().logoutSuccessUrl("/").permitAll();
		 http.csrf().disable();
		
	}

}
