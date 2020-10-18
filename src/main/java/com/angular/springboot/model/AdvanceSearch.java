package com.angular.springboot.model;

import java.util.ArrayList;
import java.util.List;

public class AdvanceSearch {

	private String specialite;
	private String pseudo;
	 private List<Medecin> listmed;
	 
	 public AdvanceSearch() {
		 super();
		 this.specialite="";
		 this.pseudo="";
		 this.listmed= new ArrayList<>();

	 }

	public String getSpecialite() {
		return specialite;
	}

	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public List<Medecin> getListmed() {
		return listmed;
	}

	public void setListmed(List<Medecin> listmed) {
		this.listmed = listmed;
	}
						 
}
