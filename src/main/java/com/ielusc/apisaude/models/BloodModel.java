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

import com.ielusc.apisaude.helpers.BloodType;

@Entity
@Table(name="TB_BLOOD")
public class BloodModel implements Serializable{

private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(length=5)
	private double vl_weight;
	
	@Column(length=5)
	private double vl_height;
	
	private BloodType bloodType;
	
	@Column
	private boolean donorCondition;
	
	@Column(length=10)
	private String dt_lastDonation;
	
	@Column(length=1)
	private Integer qtd_donationYear;
	
	@Column
	private boolean knowsFactors;
	
	@Column
	private boolean knowsProcedures;
	
	@Column
	private boolean bloodProducts;
	
	@Column
	private boolean knowsDonationSite;
	
	@Column
	private boolean knowsDonationTypes;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="medicalRecords_id")
	private MedicalRecordsModel medicalRecordsModel;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getVl_weight() {
		return vl_weight;
	}

	public void setVl_weight(double vl_weight) {
		this.vl_weight = vl_weight;
	}

	public double getVl_height() {
		return vl_height;
	}

	public void setVl_height(double vl_height) {
		this.vl_height = vl_height;
	}

	public BloodType getBloodType() {
		return bloodType;
	}

	public void setBloodType(BloodType bloodType) {
		this.bloodType = bloodType;
	}

	public boolean isDonorCondition() {
		return donorCondition;
	}

	public void setDonorCondition(boolean donorCondition) {
		this.donorCondition = donorCondition;
	}

	public String getDt_lastDonation() {
		return dt_lastDonation;
	}

	public void setDt_lastDonation(String dt_lastDonation) {
		this.dt_lastDonation = dt_lastDonation;
	}

	public Integer getQtd_donationYear() {
		return qtd_donationYear;
	}

	public void setQtd_donationYear(Integer qtd_donationYear) {
		this.qtd_donationYear = qtd_donationYear;
	}

	public boolean isKnowsFactors() {
		return knowsFactors;
	}

	public void setKnowsFactors(boolean knowsFactors) {
		this.knowsFactors = knowsFactors;
	}

	public boolean isKnowsProcedures() {
		return knowsProcedures;
	}

	public void setKnowsProcedures(boolean knowsProcedures) {
		this.knowsProcedures = knowsProcedures;
	}

	public boolean isBloodProducts() {
		return bloodProducts;
	}

	public void setBloodProducts(boolean bloodProducts) {
		this.bloodProducts = bloodProducts;
	}

	public boolean isKnowsDonationSite() {
		return knowsDonationSite;
	}

	public void setKnowsDonationSite(boolean knowsDonationSite) {
		this.knowsDonationSite = knowsDonationSite;
	}

	public boolean isKnowsDonationTypes() {
		return knowsDonationTypes;
	}

	public void setKnowsDonationTypes(boolean knowsDonationTypes) {
		this.knowsDonationTypes = knowsDonationTypes;
	}

	public MedicalRecordsModel getMedicalRecordsModel() {
		return medicalRecordsModel;
	}

	public void setMedicalRecordsModel(MedicalRecordsModel medicalRecordsModel) {
		this.medicalRecordsModel = medicalRecordsModel;
	}
	
	
}
