package com.angular.springboot.service;

import java.util.List;

import com.angular.springboot.model.Rv;


public interface RvService {

	public List<Rv> getAllRvs();
	public Rv getRvById (long id);
	public void saveorupdate(Rv rvd);
	public void deleteRv (long id);
}
