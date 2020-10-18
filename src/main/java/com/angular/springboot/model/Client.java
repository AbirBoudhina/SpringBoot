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
@Table(name="clients")
public class Client implements Serializable {
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
 private long id;
 private String nom;
 private String prenom;
 
 //@JsonManagedReference

//@OneToMany(mappedBy="client",fetch=FetchType.LAZY,cascade=CascadeType.DETACH)
//private List<Rv> Lrdvs;
 
public Client(long id, String nom, String prenom, List<Rv> lrdvs) {
	super();
	this.id = id;
	this.nom = nom;
	this.prenom = prenom;
 //Lrdvs = lrdvs;
}
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
public Client() {
	super();
	// TODO Auto-generated constructor stub
}
public Client(long id, String nom, String prenom) {
	super();
	this.id = id;
	this.nom = nom;
	this.prenom = prenom;
}
 
 
}
