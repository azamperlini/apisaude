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

import com.ielusc.apisaude.models.StateModel;
import com.ielusc.apisaude.repository.StateRepository;


@RestController
@RequestMapping(value="/api-saude/state")
public class StateController {
	
	@Autowired
	StateRepository stateRepository;
	
	@GetMapping
	public ResponseEntity<List<StateModel>> getAllState(){
		List<StateModel> stateList = stateRepository.findAll();
		if(stateList.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<List<StateModel>>(stateList, HttpStatus.OK);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<StateModel> getOneState(@PathVariable(value="id")long id) {
		Optional<StateModel> stateOne = stateRepository.findById(id);
		if(!stateOne.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<StateModel>(stateOne.get(), HttpStatus.OK);
		}
	}
	
	@PostMapping
	public ResponseEntity<StateModel> saveState(@RequestBody @Valid StateModel state) {
		
		return new ResponseEntity<StateModel>(stateRepository.save(state), HttpStatus.CREATED);
	}
		
	//@DeleteMapping("/{id}")
	//public ResponseEntity<?> deleteState(@PathVariable(value="id") long id, @RequestBody @Valid StateModel state) {

	//}
	
	@PutMapping("/{id}")
	public ResponseEntity<StateModel> updateState(@PathVariable(value="id") long id, @RequestBody @Valid StateModel state) {
		Optional<StateModel> stateOne = stateRepository.findById(id);
		if(!stateOne.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			state.setId(stateOne.get().getId());
			return new ResponseEntity<StateModel>(stateRepository.save(state), HttpStatus.OK);
		}
	}

}

