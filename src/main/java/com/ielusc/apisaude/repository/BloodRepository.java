package com.ielusc.apisaude.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ielusc.apisaude.models.BloodModel;


@Repository
public interface BloodRepository  extends JpaRepository<BloodModel, Long> {
	
	Optional<BloodModel> findById(long id);
	
}