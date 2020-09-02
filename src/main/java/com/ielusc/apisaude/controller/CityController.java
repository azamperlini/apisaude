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

import com.ielusc.apisaude.models.CityModel;
import com.ielusc.apisaude.repository.CityRepository;

@RestController
@RequestMapping(value="/api-saude/city")
public class CityController {
	
	@Autowired
	CityRepository cityRepository;
	
	@GetMapping
	public ResponseEntity<List<CityModel>> getAllCity(){
		List<CityModel> cityList = cityRepository.findAll();
		if(cityList.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<List<CityModel>>(cityList, HttpStatus.OK);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CityModel> getOneCity(@PathVariable(value="id")long id) {
		Optional<CityModel> cityOne = cityRepository.findById(id);
		if(!cityOne.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<CityModel>(cityOne.get(), HttpStatus.OK);
		}
	}
	
	@PostMapping
	public ResponseEntity<CityModel> saveCity(@RequestBody @Valid CityModel city) {
		
		return new ResponseEntity<CityModel>(cityRepository.save(city), HttpStatus.CREATED);
	}
		
	//@DeleteMapping("/{id}")
	//public ResponseEntity<?> deleteCity(@PathVariable(value="id") long id, @RequestBody @Valid CityModel city) {

	//}
	
	@PutMapping("/{id}")
	public ResponseEntity<CityModel> updateCity(@PathVariable(value="id") long id, @RequestBody @Valid CityModel city) {
		Optional<CityModel> cityOne = cityRepository.findById(id);
		if(!cityOne.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			city.setId(cityOne.get().getId());
			return new ResponseEntity<CityModel>(cityRepository.save(city), HttpStatus.OK);
		}
	}

}

