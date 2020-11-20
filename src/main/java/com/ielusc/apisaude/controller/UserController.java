package com.ielusc.apisaude.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ielusc.apisaude.helpers.GeneralStatus;
import com.ielusc.apisaude.helpers.Permission;
import com.ielusc.apisaude.models.MedicalRecordsModel;
import com.ielusc.apisaude.models.UserModel;
import com.ielusc.apisaude.repository.UserRepository;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/user")
@CrossOrigin(origins="*")
public class UserController {

	@Autowired
	UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@GetMapping(produces="application/json")
	@ApiOperation(value="Retorna a lista de usuários")
	public ResponseEntity<List<UserModel>> getAllUsers(){
		List<UserModel> usersList = userRepository.findAll();
		if(usersList.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<List<UserModel>>(usersList, HttpStatus.OK);
		}
	}
	
	@GetMapping(value="/{id}", produces="application/json")
	@ApiOperation(value="Retorna um usuário")
	public ResponseEntity<UserModel> getOneUser(@PathVariable(value="id")long id) {
		Optional<UserModel> userOne = userRepository.findById(id);
		if(!userOne.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<UserModel>(userOne.get(), HttpStatus.OK);
		}

		
	}
	
	@PostMapping(produces="application/json")
	@ApiOperation(value="Registra um usuário")
	public ResponseEntity<UserModel> saveUser(@RequestBody @Valid UserModel user) {
		String password = user.getPassword();
		System.out.println("pasw "+ password);
		String hashed = bCryptPasswordEncoder.encode(password);
		user.setPassword(hashed);
		user.setStatus(GeneralStatus.ACTIVE);
		user.setPermission(Permission.PÚBLICO);
		MedicalRecordsModel medicalRecordsModel = new MedicalRecordsModel();
		user.setMedicalRecordsModel(medicalRecordsModel);
		medicalRecordsModel.setUserModel(user);
		return new ResponseEntity<UserModel>(userRepository.save(user), HttpStatus.CREATED);
	}
	
	@DeleteMapping(value="/{id}", produces="application/json")
	@ApiOperation(value="Apaga um usuário")
	public ResponseEntity<?> deleteUser(@PathVariable(value="id") long id, @RequestBody @Valid UserModel user) {
		Optional<UserModel> userOne =  userRepository.findByIdAndStatus(id, GeneralStatus.ACTIVE);
		if(!userOne.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			user.setStatus(GeneralStatus.INACTIVE);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	
	@PutMapping(value="/{id}", produces="application/json")
	@ApiOperation(value="Atualiza um usuário")
	public ResponseEntity<UserModel> updateUser(@PathVariable(value="id") long id, @RequestBody @Valid UserModel user) {
		Optional<UserModel> userOne = userRepository.findById(id);
		if(!userOne.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			user.setId(userOne.get().getId());
			return new ResponseEntity<UserModel>(userRepository.save(user), HttpStatus.OK);
		}
	}
	
	@PutMapping(value="/{id}/permission", produces="application/json")
	@ApiOperation(value="Modifica a permissão de um usuário")
	public ResponseEntity<UserModel> updateUserPermission(@PathVariable(value="id") long id, @RequestBody @Valid Permission permission) {
		Optional<UserModel> userOne = userRepository.findById(id);
		if(!userOne.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			userOne.get().setPermission(permission);
			return new ResponseEntity<UserModel>(userRepository.save(userOne.get()), HttpStatus.OK);
		}
	}
	
	@GetMapping(value = "/username", produces="application/json")
	@ResponseBody
	@ApiOperation(value="Retorna um usuário logado")
	public ResponseEntity<UserModel> currentUserName(Authentication authentication) {
		Optional<UserModel> user = userRepository.findByUserNameAndStatus(authentication.getName(), GeneralStatus.ACTIVE);
			if(!user.isPresent()) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}else {
				return new ResponseEntity<UserModel>(user.get(), HttpStatus.OK);
			}
	}

}
