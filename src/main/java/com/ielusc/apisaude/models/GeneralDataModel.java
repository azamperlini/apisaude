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

import com.ielusc.apisaude.helpers.Gender;

@Entity
@Table(name="TB_GENERAL_DATA")
public class GeneralDataModel implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(unique = true)
	private String nr_cpf;
	
	@Column(unique = true, length=15)
	private String nr_registration;
	
	@Column(length=40)
	private String nm_social;
	
	@Column(length=10)
	private String dt_birth;
	
	private Gender gender;
	
	@Column(length=20)
	private String genderIdentity;
	
	@Column(length=40)
	private String nm_mother;
	
	@Column(length=40)
	private String nm_father;
	
	@Column(length=40)
	private String ds_nationality;
	
	@Column(length=60)
	private String ds_birthTownship;
	
	@Column(length=15)
	private String ds_maritalStatus;
	
	@Column(length=40)
	private String profileImage;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_user")
	private UserModel userModel;
	
	@OneToOne(fetch=FetchType.LAZY, mappedBy="generalDataModel")
	private AddressModel addressModel;
	
	@OneToOne(fetch=FetchType.LAZY, mappedBy="generalDataModel")
	private ContactModel contactModel;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNr_cpf() {
		return nr_cpf;
	}

	public void setNr_cpf(String nr_cpf) {
		this.nr_cpf = nr_cpf;
	}

	public String getNr_registration() {
		return nr_registration;
	}

	public void setNr_registration(String nr_registration) {
		this.nr_registration = nr_registration;
	}

	public String getNm_social() {
		return nm_social;
	}

	public void setNm_social(String nm_social) {
		this.nm_social = nm_social;
	}

	public String getDt_birth() {
		return dt_birth;
	}

	public void setDt_birth(String dt_birth) {
		this.dt_birth = dt_birth;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getGenderIdentity() {
		return genderIdentity;
	}

	public void setGenderIdentity(String genderIdentity) {
		this.genderIdentity = genderIdentity;
	}

	public String getNm_mother() {
		return nm_mother;
	}

	public void setNm_mother(String nm_mother) {
		this.nm_mother = nm_mother;
	}

	public String getNm_father() {
		return nm_father;
	}

	public void setNm_father(String nm_father) {
		this.nm_father = nm_father;
	}

	public String getDs_nationality() {
		return ds_nationality;
	}

	public void setDs_nationality(String ds_nationality) {
		this.ds_nationality = ds_nationality;
	}

	public String getDs_birthTownship() {
		return ds_birthTownship;
	}

	public void setDs_birthTownship(String ds_birthTownship) {
		this.ds_birthTownship = ds_birthTownship;
	}

	public String getDs_maritalStatus() {
		return ds_maritalStatus;
	}

	public void setDs_maritalStatus(String ds_maritalStatus) {
		this.ds_maritalStatus = ds_maritalStatus;
	}

	public String getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}

	public UserModel getUserModel() {
		return userModel;
	}

	public void setUserModel(UserModel userModel) {
		this.userModel = userModel;
	}

	public AddressModel getAddressModel() {
		return addressModel;
	}

	public void setAddressModel(AddressModel addressModel) {
		this.addressModel = addressModel;
	}

	public ContactModel getContactModel() {
		return contactModel;
	}

	public void setContactModel(ContactModel contactModel) {
		this.contactModel = contactModel;
	}

}
