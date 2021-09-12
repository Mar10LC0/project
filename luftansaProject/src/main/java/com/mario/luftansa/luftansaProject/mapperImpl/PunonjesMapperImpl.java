package com.mario.luftansa.luftansaProject.mapperImpl;

import org.springframework.stereotype.Component;

import com.mario.luftansa.luftansaProject.dto.PunonjesDto;
import com.mario.luftansa.luftansaProject.entity.Punonjes;
import com.mario.luftansa.luftansaProject.mapper.PunonjesMapper;

@Component
public class PunonjesMapperImpl implements PunonjesMapper {

	@Override
	public Punonjes PunonjesDtoToPunonjes(PunonjesDto punonjesDto)
	{
		Punonjes p = new Punonjes();
		
		if(punonjesDto.getId() != null)
		{
			p.setId(punonjesDto.getId());
		}
		if(punonjesDto.getEmri() != null)
		{
			p.setEmri(punonjesDto.getEmri());
		}
		if(punonjesDto.getMbiemri() != null)
		{
			p.setMbiemri(punonjesDto.getMbiemri() );
		}
		if(punonjesDto.getDatPunsimi() != null)
		{
			p.setDatPunsimi(punonjesDto.getDatPunsimi());
		}
		if(punonjesDto.getMosha() != null)
		{
			p.setMosha(punonjesDto.getMosha());
		}
		if(punonjesDto.getEmail()!= null)
		{
			p.setEmail(punonjesDto.getEmail());
		}
		return p;
	}

	@Override
	public PunonjesDto PunonjesToPunonjesDto(Punonjes punonjes) 
	{
		PunonjesDto pDto = new PunonjesDto();
		
		if(punonjes.getId() != null)
		{
			pDto.setId(punonjes.getId());
		}
		if(punonjes.getEmri() != null)
		{
			pDto.setEmri(punonjes.getEmri());
		}
		
		if(punonjes.getMbiemri() != null)
		{
			pDto.setMbiemri(punonjes.getMbiemri());
		}
		
		if(punonjes.getMosha() != null)
		{
			pDto.setMosha(punonjes.getMosha());
		}
		
		if(punonjes.getPozicioni() != null)
		{
			pDto.setPozicioni(punonjes.getPozicioni());
		}
		
		if(punonjes.getDatPunsimi() != null)
		{
			pDto.setDatPunsimi(punonjes.getDatPunsimi());
		}
		
		if(punonjes.getEmail() != null)
		{
			pDto.setEmail(punonjes.getEmail());
		}
		return pDto;
	}

}
