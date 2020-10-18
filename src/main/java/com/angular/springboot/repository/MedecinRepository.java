package com.angular.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.angular.springboot.model.Medecin;

public interface MedecinRepository extends JpaRepository<Medecin, Long> {

	public List<Medecin> findBySpecialite(String specialite);
	
	@Query(value="Select m from Medecin m where m.specialite = :spec "
			+ "and ( m.nom Like :given or m.prenom Like :given)")
	public List<Medecin> Search(@Param("spec") String spec,
			@Param("given") String pseudo);

}
