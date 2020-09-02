package com.ielusc.apisaude.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ielusc.apisaude.models.ContactModel;

@Repository
public interface ContactRepository extends JpaRepository<ContactModel, Long> {
	
	Optional<ContactModel> findById(long id);

}

