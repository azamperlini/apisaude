package com.ielusc.apisaude.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ielusc.apisaude.models.OnDutyModel;

public interface OnDutyRepository extends JpaRepository<OnDutyModel, Long> {
	
	Optional<OnDutyModel> findById(long id);
	
}
