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

import com.ielusc.apisaude.models.MedicineForContinuousUseModel;
import com.ielusc.apisaude.repository.MedicineForContinuousUseRepository;



@RestController
@RequestMapping(value="/api-saude/medicinecontinuous")
public class MedicineForContinuousUseController {
	
	@Autowired
	MedicineForContinuousUseRepository medicineForContinuousUseRepository;
	
	@GetMapping
	public ResponseEntity<List<MedicineForContinuousUseModel>> getAllMedicine(){
		List<MedicineForContinuousUseModel> medicineForContinuousUseList = medicineForContinuousUseRepository.findAll();
		if(medicineForContinuousUseList.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<List<MedicineForContinuousUseModel>>(medicineForContinuousUseList, HttpStatus.OK);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<MedicineForContinuousUseModel> getOneMedicineForContinuousUse(@PathVariable(value="id")long id) {
		Optional<MedicineForContinuousUseModel> medicineForContinuousUseOne = medicineForContinuousUseRepository.findById(id);
		if(!medicineForContinuousUseOne.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<MedicineForContinuousUseModel>(medicineForContinuousUseOne.get(), HttpStatus.OK);
		}
	}
	
	@PostMapping
	public ResponseEntity<MedicineForContinuousUseModel> saveMedicineForContinuousUse(@RequestBody @Valid MedicineForContinuousUseModel medicineForContinuousUse) {
		
		return new ResponseEntity<MedicineForContinuousUseModel>(medicineForContinuousUseRepository.save(medicineForContinuousUse), HttpStatus.CREATED);
	}
		
	//@DeleteMapping("/{id}")
	//public ResponseEntity<?> deleteMedicine(@PathVariable(value="id") long id, @RequestBody @Valid MedicineForContinuousUseModel medicineForContinuousUse) {

	//}
	
	@PutMapping("/{id}")
	public ResponseEntity<MedicineForContinuousUseModel> updateMedicineForContinuousUse(@PathVariable(value="id") long id, @RequestBody @Valid MedicineForContinuousUseModel medicineForContinuousUse) {
		Optional<MedicineForContinuousUseModel> medicineForContinuousUseOne = medicineForContinuousUseRepository.findById(id);
		if(!medicineForContinuousUseOne.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			medicineForContinuousUse.setId(medicineForContinuousUseOne.get().getId());
			return new ResponseEntity<MedicineForContinuousUseModel>(medicineForContinuousUseRepository.save(medicineForContinuousUse), HttpStatus.OK);
		}
	}

}

