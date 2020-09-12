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
@Table(name="TB_MEDICINE_FOR_CONTINUOUS_USE")
public class MedicineForContinuousUseModel implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column
	private boolean medicineConditionOfContinuousUse;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "MedicineForContinuousUse_Medicine", 
        joinColumns = { @JoinColumn(name = "medicineForContinuousUse_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "medicine_id") }
    )
    Set<MedicineModel> medicineModel = new HashSet<>();
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="medicalRecords_id")
	private MedicalRecordsModel medicalRecordsModel;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isMedicineConditionOfContinuousUse() {
		return medicineConditionOfContinuousUse;
	}

	public void setMedicineConditionOfContinuousUse(boolean medicineConditionOfContinuousUse) {
		this.medicineConditionOfContinuousUse = medicineConditionOfContinuousUse;
	}

	public Set<MedicineModel> getMedicineModel() {
		return medicineModel;
	}

	public void setMedicineModel(Set<MedicineModel> medicineModel) {
		this.medicineModel = medicineModel;
	}

	public MedicalRecordsModel getMedicalRecordsModel() {
		return medicalRecordsModel;
	}

	public void setMedicalRecordsModel(MedicalRecordsModel medicalRecordsModel) {
		this.medicalRecordsModel = medicalRecordsModel;
	}
	
}