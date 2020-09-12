package com.ielusc.apisaude.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ielusc.apisaude.models.AllergyModel;
import com.ielusc.apisaude.repository.AllergyRepository;


@RestController
@RequestMapping(value="/api-saude/allergy")
public class AllergyController {
	
	@Autowired
	AllergyRepository allergyRepository;
	
	@GetMapping
	public ResponseEntity<List<AllergyModel>> getAllAllergy(){
		List<AllergyModel> allergyList = allergyRepository.findAll();
		if(allergyList.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<List<AllergyModel>>(allergyList, HttpStatus.OK);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AllergyModel> getOneAllergy(@PathVariable(value="id")long id) {
		Optional<AllergyModel> allergyOne = allergyRepository.findById(id);
		if(!allergyOne.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<AllergyModel>(allergyOne.get(), HttpStatus.OK);
		}
	}
	
	@PostMapping
	public ResponseEntity<AllergyModel> saveAllergy(@RequestBody @Valid AllergyModel allergy) {
		
		return new ResponseEntity<AllergyModel>(allergyRepository.save(allergy), HttpStatus.CREATED);
	}
		
	//@DeleteMapping("/{id}")
	//public ResponseEntity<?> deleteAllergy(@PathVariable(value="id") long id, @RequestBody @Valid AllergyModel allergy) {

	//}
	
	@PutMapping("/{id}")
	public ResponseEntity<AllergyModel> updateAllergy(@PathVariable(value="id") long id, @RequestBody @Valid AllergyModel allergy) {
		Optional<AllergyModel> allergyOne = allergyRepository.findById(id);
		if(!allergyOne.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			allergy.setId(allergyOne.get().getId());
			return new ResponseEntity<AllergyModel>(allergyRepository.save(allergy), HttpStatus.OK);
		}
	}

}

