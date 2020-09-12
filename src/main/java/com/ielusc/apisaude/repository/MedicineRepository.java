package com.ielusc.apisaude.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ielusc.apisaude.models.MedicineModel;


public interface MedicineRepository extends JpaRepository<MedicineModel, Long> {
	
	Optional<MedicineModel> findById(long id);
	
}