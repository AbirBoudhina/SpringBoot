package com.angular.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.angular.springboot.model.Medecin;
import com.angular.springboot.model.Rv;
import com.angular.springboot.repository.RvRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class RvController {
	
	@Autowired
	RvRepository agent;
	
	@GetMapping("/rdvs")
	public List<Rv> getAllRdvs() {
		return agent.findAll();
	}

	@GetMapping("/rdvs/{id}")
	public ResponseEntity<Rv> getRdvById(@PathVariable(value = "id") Long rdvId)
			throws ResourceNotFoundException {
		Rv rdv = agent.findById(rdvId)
				.orElseThrow(() -> new ResourceNotFoundException("Rendez-vous not found for this id :: " + rdvId));
		return ResponseEntity.ok().body(rdv);
	}

	@PostMapping("/rdvs")
	public Rv createMedecin(@Valid @RequestBody Rv rdv) {
		rdv.toString();
		return agent.save(rdv);
	}

	@PutMapping("/rdvs/{id}")
	public ResponseEntity<Rv> updateRdv(@PathVariable(value = "id") Long rdvId,
			@Valid @RequestBody Rv rdvDetails) throws ResourceNotFoundException {
		Rv rdv = agent.findById(rdvId)
				.orElseThrow(() -> new ResourceNotFoundException("Rendez-vous not found for this id :: " + rdvId));

		rdv.setId(rdvDetails.getId());
		rdv.setJour(rdvDetails.getJour());
		rdv.setClient(rdvDetails.getClient());
		rdv.setMedecin(rdvDetails.getMedecin());
		final Rv updatedrdv = agent.save(rdv);
		return ResponseEntity.ok(updatedrdv);
	}

	@DeleteMapping("/rdvs/{id}")
	public Map<String, Boolean> deleteRdv(@PathVariable(value = "id") Long rdvId)
			throws ResourceNotFoundException {
		Rv rdv = agent.findById(rdvId)
				.orElseThrow(() -> new ResourceNotFoundException("Rendez-vous not found for this id :: " + rdvId));

		agent.delete(rdv);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
