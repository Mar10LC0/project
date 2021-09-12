package com.mario.luftansa.luftansaProject.dto;

import java.util.Date;

import lombok.Data;

@Data
public class PunonjesDto
{
	private Integer id;
	
	private String emri;
	
	private String mbiemri;
	
	private String pozicioni;
	
	private Date datPunsimi;
	
	private String mosha;
	
	private String email;
}
