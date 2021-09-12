package com.mario.luftansa.luftansaProject.entity;

import java.util.Date;
import java.util.Set;

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
@Table(name = "leje", schema = "tia")
public class Leje 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "pershkrim", unique = true, nullable = false)
	private String pershkrim;
	
	@Column(name = "date_fillimi", unique = true, nullable = false)
	private Date dateFillimi;
	
	@Column(name = "date_mbarimi", unique = true, nullable = false)
	private Date dateMbarimi;
	
	@Column(name = "state")
	private String state;
	
	@ManyToOne
	@JoinColumn(name = "punonjes_Id")
	private Punonjes punonjes;

}
