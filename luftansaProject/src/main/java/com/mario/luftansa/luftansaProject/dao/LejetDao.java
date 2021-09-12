package com.mario.luftansa.luftansaProject.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.mario.luftansa.luftansaProject.entity.Leje;
import com.mario.luftansa.luftansaProject.entity.Punonjes;



@Repository
public interface LejetDao extends JpaRepository<Leje, Integer>,PagingAndSortingRepository<Leje, Integer> 
{
	Page<Leje> findAll(Pageable pageable);
	
}
