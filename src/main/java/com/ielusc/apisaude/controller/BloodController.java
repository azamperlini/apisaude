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

import com.ielusc.apisaude.models.BloodModel;
import com.ielusc.apisaude.repository.BloodRepository;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api-saude/blood")
@CrossOrigin(origins="*")
public class BloodController {
	
	@Autowired
	BloodRepository bloodRepository;
	
	@GetMapping
	@ApiOperation(value="Retorna a lista de registros de informações sanguineas")
	public ResponseEntity<List<BloodModel>> getAllBlood(){
		List<BloodModel> bloodList = bloodRepository.findAll();
		if(bloodList.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<List<BloodModel>>(bloodList, HttpStatus.OK);
		}
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value="Retorna um registro de informações sanguineas")
	public ResponseEntity<BloodModel> getOneBlood(@PathVariable(value="id")long id) {
		Optional<BloodModel> bloodOne = bloodRepository.findById(id);
		if(!bloodOne.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<BloodModel>(bloodOne.get(), HttpStatus.OK);
		}
	}
	
	@PostMapping
	@ApiOperation(value="Registra informações sanguineas")
	public ResponseEntity<BloodModel> saveBlood(@RequestBody @Valid BloodModel blood) {
		
		return new ResponseEntity<BloodModel>(bloodRepository.save(blood), HttpStatus.CREATED);
	}
		
	//@DeleteMapping("/{id}")
	//public ResponseEntity<?> deleteBlood(@PathVariable(value="id") long id, @RequestBody @Valid BloodModel blood) {

	//}
	
	@PutMapping("/{id}")
	@ApiOperation(value="Atualiza um registro de informações sanguineas")
	public ResponseEntity<BloodModel> updateBlood(@PathVariable(value="id") long id, @RequestBody @Valid BloodModel blood) {
		Optional<BloodModel> bloodOne = bloodRepository.findById(id);
		if(!bloodOne.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			blood.setId(bloodOne.get().getId());
			return new ResponseEntity<BloodModel>(bloodRepository.save(blood), HttpStatus.OK);
		}
	}

}

