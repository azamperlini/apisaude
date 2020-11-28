package com.ielusc.apisaude.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="TB_ALLERGY")
public class AllergyModel implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column
	private boolean foodAllergicCondition;
	
	@Column
	private boolean insectBites;
	
	@Column
	private boolean drugAllergyCondition;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_medicalRecords")
	private MedicalRecordsModel medicalRecordsModel;
	
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "Allergy_Medicine", 
        joinColumns = { @JoinColumn(name = "id_allergy") }, 
        inverseJoinColumns = { @JoinColumn(name = "id_medicine") }
    )
    Set<MedicineModel> medicineModel = new HashSet<>();
    
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "Allergy_Food", 
        joinColumns = { @JoinColumn(name = "id_allergy") }, 
        inverseJoinColumns = { @JoinColumn(name = "id_food") }
    )
    Set<FoodModel> foodModel = new HashSet<>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isFoodAllergicCondition() {
		return foodAllergicCondition;
	}

	public void setFoodAllergicCondition(boolean foodAllergicCondition) {
		this.foodAllergicCondition = foodAllergicCondition;
	}

	public boolean isInsectBites() {
		return insectBites;
	}

	public void setInsectBites(boolean insectBites) {
		this.insectBites = insectBites;
	}

	public boolean isDrugAllergyCondition() {
		return drugAllergyCondition;
	}

	public void setDrugAllergyCondition(boolean drugAllergyCondition) {
		this.drugAllergyCondition = drugAllergyCondition;
	}

	public MedicalRecordsModel getMedicalRecordsModel() {
		return medicalRecordsModel;
	}

	public void setMedicalRecordsModel(MedicalRecordsModel medicalRecordsModel) {
		this.medicalRecordsModel = medicalRecordsModel;
	}

	public Set<MedicineModel> getMedicineModel() {
		return medicineModel;
	}

	public void setMedicineModel(Set<MedicineModel> medicineModel) {
		this.medicineModel = medicineModel;
	}

	public Set<FoodModel> getFoodModel() {
		return foodModel;
	}

	public void setFoodModel(Set<FoodModel> foodModel) {
		this.foodModel = foodModel;
	}
    
	
}