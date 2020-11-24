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
@Table(name="TB_AGENDA")
public class AgendaModel implements Serializable{

	private static final long serialVersionUID = 1L;  
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(length=15)
	private String date;
	
	@Column(length=10)
	private String time;
	
	@Column(length=40)
	private String specialty;
	
	@Column(length=20)
	private String nm_Doctor;
	
	@Column(length=60)
	private String ds_address;
	
	@Column(length=25)
	private String contact;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private UserModel userModel;
	
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

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	public String getNm_Doctor() {
		return nm_Doctor;
	}

	public void setNm_Doctor(String nm_Doctor) {
		this.nm_Doctor = nm_Doctor;
	}

	public String getDs_address() {
		return ds_address;
	}

	public void setDs_address(String ds_address) {
		this.ds_address = ds_address;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public UserModel getUserModel() {
		return userModel;
	}

	public void setUserModel(UserModel userModel) {
		this.userModel = userModel;
	}
	
}
