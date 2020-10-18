package com.angular.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.angular.springboot.model.Client;

public interface ClientRepository extends JpaRepository<Client,Long>{

}
