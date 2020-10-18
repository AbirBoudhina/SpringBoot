package com.angular.springboot.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="rv")
public class Rv {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String jour;
	
	//@JsonBackReference
	@JoinColumn(name="ID_Medecin",referencedColumnName="id")
	@ManyToOne(optional=false)
	private Medecin medecin;
	
	//@JsonBackReference
	@JoinColumn(name="ID_Client",referencedColumnName="id")
	@ManyToOne(optional=false)
	private Client client;

	public Medecin getMedecin() {
		return medecin;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getJour() {
		return jour;
	}

	public void setJour(String jour) {
		this.jour = jour;
	}

	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Rv(long id, String jour) {
		super();
		this.id = id;
		this.jour = jour;
	}

	public Rv() {
		super();
		client = new Client();
		medecin = new Medecin();
	}
	
}