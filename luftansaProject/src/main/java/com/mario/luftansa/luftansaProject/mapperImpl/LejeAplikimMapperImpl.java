package com.mario.luftansa.luftansaProject.mapperImpl;

import org.springframework.stereotype.Component;

import com.mario.luftansa.luftansaProject.dto.LejeAplikimDto;
import com.mario.luftansa.luftansaProject.entity.LejeAplikim;
import com.mario.luftansa.luftansaProject.mapper.LejeAplikimMapper;

@Component
public class LejeAplikimMapperImpl implements LejeAplikimMapper 
{

	@Override
	public LejeAplikim LejeAplikimToLejeAplikimDto(LejeAplikimDto lejeAplikimDto)
	{
		LejeAplikim l = new LejeAplikim();
		
		if(lejeAplikimDto.getId() != null)
		{
			l.setId(lejeAplikimDto.getId());
		}
		if(lejeAplikimDto.getEmail() != null)
		{
			l.setEmail(lejeAplikimDto.getEmail());
		}
		if(lejeAplikimDto.getPershkrim() != null)
		{
			l.setPershkrim(lejeAplikimDto.getPershkrim());
		}
		//mapper per leje TODO
		return l;
	}

	@Override
	public LejeAplikimDto LejeAplikimDtoToLejeApplikim(LejeAplikim lejeAplikim)
	{
		LejeAplikimDto ld = new LejeAplikimDto();
		
		if(lejeAplikim.getId() != null )
		{
			ld.setId(lejeAplikim.getId());
		}
		if(lejeAplikim.getEmail() != null)
		{
			ld.setEmail(lejeAplikim.getEmail());;
		}
		if(lejeAplikim.getPershkrim() != null)
		{
			ld.setPershkrim(lejeAplikim.getPershkrim());
		}
		
		//TODO Leje per mapper
		return ld;
	}

}
