package com.mario.luftansa.luftansaProject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "Leje_Aplikim", schema = "tia")
public class LejeAplikim 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "email", unique = true, nullable = false)
	private String email;
	
	@Column(name = "pershkrim", unique = true, nullable = false)
	private String pershkrim;
	
	@ManyToOne
	@JoinColumn(name = "Leje_id", referencedColumnName = "id")
	private Leje leje;

	

}
