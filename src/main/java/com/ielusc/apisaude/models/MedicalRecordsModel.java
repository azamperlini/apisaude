package com.ielusc.apisaude.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="TB_MEDICALRECORDS")
public class MedicalRecordsModel implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(length=10)
	private long nr_medicalRecord = 2019;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getNr_medicalRecord() {
		return nr_medicalRecord;
	}

	public void setNr_medicalRecord(long nr_medicalRecord) {
		this.nr_medicalRecord = nr_medicalRecord;
	}
	
	@OneToOne(fetch=FetchType.LAZY, mappedBy="medicalRecordsModel")
	private GeneralDataModel generalDataModel;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private UserModel userModel;
	
}
