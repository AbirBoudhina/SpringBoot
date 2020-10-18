package com.angular.springboot.service;

import java.util.List;

import com.angular.springboot.model.Client;
import com.angular.springboot.model.Medecin;

public interface MedecinService {
	
	public List<Medecin> getAllMedecins();
    public List<Medecin> findBySpecialite(String spec);
	public Medecin getMedecinById(long id);
    public void saveOrUpdate(Medecin med);
    public void deleteMedecin(long id);
    public List<Medecin> Search(String spec, String pseudo);

	}


