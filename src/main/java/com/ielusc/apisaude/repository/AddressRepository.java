package com.ielusc.apisaude.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ielusc.apisaude.models.AddressModel;


@Repository
public interface AddressRepository extends JpaRepository<AddressModel, Long> {
	
	Optional<AddressModel> findById(long id);
	
}