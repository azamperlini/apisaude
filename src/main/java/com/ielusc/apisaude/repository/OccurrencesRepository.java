package com.ielusc.apisaude.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ielusc.apisaude.models.OccurrencesModel;

public interface OccurrencesRepository extends JpaRepository<OccurrencesModel, Long> {
	
	Optional<OccurrencesModel> findById(long id);
	
}