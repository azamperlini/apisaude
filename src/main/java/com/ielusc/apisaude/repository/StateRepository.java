package com.ielusc.apisaude.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ielusc.apisaude.models.StateModel;


public interface StateRepository extends JpaRepository<StateModel, Long> {
	
	Optional<StateModel> findById(long id);
	
}