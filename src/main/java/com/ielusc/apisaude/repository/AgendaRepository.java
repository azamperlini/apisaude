package com.ielusc.apisaude.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ielusc.apisaude.models.AgendaModel;

public interface AgendaRepository extends JpaRepository<AgendaModel, Long> {
	
	Optional<AgendaModel> findById(long id);
	
}
