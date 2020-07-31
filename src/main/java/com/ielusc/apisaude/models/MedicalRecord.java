package com.ielusc.apisaude.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TB_MEDICALRECORDS")
public class MedicalRecord implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name="cod_medicalrecord")
	private long medicalrecord;
	

}
