package com.angular.springboot.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="medecins")
public class Medecin implements Serializable{
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	 private long id;
	 private String nom;
	 private String prenom;
	 private String specialite;
	 
	// @JsonManagedReference
//@OneToMany(mappedBy="medecin",fetch=FetchType.LAZY,cascade=CascadeType.REMOVE)
 //private List<Rv> Lrdvs;
	 

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getSpecialite() {
		return specialite;
	}
	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}
	public Medecin(long id, String nom, String prenom, String specialite) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.specialite = specialite;
	}
	public Medecin() {
		super();
		// TODO Auto-generated constructor stub
	}
	 
	 
}
