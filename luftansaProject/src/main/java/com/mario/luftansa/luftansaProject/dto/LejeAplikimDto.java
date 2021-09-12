package com.mario.luftansa.luftansaProject.dto;

import com.mario.luftansa.luftansaProject.entity.Leje;

import lombok.Data;

@Data
public class LejeAplikimDto
{	
	private Integer id;
	
	private String email;
	
	private String pershkrim;
	
	private Leje leje;
}
