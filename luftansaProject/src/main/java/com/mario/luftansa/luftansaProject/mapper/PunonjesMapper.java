package com.mario.luftansa.luftansaProject.mapper;

import com.mario.luftansa.luftansaProject.dto.PunonjesDto;
import com.mario.luftansa.luftansaProject.entity.Punonjes;

public interface PunonjesMapper 
{
	Punonjes PunonjesDtoToPunonjes(PunonjesDto punonjesDto);
	
	PunonjesDto PunonjesToPunonjesDto(Punonjes punonjes);

}
