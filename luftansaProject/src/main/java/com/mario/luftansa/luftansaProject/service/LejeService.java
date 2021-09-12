package com.mario.luftansa.luftansaProject.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.mario.luftansa.luftansaProject.entity.Leje;


public interface LejeService 
{
	public List<Leje> getAll();
	
	public Page<Leje> getAllPaginated(Integer offset);
	
	public Leje update(Leje lejet);
	
	public Leje shtoLeje(Leje lejet);
	
	public boolean delete(Integer lejeId);
	
	public Leje logicalDelete(Integer lejeId);
	
	public List<Leje> getActive();
	
	public Leje getById(Integer lejeId);

}
