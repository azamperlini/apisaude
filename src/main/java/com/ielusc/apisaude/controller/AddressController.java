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

import com.ielusc.apisaude.models.AddressModel;
import com.ielusc.apisaude.repository.AddressRepository;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api-saude/address")
@CrossOrigin(origins="*")
public class AddressController {
	
	@Autowired
	AddressRepository addressRepository;
	
	@GetMapping
	@ApiOperation(value="Retorna a lista de endereços")
	public ResponseEntity<List<AddressModel>> getAllAddress(){
		List<AddressModel> addressList = addressRepository.findAll();
		if(addressList.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<List<AddressModel>>(addressList, HttpStatus.OK);
		}
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value="Retorna um endereço")
	public ResponseEntity<AddressModel> getOneAddress(@PathVariable(value="id")long id) {
		Optional<AddressModel> addressOne = addressRepository.findById(id);
		if(!addressOne.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<AddressModel>(addressOne.get(), HttpStatus.OK);
		}
	}
	
	@PostMapping
	@ApiOperation(value="Registra um endereço")
	public ResponseEntity<AddressModel> saveAddress(@RequestBody @Valid AddressModel address) {
		
		return new ResponseEntity<AddressModel>(addressRepository.save(address), HttpStatus.CREATED);
	}
		
	//@DeleteMapping("/{id}")
	//public ResponseEntity<?> deleteAddress(@PathVariable(value="id") long id, @RequestBody @Valid AddressModel address) {

	//}
	
	@PutMapping("/{id}")
	@ApiOperation(value="Atualiza um endereço")
	public ResponseEntity<AddressModel> updateAddress(@PathVariable(value="id") long id, @RequestBody @Valid AddressModel address) {
		Optional<AddressModel> addressOne = addressRepository.findById(id);
		if(!addressOne.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			address.setId(addressOne.get().getId());
			return new ResponseEntity<AddressModel>(addressRepository.save(address), HttpStatus.OK);
		}
	}

}

