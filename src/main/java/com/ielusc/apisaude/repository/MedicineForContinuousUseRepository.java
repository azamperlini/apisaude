package com.ielusc.apisaude.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ielusc.apisaude.models.MedicineForContinuousUseModel;


public interface MedicineForContinuousUseRepository extends JpaRepository<MedicineForContinuousUseModel, Long> {
	
	Optional<MedicineForContinuousUseModel> findById(long id);
	
}