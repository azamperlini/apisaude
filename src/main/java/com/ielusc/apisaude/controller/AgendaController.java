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

import com.ielusc.apisaude.models.AgendaModel;
import com.ielusc.apisaude.repository.AgendaRepository;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/schedules")
@CrossOrigin(origins="*")
public class AgendaController {
	
	@Autowired
	AgendaRepository agendaRepository;
	
	@GetMapping(produces="application/json")
	@ApiOperation(value="Retorna a lista de agendamentos")
	public ResponseEntity<List<AgendaModel>> getAllAgenda(){
		List<AgendaModel> agendaList = agendaRepository.findAll();
		if(agendaList.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<List<AgendaModel>>(agendaList, HttpStatus.OK);
		}
	}
	
	@GetMapping(value="/{id}", produces="application/json")
	@ApiOperation(value="Retorna um agendamento")
	public ResponseEntity<AgendaModel> getOneAgenda(@PathVariable(value="id")long id) {
		Optional<AgendaModel> agendaOne = agendaRepository.findById(id);
		if(!agendaOne.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<AgendaModel>(agendaOne.get(), HttpStatus.OK);
		}
	}
	
	@PostMapping(produces="application/json")
	@ApiOperation(value="Registra um agendamento")
	public ResponseEntity<AgendaModel> saveAgenda(@RequestBody @Valid AgendaModel agenda) {
		
		return new ResponseEntity<AgendaModel>(agendaRepository.save(agenda), HttpStatus.CREATED);
	}
		
	//@DeleteMapping(value="/{id}", produces="application/json")
	//public ResponseEntity<?> deleteAgenda(@PathVariable(value="id") long id, @RequestBody @Valid AgendaModel agenda) {

	//}
	
	@PutMapping(value="/{id}", produces="application/json")
	@ApiOperation(value="Atualiza um agendamento")
	public ResponseEntity<AgendaModel> updateAgenda(@PathVariable(value="id") long id, @RequestBody @Valid AgendaModel agenda) {
		Optional<AgendaModel> agendaOne = agendaRepository.findById(id);
		if(!agendaOne.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			agenda.setId(agendaOne.get().getId());
			return new ResponseEntity<AgendaModel>(agendaRepository.save(agenda), HttpStatus.OK);
		}
	}

}
