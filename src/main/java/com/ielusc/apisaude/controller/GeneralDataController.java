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

import com.ielusc.apisaude.models.GeneralDataModel;
import com.ielusc.apisaude.repository.GeneralDataRepository;


@RestController
@RequestMapping(value="/api-saude/generaldata")
public class GeneralDataController {

	@Autowired
	GeneralDataRepository generalDataRepository;
	
	@GetMapping
	public ResponseEntity<List<GeneralDataModel>> getAllGeneralDatas(){
		List<GeneralDataModel> generalDatasList = generalDataRepository.findAll();
		if(generalDatasList.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<List<GeneralDataModel>>(generalDatasList, HttpStatus.OK);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<GeneralDataModel> getOneGeneralData(@PathVariable(value="id")long id) {
		Optional<GeneralDataModel> generalDataOne = generalDataRepository.findById(id);
		if(!generalDataOne.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<GeneralDataModel>(generalDataOne.get(), HttpStatus.OK);
		}
	}
	
	@PostMapping
	public ResponseEntity<GeneralDataModel> saveGeneralData(@RequestBody @Valid GeneralDataModel generalData) {
		
		return new ResponseEntity<GeneralDataModel>(generalDataRepository.save(generalData), HttpStatus.CREATED);
	}
		
	//@DeleteMapping("/{id}")
	//public ResponseEntity<?> deleteUser(@PathVariable(value="id") long id, @RequestBody @Valid UserModel user) {
		
	//}
	
	@PutMapping("/{id}")
	public ResponseEntity<GeneralDataModel> updateGeneralData(@PathVariable(value="id") long id, @RequestBody @Valid GeneralDataModel generalData) {
		Optional<GeneralDataModel> generalDataOne = generalDataRepository.findById(id);
		if(!generalDataOne.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			generalData.setId(generalDataOne.get().getId());
			return new ResponseEntity<GeneralDataModel>(generalDataRepository.save(generalData), HttpStatus.OK);
		}
	}
	
}
