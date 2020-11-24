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

import com.ielusc.apisaude.models.OnDutyModel;
import com.ielusc.apisaude.repository.OnDutyRepository;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/onduty")
@CrossOrigin(origins="*")
public class OnDutyController {
	
	@Autowired
	OnDutyRepository onDutyRepository;
	
	@GetMapping(produces="application/json")
	@ApiOperation(value="Retorna a lista de plantões")
	public ResponseEntity<List<OnDutyModel>> getAllOnDuty(){
		List<OnDutyModel> onDutyList = onDutyRepository.findAll();
		if(onDutyList.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<List<OnDutyModel>>(onDutyList, HttpStatus.OK);
		}
	}
	
	@GetMapping(value="/{id}", produces="application/json")
	@ApiOperation(value="Retorna um plantão")
	public ResponseEntity<OnDutyModel> getOneOnDuty(@PathVariable(value="id")long id) {
		Optional<OnDutyModel> onDutyOne = onDutyRepository.findById(id);
		if(!onDutyOne.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<OnDutyModel>(onDutyOne.get(), HttpStatus.OK);
		}
	}
	
	@PostMapping(produces="application/json")
	@ApiOperation(value="Registra um plantão")
	public ResponseEntity<OnDutyModel> saveOnDuty(@RequestBody @Valid OnDutyModel onDuty) {
		
		return new ResponseEntity<OnDutyModel>(onDutyRepository.save(onDuty), HttpStatus.CREATED);
	}
		
	//@DeleteMapping(value="/{id}", produces="application/json")
	//public ResponseEntity<?> deleteOnDuty(@PathVariable(value="id") long id, @RequestBody @Valid OnDutyModel onDuty) {

	//}
	
	@PutMapping(value="/{id}", produces="application/json")
	@ApiOperation(value="Atualiza um plantão")
	public ResponseEntity<OnDutyModel> updateOnDuty(@PathVariable(value="id") long id, @RequestBody @Valid OnDutyModel onDuty) {
		Optional<OnDutyModel> onDutyOne = onDutyRepository.findById(id);
		if(!onDutyOne.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			onDuty.setId(onDutyOne.get().getId());
			return new ResponseEntity<OnDutyModel>(onDutyRepository.save(onDuty), HttpStatus.OK);
		}
	}

}