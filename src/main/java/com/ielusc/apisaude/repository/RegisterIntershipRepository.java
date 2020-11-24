package com.ielusc.apisaude.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ielusc.apisaude.models.RegisterIntershipModel;

public interface RegisterIntershipRepository extends JpaRepository<RegisterIntershipModel, Long> {
	
	Optional<RegisterIntershipModel> findById(long id);
	
}