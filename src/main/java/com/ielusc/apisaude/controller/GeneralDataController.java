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

import com.ielusc.apisaude.models.GeneralDataModel;
import com.ielusc.apisaude.repository.GeneralDataRepository;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/generaldata")
@CrossOrigin(origins="*")
@Qualifier
public class GeneralDataController {

	@Autowired
	GeneralDataRepository generalDataRepository;
	
	@GetMapping(produces="application/json")
	@ApiOperation(value="Retorna a lista de Dados Gerais de usuários")
	public ResponseEntity<List<GeneralDataModel>> getAllGeneralData(){
		List<GeneralDataModel> generalDataList = generalDataRepository.findAll();
		if(generalDataList.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<List<GeneralDataModel>>(generalDataList, HttpStatus.OK);
		}
	}
	
	@GetMapping(value="/{id}", produces="application/json")
	@ApiOperation(value="Retorna um registro de Dados Gerais de um usuário")
	public ResponseEntity<GeneralDataModel> getOneGeneralData(@PathVariable(value="id")long id) {
		Optional<GeneralDataModel> generalDataOne = generalDataRepository.findById(id);
		if(!generalDataOne.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<GeneralDataModel>(generalDataOne.get(), HttpStatus.OK);
		}
	}
	
	@PostMapping(produces="application/json")
	@ApiOperation(value="Registra Dados Gerais de um usuário")
	public ResponseEntity<GeneralDataModel> saveGeneralData(@RequestBody @Valid GeneralDataModel generalData) {
		
		return new ResponseEntity<GeneralDataModel>(generalDataRepository.save(generalData), HttpStatus.CREATED);
	}
		
	//@DeleteMapping("/{id}")
	//public ResponseEntity<?> deleteUser(@PathVariable(value="id") long id, @RequestBody @Valid UserModel user) {
		
	//}
	
	@PutMapping(value="/{id}", produces="application/json")
	@ApiOperation(value="Atualiza o registro de Dados Gerais de um usuário")
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
