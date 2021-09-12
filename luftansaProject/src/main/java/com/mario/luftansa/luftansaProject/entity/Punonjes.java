package com.mario.luftansa.luftansaProject.entity;


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;



@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "punonjes", schema = "tia")
public class Punonjes 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "emri", nullable = false)
	private String emri;
	
	@Column(name = "mbiemri", nullable = false)
	private String mbiemri;
	
	@Column(name = "pozicioni", nullable = false)
	private String pozicioni;
	
	@Column(name = "dat_punsimi", unique = true, nullable = false)
	private Date datPunsimi;
	
	@Column(name = "mosha", nullable = false)
	private String mosha;
	
	@Column(name = "email", nullable = false)
	private String email;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	//@ManyToMany
	//@JoinTable(name="punonjes_role",joinColumns= @JoinColumn(name="punonjes_id"), inverseJoinColumns=@JoinColumn(name="role_id") )
	@OneToOne
	@JoinColumn(name = "role_ID", referencedColumnName = "id")
	private Role role;

}
