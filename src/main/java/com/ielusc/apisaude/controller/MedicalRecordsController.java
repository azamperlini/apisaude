package com.ielusc.apisaude.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ielusc.apisaude.models.MedicalRecordsModel;
import com.ielusc.apisaude.repository.MedicalRecordsRepository;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/medicalrecords")
@CrossOrigin(origins="*")
@Qualifier
public class MedicalRecordsController {

	@Autowired
	MedicalRecordsRepository medicalRecordsRepository;
	
	@GetMapping(produces="application/json")
	@ApiOperation(value="Retorna a lista de Prontuários")
	public ResponseEntity<List<MedicalRecordsModel>> getAllMedicalRecords(){
		List<MedicalRecordsModel> medicalRecordsList = medicalRecordsRepository.findAll();
		if(medicalRecordsList.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<List<MedicalRecordsModel>>(medicalRecordsList, HttpStatus.OK);
		}
	}
	
	@GetMapping(value="/{id}", produces="application/json")
	@ApiOperation(value="Retorna um Prontuário")
	public ResponseEntity<MedicalRecordsModel> getOneMedicalRecords(@PathVariable(value="id")long id) {
		Optional<MedicalRecordsModel> medicalRecordsOne = medicalRecordsRepository.findById(id);
		if(!medicalRecordsOne.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<MedicalRecordsModel>(medicalRecordsOne.get(), HttpStatus.OK);
		}
	}
	
	@PostMapping(produces="application/json")
	@ApiOperation(value="Registra um Prontuário")
	public ResponseEntity<MedicalRecordsModel> saveMedicalRecords(@RequestBody @Valid MedicalRecordsModel medicalRecords) {
		
		return new ResponseEntity<MedicalRecordsModel>(medicalRecordsRepository.save(medicalRecords), HttpStatus.CREATED);
	}
		
	//@DeleteMapping(value="/{id}", produces="application/json")
	//public ResponseEntity<?> deleteMedicalRecords(@PathVariable(value="id") long id, @RequestBody @Valid MedicalRecordsModel medicalRecords) {
		
	//}
	
	@PutMapping(value="/{id}", produces="application/json")
	@ApiOperation(value="Atualiza o registro de um Prontuário")
	public ResponseEntity<MedicalRecordsModel> updateMedicalRecords(@PathVariable(value="id") long id, @RequestBody @Valid MedicalRecordsModel medicalRecords) {
		Optional<MedicalRecordsModel> medicalRecordsOne = medicalRecordsRepository.findById(id);
		if(!medicalRecordsOne.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			medicalRecords.setId(medicalRecordsOne.get().getId());
			return new ResponseEntity<MedicalRecordsModel>(medicalRecordsRepository.save(medicalRecords), HttpStatus.OK);
		}
	}
	
}