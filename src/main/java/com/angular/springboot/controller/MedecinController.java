package com.angular.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.angular.springboot.exception.ResourceNotFoundException;
import com.angular.springboot.model.Client;
import com.angular.springboot.model.Medecin;
import com.angular.springboot.repository.MedecinRepository;

@CrossOrigin(origins = "http://localhost:4200")   
@RestController
@RequestMapping("/api/v1")
public class MedecinController {
	
	@Autowired
	MedecinRepository agent;
	
	@GetMapping("/medecins")
	public List<Medecin> getAllMedecins() {
		List<Medecin> listmed = agent.findAll(Sort.by("specialite").ascending());
		return (listmed); 
	}
	
	@GetMapping("/medecins/recherche/{spec}")
	public List<Medecin> recherche(@PathVariable(value = "spec") String spec)
			throws ResourceNotFoundException {
		List<Medecin> meds = (List<Medecin>)  agent.findBySpecialite(spec);
		return (meds);
	}
	
	@GetMapping("/medecins/advanced/{spec}&{nom}")
	public List<Medecin> recherche_avance(@PathVariable(value = "spec") String spec
			,@PathVariable(value = "nom") String nom)
			throws ResourceNotFoundException {
		List<Medecin> meds = (List<Medecin>)  agent.Search(spec, "%"+nom+"%");
		return (meds);
	}

	@GetMapping("/medecins/{id}")
	public ResponseEntity<Medecin> getMedecinById(@PathVariable(value = "id") Long medId)
			throws ResourceNotFoundException {
		Medecin med = agent.findById(medId)
				.orElseThrow(() -> new ResourceNotFoundException("Medecin not found for this id :: " + medId));
		return ResponseEntity.ok().body(med);
	}

	@PostMapping("/medecins")
	public Medecin createMedecin(@Valid @RequestBody Medecin med) {
		return agent.save(med);
	}

	@PutMapping("/medecins/{id}")
	public ResponseEntity<Medecin> updateMedecin(@PathVariable(value = "id") Long medId,
			@Valid @RequestBody Medecin medDetails) throws ResourceNotFoundException {
		Medecin med = agent.findById(medId)
				.orElseThrow(() -> new ResourceNotFoundException("Medecin not found for this id :: " + medId));

		med.setId(medDetails.getId());
		med.setNom(medDetails.getNom());
		med.setPrenom(medDetails.getPrenom());
		med.setSpecialite(medDetails.getSpecialite());
		final Medecin updatedmed = agent.save(med);
		return ResponseEntity.ok(updatedmed);
	}

	@DeleteMapping("/medecins/{id}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long medId)
			throws ResourceNotFoundException {
		Medecin med = agent.findById(medId)
				.orElseThrow(() -> new ResourceNotFoundException("Medecin not found for this id :: " + medId));

		agent.delete(med);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
