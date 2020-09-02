package com.ielusc.apisaude.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ielusc.apisaude.models.GeneralDataModel;


@Repository
public interface GeneralDataRepository extends JpaRepository<GeneralDataModel, Long>{
	
	Optional<GeneralDataModel> findById(long id);

}
