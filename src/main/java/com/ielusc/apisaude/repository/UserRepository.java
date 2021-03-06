package com.ielusc.apisaude.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ielusc.apisaude.helpers.GeneralStatus;
import com.ielusc.apisaude.models.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long>{
	
	Optional<UserModel> findById(long id);
	
	Optional<UserModel> findByIdAndStatus(long id, GeneralStatus status);

	Optional <UserModel> findByUserNameAndStatus(String username, GeneralStatus status);
	
	
}
