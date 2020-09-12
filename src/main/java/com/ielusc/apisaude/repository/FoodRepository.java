package com.ielusc.apisaude.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ielusc.apisaude.models.FoodModel;


public interface FoodRepository extends JpaRepository<FoodModel, Long> {
	
	Optional<FoodModel> findById(long id);
	
}