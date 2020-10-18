package com.angular.springboot.service;

import java.util.List;

import com.angular.springboot.model.Client;

public interface ClientService {
	public List<Client> getAllClients();
	public Client getClientById (long id);
	public void saveorupdate(Client client);
	public void delete (long id);

}
