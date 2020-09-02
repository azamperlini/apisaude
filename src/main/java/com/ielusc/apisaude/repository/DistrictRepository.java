package com.ielusc.apisaude.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ielusc.apisaude.models.DistrictModel;

@Repository
public interface DistrictRepository extends JpaRepository<DistrictModel, Long>{
	
	Optional<DistrictModel> findById(long id);

}
