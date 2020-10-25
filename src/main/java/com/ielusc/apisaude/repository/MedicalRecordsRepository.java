package com.ielusc.apisaude.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ielusc.apisaude.models.MedicalRecordsModel;

@Repository
public interface MedicalRecordsRepository extends JpaRepository<MedicalRecordsModel, Long>{
	
	Optional<MedicalRecordsModel> findById(long id);

}
