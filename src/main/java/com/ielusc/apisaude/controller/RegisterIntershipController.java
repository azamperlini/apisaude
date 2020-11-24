package com.ielusc.apisaude.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.ielusc.apisaude.models.RegisterIntershipModel;
import com.ielusc.apisaude.repository.RegisterIntershipRepository;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/registerintership")
@CrossOrigin(origins="*")
public class RegisterIntershipController {
	
	@Autowired
	RegisterIntershipRepository registerIntershipRepository;
	
	@GetMapping(produces="application/json")
	@ApiOperation(value="Retorna a lista de estagiarios")
	public ResponseEntity<List<RegisterIntershipModel>> getAllRegisterIntership(){
		List<RegisterIntershipModel> registerIntershipList = registerIntershipRepository.findAll();
		if(registerIntershipList.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<List<RegisterIntershipModel>>(registerIntershipList, HttpStatus.OK);
		}
	}
	
	@GetMapping(value="/{id}", produces="application/json")
	@ApiOperation(value="Retorna um estagiario")
	public ResponseEntity<RegisterIntershipModel> getOneRegisterIntership(@PathVariable(value="id")long id) {
		Optional<RegisterIntershipModel> registerIntershipOne = registerIntershipRepository.findById(id);
		if(!registerIntershipOne.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<RegisterIntershipModel>(registerIntershipOne.get(), HttpStatus.OK);
		}
	}
	
	@PostMapping(produces="application/json")
	@ApiOperation(value="Registra um estagiario")
	public ResponseEntity<RegisterIntershipModel> saveRegisterIntership(@RequestBody @Valid RegisterIntershipModel registerIntership) {
		
		return new ResponseEntity<RegisterIntershipModel>(registerIntershipRepository.save(registerIntership), HttpStatus.CREATED);
	}
		
	//@DeleteMapping(value="/{id}", produces="application/json")
	//public ResponseEntity<?> deleteRegisterIntership(@PathVariable(value="id") long id, @RequestBody @Valid RegisterIntership registerIntership) {

	//}
	
	@PutMapping(value="/{id}", produces="application/json")
	@ApiOperation(value="Atualiza um estagiario")
	public ResponseEntity<RegisterIntershipModel> updateRegisterIntership(@PathVariable(value="id") long id, @RequestBody @Valid RegisterIntershipModel registerIntership) {
		Optional<RegisterIntershipModel> registerIntershipOne = registerIntershipRepository.findById(id);
		if(!registerIntershipOne.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			registerIntership.setId(registerIntershipOne.get().getId());
			return new ResponseEntity<RegisterIntershipModel>(registerIntershipRepository.save(registerIntership), HttpStatus.OK);
		}
	}

}
