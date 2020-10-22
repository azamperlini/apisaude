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

import com.ielusc.apisaude.models.MedicineModel;
import com.ielusc.apisaude.repository.MedicineRepository;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api-saude/medicine")
@CrossOrigin(origins="*")
public class MedicineController {
	
	@Autowired
	MedicineRepository medicineRepository;
	
	@GetMapping
	@ApiOperation(value="Retorna a lista de medicamentos")
	public ResponseEntity<List<MedicineModel>> getAllMedicine(){
		List<MedicineModel> medicineList = medicineRepository.findAll();
		if(medicineList.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<List<MedicineModel>>(medicineList, HttpStatus.OK);
		}
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value="Retorna um medicamento")
	public ResponseEntity<MedicineModel> getOneMedicine(@PathVariable(value="id")long id) {
		Optional<MedicineModel> medicineOne = medicineRepository.findById(id);
		if(!medicineOne.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<MedicineModel>(medicineOne.get(), HttpStatus.OK);
		}
	}
	
	@PostMapping
	@ApiOperation(value="Registra um medicamento")
	public ResponseEntity<MedicineModel> saveMedicine(@RequestBody @Valid MedicineModel medicine) {
		
		return new ResponseEntity<MedicineModel>(medicineRepository.save(medicine), HttpStatus.CREATED);
	}
		
	//@DeleteMapping("/{id}")
	//public ResponseEntity<?> deleteMedicine(@PathVariable(value="id") long id, @RequestBody @Valid MedicineModel medicine) {

	//}
	
	@PutMapping("/{id}")
	@ApiOperation(value="Atualiza um medicamento")
	public ResponseEntity<MedicineModel> updateMedicine(@PathVariable(value="id") long id, @RequestBody @Valid MedicineModel medicine) {
		Optional<MedicineModel> medicineOne = medicineRepository.findById(id);
		if(!medicineOne.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			medicine.setId(medicineOne.get().getId());
			return new ResponseEntity<MedicineModel>(medicineRepository.save(medicine), HttpStatus.OK);
		}
	}

}

