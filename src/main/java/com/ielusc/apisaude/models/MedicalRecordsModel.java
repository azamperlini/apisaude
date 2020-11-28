package com.ielusc.apisaude.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="TB_MEDICALRECORDS")
@TableGenerator(name="tab", initialValue=2019, allocationSize=1)
public class MedicalRecordsModel implements Serializable{
		
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="tab")
	private long id;
	
	//@GeneratedValue(strategy=GenerationType.AUTO)
	//private long nr_medicalRecord;
	
	@JsonIgnore
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_user")
	private UserModel userModel;
	
	@OneToOne(fetch=FetchType.LAZY, mappedBy="medicalRecordsModel")
	private BloodModel bloodModel;
	
	@OneToOne(fetch=FetchType.LAZY, mappedBy="medicalRecordsModel")
	private AllergyModel allergyModel;
	
	@OneToOne(fetch=FetchType.LAZY, mappedBy="medicalRecordsModel")
	private MedicineForContinuousUseModel medicineForContinuousUseModel;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

//	public long getNr_medicalRecord() {
//		return nr_medicalRecord;
//	}
//
//	public void setNr_medicalRecord(long nr_medicalRecord) {
//		this.nr_medicalRecord = nr_medicalRecord;
//	}

	public UserModel getUserModel() {
		return userModel;
	}

	public void setUserModel(UserModel userModel) {
		this.userModel = userModel;
	}

	public BloodModel getBloodModel() {
		return bloodModel;
	}

	public void setBloodModel(BloodModel bloodModel) {
		this.bloodModel = bloodModel;
	}

	public AllergyModel getAllergyModel() {
		return allergyModel;
	}

	public void setAllergyModel(AllergyModel allergyModel) {
		this.allergyModel = allergyModel;
	}

	public MedicineForContinuousUseModel getMedicineForContinuousUseModel() {
		return medicineForContinuousUseModel;
	}

	public void setMedicineForContinuousUseModel(MedicineForContinuousUseModel medicineForContinuousUseModel) {
		this.medicineForContinuousUseModel = medicineForContinuousUseModel;
	}

	
}
