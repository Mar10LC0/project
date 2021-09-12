package com.mario.luftansa.luftansaProject.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

import com.mario.luftansa.luftansaProject.entity.Leje;

@Repository
public interface LejetDaoCustom 
{
	Page<Leje> findAllLejet(Integer offset);
	List<Leje> findActive();

}
