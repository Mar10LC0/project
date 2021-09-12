package com.mario.luftansa.luftansaProject.service;

import java.util.List;


import com.mario.luftansa.luftansaProject.dto.PunonjesDto;
import com.mario.luftansa.luftansaProject.entity.Punonjes;

public interface PunonjesService
{
	List<PunonjesDto> getAll();
	
	PunonjesDto findById(Integer id);
	
	PunonjesDto save(PunonjesDto punonjesDto);
	
	PunonjesDto update(PunonjesDto dto);
	
	void delete(Integer id);
	
	public Punonjes authenticate(String email,String password);

}
