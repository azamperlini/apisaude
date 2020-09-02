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
@Table(name="TB_CONTACTS")
public class ContactModel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(length=25)
	private String nr_telResidence;
	
	@Column(length=25)
	private String nr_cellPhone;
	
	@Column(length=5)
	private boolean whatsapp;
	
	@Column(length=40)
	private String email;
	
	@Column(length=25)
	private String nr_emergencyPhone1;
	
	@Column(length=40)
	private String nm_emergencyPhone1;
	
	@Column(length=25)
	private String nr_emergencyPhone2;
	
	@Column(length=40)
	private String nm_emergencyPhone2;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNr_telResidence() {
		return nr_telResidence;
	}

	public void setNr_telResidence(String nr_telResidence) {
		this.nr_telResidence = nr_telResidence;
	}

	public String getNr_cellPhone() {
		return nr_cellPhone;
	}

	public void setNr_cellPhone(String nr_cellPhone) {
		this.nr_cellPhone = nr_cellPhone;
	}

	public boolean isWhatsapp() {
		return whatsapp;
	}

	public void setWhatsapp(boolean whatsapp) {
		this.whatsapp = whatsapp;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNr_emergencyPhone1() {
		return nr_emergencyPhone1;
	}

	public void setNr_emergencyPhone1(String nr_emergencyPhone1) {
		this.nr_emergencyPhone1 = nr_emergencyPhone1;
	}

	public String getNm_emergencyPhone1() {
		return nm_emergencyPhone1;
	}

	public void setNm_emergencyPhone1(String nm_emergencyPhone1) {
		this.nm_emergencyPhone1 = nm_emergencyPhone1;
	}

	public String getNr_emergencyPhone2() {
		return nr_emergencyPhone2;
	}

	public void setNr_emergencyPhone2(String nr_emergencyPhone2) {
		this.nr_emergencyPhone2 = nr_emergencyPhone2;
	}

	public String getNm_emergencyPhone2() {
		return nm_emergencyPhone2;
	}

	public void setNm_emergencyPhone2(String nm_emergencyPhone2) {
		this.nm_emergencyPhone2 = nm_emergencyPhone2;
	}

	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="general_data_id")
	private GeneralDataModel generalDataModel;
	
}
