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

import com.ielusc.apisaude.models.ContactModel;
import com.ielusc.apisaude.repository.ContactRepository;

@RestController
@RequestMapping(value="/api-saude/contacts")
public class ContactController {
	
	@Autowired
	ContactRepository contactRepository;
	
	@GetMapping
	public ResponseEntity<List<ContactModel>> getAllContacts(){
		List<ContactModel> contactsList = contactRepository.findAll();
		if(contactsList.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<List<ContactModel>>(contactsList, HttpStatus.OK);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ContactModel> getOneContact(@PathVariable(value="id")long id) {
		Optional<ContactModel> contactOne = contactRepository.findById(id);
		if(!contactOne.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<ContactModel>(contactOne.get(), HttpStatus.OK);
		}
	}
	
	@PostMapping
	public ResponseEntity<ContactModel> saveContact(@RequestBody @Valid ContactModel contact) {
		
		return new ResponseEntity<ContactModel>(contactRepository.save(contact), HttpStatus.CREATED);
	}
		
	//@DeleteMapping("/{id}")
	//public ResponseEntity<?> deleteContact(@PathVariable(value="id") long id, @RequestBody @Valid ContactModel contact) {

	//}
	
	@PutMapping("/{id}")
	public ResponseEntity<ContactModel> updateContact(@PathVariable(value="id") long id, @RequestBody @Valid ContactModel contact) {
		Optional<ContactModel> contactOne = contactRepository.findById(id);
		if(!contactOne.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			contact.setId(contactOne.get().getId());
			return new ResponseEntity<ContactModel>(contactRepository.save(contact), HttpStatus.OK);
		}
	}

}

