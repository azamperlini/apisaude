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

import com.ielusc.apisaude.models.FoodModel;
import com.ielusc.apisaude.repository.FoodRepository;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/food")
@CrossOrigin(origins="*")
public class FoodController {
	
	@Autowired
	FoodRepository foodRepository;
	
	@GetMapping(produces="application/json")
	@ApiOperation(value="Retorna a lista de alimentos")
	public ResponseEntity<List<FoodModel>> getAllFood(){
		List<FoodModel> foodList = foodRepository.findAll();
		if(foodList.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<List<FoodModel>>(foodList, HttpStatus.OK);
		}
	}
	
	@GetMapping(value="/{id}", produces="application/json")
	@ApiOperation(value="Retorna um alimento")
	public ResponseEntity<FoodModel> getOneFood(@PathVariable(value="id")long id) {
		Optional<FoodModel> foodOne = foodRepository.findById(id);
		if(!foodOne.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<FoodModel>(foodOne.get(), HttpStatus.OK);
		}
	}
	
	@PostMapping(produces="application/json")
	@ApiOperation(value="Registra um alimento")
	public ResponseEntity<FoodModel> saveFood(@RequestBody @Valid FoodModel food) {
		
		return new ResponseEntity<FoodModel>(foodRepository.save(food), HttpStatus.CREATED);
	}
		
	//@DeleteMapping(value="/{id}", produces="application/json")
	//public ResponseEntity<?> deleteFood(@PathVariable(value="id") long id, @RequestBody @Valid FoodModel food) {

	//}
	
	@PutMapping(value="/{id}", produces="application/json")
	@ApiOperation(value="Atualiza um alimento")
	public ResponseEntity<FoodModel> updateFood(@PathVariable(value="id") long id, @RequestBody @Valid FoodModel food) {
		Optional<FoodModel> foodOne = foodRepository.findById(id);
		if(!foodOne.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			food.setId(foodOne.get().getId());
			return new ResponseEntity<FoodModel>(foodRepository.save(food), HttpStatus.OK);
		}
	}

}

