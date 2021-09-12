package com.mario.luftansa.luftansaProject.mapper;

import com.mario.luftansa.luftansaProject.dto.LejeAplikimDto;
import com.mario.luftansa.luftansaProject.entity.LejeAplikim;

public interface LejeAplikimMapper 
{
	LejeAplikim LejeAplikimToLejeAplikimDto(LejeAplikimDto lejeAplikimDto);
	
	LejeAplikimDto LejeAplikimDtoToLejeApplikim(LejeAplikim lejeAplikim);

}
