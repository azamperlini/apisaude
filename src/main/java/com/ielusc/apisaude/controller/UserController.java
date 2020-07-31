package com.ielusc.apisaude.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ielusc.apisaude.helpers.GeneralStatus;
import com.ielusc.apisaude.models.UserModel;
import com.ielusc.apisaude.repository.UserRepository;

@RestController
@RequestMapping(value="/api-saude/user")
public class UserController {
	
	@Autowired
	UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	
	@GetMapping
	public ResponseEntity<List<UserModel>> getAllUsers(){
		List<UserModel> usersList = userRepository.findAll();
		if(usersList.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<List<UserModel>>(usersList, HttpStatus.OK);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserModel> getOneUser(@PathVariable(value="id")long id) {
		Optional<UserModel> userOne = userRepository.findByIdUser(id);
		if(!userOne.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<UserModel>(userOne.get(), HttpStatus.OK);
		}
	}
	
	@PostMapping
	public ResponseEntity<UserModel> saveUser(@RequestBody @Valid UserModel user) {
		String password = user.getPassword();
		System.out.println("pasw "+ password);
		String hashed = bCryptPasswordEncoder.encode(password);
		user.setPassword(hashed);
		user.setStatus(GeneralStatus.ACTIVE);
		return new ResponseEntity<UserModel>(userRepository.save(user), HttpStatus.CREATED);
	}
		
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable(value="id") long id, @RequestBody @Valid UserModel user) {
		Optional<UserModel> userOne =  userRepository.findByIdUserAndStatus(id, GeneralStatus.ACTIVE);
		if(!userOne.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			user.setStatus(GeneralStatus.INACTIVE);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<UserModel> updateUser(@PathVariable(value="id") long id, @RequestBody @Valid UserModel user) {
		Optional<UserModel> userOne = userRepository.findByIdUser(id);
		if(!userOne.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			user.setIdUser(userOne.get().getIdUser());
			return new ResponseEntity<UserModel>(userRepository.save(user), HttpStatus.OK);
		}
	}

}
