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
@Table(name="TB_ONDUTY")
public class OnDutyModel implements Serializable{
	
	private static final long serialVersionUID = 1L;  
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(length=15)
	private String date;
	
	@Column(length=10)
	private String check_in_time;
	
	@Column(length=10)
	private String check_out_time;
	
	@Column(length=250)
	private String descripition;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_registerIntership")
	private RegisterIntershipModel registerIntershipModel;
	
	@OneToOne(fetch=FetchType.LAZY, mappedBy="onDutyModel")
	private OccurrencesModel occurrencesModel;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getCheck_in_time() {
		return check_in_time;
	}

	public void setCheck_in_time(String check_in_time) {
		this.check_in_time = check_in_time;
	}

	public String getCheck_out_time() {
		return check_out_time;
	}

	public void setCheck_out_time(String check_out_time) {
		this.check_out_time = check_out_time;
	}

	public String getDescripition() {
		return descripition;
	}

	public void setDescripition(String descripition) {
		this.descripition = descripition;
	}

	public RegisterIntershipModel getRegisterIntershipModel() {
		return registerIntershipModel;
	}

	public void setRegisterIntershipModel(RegisterIntershipModel registerIntershipModel) {
		this.registerIntershipModel = registerIntershipModel;
	}

	public OccurrencesModel getOccurrencesModel() {
		return occurrencesModel;
	}

	public void setOccurrencesModel(OccurrencesModel occurrencesModel) {
		this.occurrencesModel = occurrencesModel;
	}


	
}
