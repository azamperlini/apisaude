package com.ielusc.apisaude.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ielusc.apisaude.models.AllergyModel;


public interface AllergyRepository extends JpaRepository<AllergyModel, Long> {
	
	Optional<AllergyModel> findById(long id);
	
}