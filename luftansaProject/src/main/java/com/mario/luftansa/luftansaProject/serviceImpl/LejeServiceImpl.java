package com.mario.luftansa.luftansaProject.serviceImpl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.mario.luftansa.luftansaProject.dao.LejetDao;
import com.mario.luftansa.luftansaProject.dao.LejetDaoCustom;
import com.mario.luftansa.luftansaProject.entity.Leje;
import com.mario.luftansa.luftansaProject.service.LejeService;


@Service
public class LejeServiceImpl implements LejeService 
{
	@Autowired
	LejetDao dao;
	
	@Autowired
	LejetDaoCustom daoCustom;

	@Override
	public List<Leje> getAll() 
	{
		return dao.findAll();
	}

	@Override
	public Page<Leje> getAllPaginated(Integer offset) 
	{
		offset = Optional.ofNullable(offset).isPresent() ? offset : 0;
		return daoCustom.findAllLejet(offset);
	}

	@Override
	@Transactional
	public Leje update(Leje lejet) 
	{
		Optional<Leje> id = dao.findById(lejet.getId());
		
		if(id.isPresent())
		{
			Leje l = id.get();
			l.setId(lejet.getId());
			l.setPershkrim(lejet.getPershkrim());
			l.setDateFillimi(lejet.getDateFillimi());
			l.setDateMbarimi(lejet.getDateMbarimi());
			l.setPunonjes(lejet.getPunonjes());
			
			l=dao.save(l);
			return l;
		}
		return null;
	}

	@Override
	@Transactional
	public Leje shtoLeje(Leje lejet)
	{
		Leje l = new Leje();
		l.setId(lejet.getId());
		l.setPershkrim(lejet.getPershkrim());
		l.setDateFillimi(lejet.getDateFillimi());
		l.setDateMbarimi(lejet.getDateMbarimi());
		l.setPunonjes(lejet.getPunonjes());
		l = dao.save(l);
		return l;
	}

	@Override
	@Transactional
	public boolean delete(Integer lejeId) 
	{
		Optional<Leje> id = dao.findById(lejeId);
		
		if(!id.isPresent())
		{
			dao.delete(id.get());
			return true;
		}
		return false;
	}

	

	@Override
	public Leje getById(Integer lejeId) 
	{
		Optional<Leje> leje = dao.findById(lejeId);
		if(!leje.isPresent()) {
			Leje l = leje.get();
			return l;
		}
		return null;
	}
	//////////////////////////////////////////////////
	
	@Override
	public Leje logicalDelete(Integer lejeId) 
	{
		Optional<Leje> id = dao.findById(lejeId);
		
		if(!id.isPresent())
		{
			Leje l = id.get();
			l.setPershkrim("nuk aprovohet");
			return dao.save(l);	
		}
		
		return null;
	}

	@Override
	public List<Leje> getActive()
	{
		return null;
	}
	

}
