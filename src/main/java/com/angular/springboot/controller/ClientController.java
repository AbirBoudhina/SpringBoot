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
import com.angular.springboot.model.Client;

import com.angular.springboot.repository.ClientRepository;
import com.angular.springboot.service.ClientService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class ClientController {

	
	@Autowired
	private ClientRepository agent;

	@GetMapping("/clients")
	public List<Client> getAllEmployees() {
		return agent.findAll();
	}

	@GetMapping("/clients/{id}")
	public ResponseEntity<Client> getEmployeeById(@PathVariable(value = "id") Long clientId)
			throws ResourceNotFoundException {
		Client client = agent.findById(clientId)
				.orElseThrow(() -> new ResourceNotFoundException("Client not found for this id :: " + clientId));
		return ResponseEntity.ok().body(client);
	}

	@PostMapping("/clients")
	public Client createEmployee(@Valid @RequestBody Client client) {
		return agent.save(client);
	}

	@PutMapping("/clients/{id}")
	public ResponseEntity<Client> updateEmployee(@PathVariable(value = "id") Long clientId,
			@Valid @RequestBody Client clientDetails) throws ResourceNotFoundException {
		Client client = agent.findById(clientId)
				.orElseThrow(() -> new ResourceNotFoundException("Client not found for this id :: " + clientId));

		client.setId(clientDetails.getId());
		client.setNom(clientDetails.getNom());
		client.setPrenom(clientDetails.getPrenom());
		final Client updatedclient = agent.save(client);
		return ResponseEntity.ok(updatedclient);
	}

	@DeleteMapping("/clients/{id}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long clientId)
			throws ResourceNotFoundException {
		Client client = agent.findById(clientId)
				.orElseThrow(() -> new ResourceNotFoundException("Client not found for this id :: " + clientId));

		agent.delete(client);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
	
	
	
	

}
