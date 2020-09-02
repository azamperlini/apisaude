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

import com.ielusc.apisaude.models.DistrictModel;
import com.ielusc.apisaude.repository.DistrictRepository;

	@RestController
	@RequestMapping(value="/api-saude/district")
	public class DistrictController {
		
		@Autowired
		DistrictRepository districtRepository;
		
		@GetMapping
		public ResponseEntity<List<DistrictModel>> getAllDistricts(){
			List<DistrictModel> districtsList = districtRepository.findAll();
			if(districtsList.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}else {
				return new ResponseEntity<List<DistrictModel>>(districtsList, HttpStatus.OK);
			}
		}
		
		@GetMapping("/{id}")
		public ResponseEntity<DistrictModel> getOneDistrict(@PathVariable(value="id")long id) {
			Optional<DistrictModel> districtOne = districtRepository.findById(id);
			if(!districtOne.isPresent()) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}else {
				return new ResponseEntity<DistrictModel>(districtOne.get(), HttpStatus.OK);
			}
		}
		
		@PostMapping
		public ResponseEntity<DistrictModel> saveDistrict(@RequestBody @Valid DistrictModel district) {
			
			return new ResponseEntity<DistrictModel>(districtRepository.save(district), HttpStatus.CREATED);
		}
			
		//@DeleteMapping("/{id}")
		//public ResponseEntity<?> deleteDistrict(@PathVariable(value="id") long id, @RequestBody @Valid DistrictModel district) {

		//}
		
		@PutMapping("/{id}")
		public ResponseEntity<DistrictModel> updateDistrict(@PathVariable(value="id") long id, @RequestBody @Valid DistrictModel district) {
			Optional<DistrictModel> districtOne = districtRepository.findById(id);
			if(!districtOne.isPresent()) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}else {
				district.setId(districtOne.get().getId());
				return new ResponseEntity<DistrictModel>(districtRepository.save(district), HttpStatus.OK);
			}
		}

	}