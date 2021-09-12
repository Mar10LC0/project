package com.mario.luftansa.luftansaProject.dao;



import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.mario.luftansa.luftansaProject.entity.Punonjes;

@Repository
public interface PunonjesDao extends JpaRepository<Punonjes, Integer> 
{
	Punonjes findByEmail(String email);
	
	Punonjes findByEmailAndPassword(String email, String password);

}
