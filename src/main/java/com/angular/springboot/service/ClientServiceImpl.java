package com.angular.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.angular.springboot.model.Client;
import com.angular.springboot.repository.ClientRepository;

@Service
@Transactional
public class ClientServiceImpl implements ClientService{

	 @Autowired
	 ClientRepository clientrepo;
	 
	@Override
	public List<Client> getAllClients() {
		// TODO Auto-generated method stub
		return (List<Client>) clientrepo.findAll();
	}

	@Override
	public Client getClientById(long id) {
		// TODO Auto-generated method stub
		return clientrepo.findById(id).get();
	}

	@Override
	public void saveorupdate(Client client) {
		// TODO Auto-generated method stub
		clientrepo.save(client);
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		clientrepo.deleteById(id);;
	}

}
