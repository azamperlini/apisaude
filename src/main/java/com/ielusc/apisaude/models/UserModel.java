package com.ielusc.apisaude.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.ielusc.apisaude.helpers.GeneralStatus;
import com.ielusc.apisaude.helpers.Permission;



@Entity
@Table(name="TB_USERS")
public class UserModel implements Serializable{
	
	private static final long serialVersionUID = 1L;  
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(unique = true)
	private String userName;
	
	@Column(length=20)
	private String firstName;
	
	@Column(length=40)
	private String lastName;
	
	@Column(length=60)
	private String password;
	
	@Column
	private boolean privacy;

	private GeneralStatus status;
	
	private Permission permission;
	

	@OneToOne(fetch=FetchType.LAZY, mappedBy="userModel")
	private GeneralDataModel generalDataModel;
	
	@OneToOne(fetch=FetchType.LAZY, mappedBy="userModel")
	private MedicalRecordsModel medicalRecordsModel;

	public long getId() {
		return id;
	}

	public void setId(long idUser) {
		this.id = idUser;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isPrivacy() {
		return privacy;
	}

	public void setPrivacy(boolean privacy) {
		this.privacy = privacy;
	}

	public GeneralStatus getStatus() {
		return status;
	}

	public void setStatus(GeneralStatus status) {
		this.status = status;
	}

	public Permission getPermission() {
		return permission;
	}

	public void setPermission(Permission permission) {
		this.permission = permission;
	}

	public GeneralDataModel getGeneralDataModel() {
		return generalDataModel;
	}

	public void setGeneralDataModel(GeneralDataModel generalDataModel) {
		this.generalDataModel = generalDataModel;
	}

	public MedicalRecordsModel getMedicalRecordsModel() {
		return medicalRecordsModel;
	}

	public void setMedicalRecordsModel(MedicalRecordsModel medicalRecordsModel) {
		this.medicalRecordsModel = medicalRecordsModel;
	}
	
}
