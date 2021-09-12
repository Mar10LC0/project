package com.mario.luftansa.luftansaProject.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.mario.luftansa.luftansaProject.entity.LejeAplikim;

@Repository
public interface LejeAplikimDao extends JpaRepository<LejeAplikim, Integer> 
{
	String findByEmail(String email);

}
