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

import com.ielusc.apisaude.models.OccurrencesModel;
import com.ielusc.apisaude.repository.OccurrencesRepository;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/occurrences")
@CrossOrigin(origins="*")
public class OccurrencesController {
	
	@Autowired
	OccurrencesRepository occurrencesRepository;
	
	@GetMapping(produces="application/json")
	@ApiOperation(value="Retorna a lista de ocorrencias")
	public ResponseEntity<List<OccurrencesModel>> getAllOccurrences(){
		List<OccurrencesModel> occurrencesList = occurrencesRepository.findAll();
		if(occurrencesList.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<List<OccurrencesModel>>(occurrencesList, HttpStatus.OK);
		}
	}
	
	@GetMapping(value="/{id}", produces="application/json")
	@ApiOperation(value="Retorna uma ocorrência")
	public ResponseEntity<OccurrencesModel> getOneOccurrences(@PathVariable(value="id")long id) {
		Optional<OccurrencesModel> occurrencesOne = occurrencesRepository.findById(id);
		if(!occurrencesOne.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<OccurrencesModel>(occurrencesOne.get(), HttpStatus.OK);
		}
	}
	
	@PostMapping(produces="application/json")
	@ApiOperation(value="Registra uma ocorrência")
	public ResponseEntity<OccurrencesModel> saveOccurrences(@RequestBody @Valid OccurrencesModel occurrences) {
		
		return new ResponseEntity<OccurrencesModel>(occurrencesRepository.save(occurrences), HttpStatus.CREATED);
	}
		
	//@DeleteMapping(value="/{id}", produces="application/json")
	//public ResponseEntity<?> deleteOccurrences(@PathVariable(value="id") long id, @RequestBody @Valid OccurrencesModel occurrences) {

	//}
	
	@PutMapping(value="/{id}", produces="application/json")
	@ApiOperation(value="Atualiza uma ocorrência")
	public ResponseEntity<OccurrencesModel> updateOccurrences(@PathVariable(value="id") long id, @RequestBody @Valid OccurrencesModel occurrences) {
		Optional<OccurrencesModel> occurrencesOne = occurrencesRepository.findById(id);
		if(!occurrencesOne.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			occurrences.setId(occurrencesOne.get().getId());
			return new ResponseEntity<OccurrencesModel>(occurrencesRepository.save(occurrences), HttpStatus.OK);
		}
	}

}
