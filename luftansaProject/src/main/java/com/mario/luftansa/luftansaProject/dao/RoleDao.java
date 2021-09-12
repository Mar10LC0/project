package com.mario.luftansa.luftansaProject.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mario.luftansa.luftansaProject.entity.Role;

@Repository
public interface RoleDao extends JpaRepository<Role, Integer> {

}
