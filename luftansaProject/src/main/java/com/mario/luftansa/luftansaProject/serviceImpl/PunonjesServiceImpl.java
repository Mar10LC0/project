package com.mario.luftansa.luftansaProject.serviceImpl;

import java.math.BigInteger;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mario.luftansa.luftansaProject.dao.PunonjesDao;
import com.mario.luftansa.luftansaProject.dto.PunonjesDto;
import com.mario.luftansa.luftansaProject.entity.Punonjes;
import com.mario.luftansa.luftansaProject.mapper.PunonjesMapper;
import com.mario.luftansa.luftansaProject.service.PunonjesService;

@Service
public class PunonjesServiceImpl implements PunonjesService
{
	@Autowired(required=true)
	PunonjesDao dao;
	
	@Autowired(required=true)
	PunonjesMapper mapper;

	@Override
	public List<PunonjesDto> getAll() 
	{
		List<Punonjes> pn = dao.findAll();
		
		List<PunonjesDto> pnDto = new ArrayList<>();
		
		for(Punonjes p : pn)
		{
			PunonjesDto dto = mapper.PunonjesToPunonjesDto(p);
			pnDto.add(dto);
		}
		return pnDto;
	}

	@Override
	public PunonjesDto findById(Integer id)
	{
		Punonjes p = dao.findById(id).orElseThrow(() -> new RuntimeException("Spo e gjej dot punonjesin"));
		
		return mapper.PunonjesToPunonjesDto(p);
	}

	@Override
	public PunonjesDto save(PunonjesDto punonjesDto) 
	{
		Punonjes p = mapper.PunonjesDtoToPunonjes(punonjesDto);
		
		Punonjes punonjes = dao.save(p);
		
		return mapper.PunonjesToPunonjesDto(punonjes);
	}

	@Override
	public PunonjesDto update(PunonjesDto dto) 
	{
		Punonjes p = dao.findById(dto.getId()).orElseThrow(() -> new RuntimeException("Spo e gjej dot punonjesin"));
		
		Punonjes pn = null;
		
		if(p != null)
		{
			p = mapper.PunonjesDtoToPunonjes(dto);
			
			pn  = dao.save(p);
		}
		return mapper.PunonjesToPunonjesDto(pn);
	}

	@Override
	public void delete(Integer id) 
	{
		dao.deleteById(id);
	}
	
	public static String encryptThisString(String input) 
    { 
        try 
        { 
            // getInstance() method is called with algorithm SHA-1 
            MessageDigest md = MessageDigest.getInstance("SHA-1"); 
  
            // digest() method is called 
            // to calculate message digest of the input string 
            // returned as array of byte 
            byte[] messageDigest = md.digest(input.getBytes()); 
  
            // Convert byte array into signum representation 
            BigInteger no = new BigInteger(1, messageDigest); 
  
            // Convert message digest into hex value 
            String hashtext = no.toString(16); 
  
            // Add preceding 0s to make it 32 bit 
            while (hashtext.length() < 32) { 
                hashtext = "0" + hashtext; 
          } 
  
            // return the HashText 
            return hashtext; 
        } 
  
        // For specifying wrong message digest algorithms 
        catch (NoSuchAlgorithmException e) 
        { 
            throw new RuntimeException(e); 
        } 
    } 
	

	@Override
	public Punonjes authenticate(String email, String password)
	{
		String hashed = this.encryptThisString(password);
		
		Punonjes user = dao.findByEmailAndPassword(email, hashed);
		
	    return user;
	}

}
