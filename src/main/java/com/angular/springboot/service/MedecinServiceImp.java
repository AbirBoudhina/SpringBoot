package com.angular.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.angular.springboot.model.Medecin;
import com.angular.springboot.repository.MedecinRepository;
@Service
@Transactional
public class MedecinServiceImp implements MedecinService{

	@Autowired
	MedecinRepository medecinrepo;

	@Override
	public List<Medecin> getAllMedecins() {
		// TODO Auto-generated method stub
		return medecinrepo.findAll();
	}

	@Override
	public List<Medecin> findBySpecialite(String spec) {
		// TODO Auto-generated method stub
		return medecinrepo.findBySpecialite(spec);
	}

	@Override
	public Medecin getMedecinById(long id) {
		// TODO Auto-generated method stub
		return medecinrepo.findById(id).get();
	}

	@Override
	public void saveOrUpdate(Medecin med) {
		// TODO Auto-generated method stub
		medecinrepo.save(med);
	}

	@Override
	public void deleteMedecin(long id) {
		// TODO Auto-generated method stub
		medecinrepo.deleteById(id);
		}

	@Override
	public List<Medecin> Search(String spec, String pseudo) {
		// TODO Auto-generated method stub
	 return medecinrepo.Search(spec, pseudo);

	}
	
	
}
