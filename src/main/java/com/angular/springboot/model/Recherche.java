package com.angular.springboot.model;

import java.util.ArrayList;
import java.util.List;


public class Recherche {
	 private String specialite;
	 private List<Medecin> listmed;
	 
	 public Recherche() {
		 super();
		 this.specialite="";
		 this.listmed= new ArrayList<>();
				 
	 
	 }

	public String getSpecialite() {
		return specialite;
	}

	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}

	public List<Medecin> getListmed() {
		return listmed;
	}

	public void setListmed(List<Medecin> listmed) {
		this.listmed = listmed;
	}

}
