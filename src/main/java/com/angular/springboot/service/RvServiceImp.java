package com.angular.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.angular.springboot.model.Rv;
import com.angular.springboot.repository.RvRepository;

@Service
@Transactional
public class RvServiceImp implements RvService{

	@Autowired
    RvRepository rvrepo;	

	@Override
	public List<Rv> getAllRvs() {
		// TODO Auto-generated method stub
		return rvrepo.findAll();
	}

	@Override
	public Rv getRvById(long id) {
		// TODO Auto-generated method stub
		return rvrepo.findById(id).get();
	}

	@Override
	public void saveorupdate(Rv rvd) {
		// TODO Auto-generated method stub
		rvrepo.save(rvd);
	}

	@Override
	public void deleteRv(long id) {
		// TODO Auto-generated method stub
		rvrepo.deleteById(id);
	}

}
