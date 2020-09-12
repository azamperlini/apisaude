package com.ielusc.apisaude.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="TB_MEDICINE")
public class MedicineModel implements Serializable{
		
	private static final long serialVersionUID = 1L;
		
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
		
	@Column(length=60)
	private String ds_medicine;

	@ManyToMany(mappedBy = "medicineModel")
    private Set<MedicineForContinuousUseModel> medicineForContinuousUseModel = new HashSet<>();
	
	@ManyToMany(mappedBy = "medicineModel")
    private Set<AllergyModel> allergyModel = new HashSet<>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDs_medicine() {
		return ds_medicine;
	}

	public void setDs_medicine(String ds_medicine) {
		this.ds_medicine = ds_medicine;
	}

	public Set<MedicineForContinuousUseModel> getMedicineForContinuousUseModel() {
		return medicineForContinuousUseModel;
	}

	public void setMedicineForContinuousUseModel(Set<MedicineForContinuousUseModel> medicineForContinuousUseModel) {
		this.medicineForContinuousUseModel = medicineForContinuousUseModel;
	}

	public Set<AllergyModel> getAllergyModel() {
		return allergyModel;
	}

	public void setAllergyModel(Set<AllergyModel> allergyModel) {
		this.allergyModel = allergyModel;
	}
	
}
