package com.ielusc.apisaude.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ielusc.apisaude.models.CityModel;


public interface CityRepository extends JpaRepository<CityModel, Long> {
	
	Optional<CityModel> findById(long id);
	
}