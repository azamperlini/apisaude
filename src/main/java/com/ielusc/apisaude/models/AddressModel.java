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
@Table(name="TB_ADDRESS")
public class AddressModel implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(length=25)
	private String ds_country;

	@Column(length=10)
	private String zip_cod;
	
	@Column(length=10)
	private String tp_street;
	
	@Column(length=40)
	private String nm_street;
	
	@Column(length=5)
	private Integer number;
	
	@Column
	private boolean noNumber; 
	
	@Column(length=25)
	private String ds_complement;
	
	@OneToOne(fetch=FetchType.LAZY, mappedBy="addressModel")
	private StateModel stateModel;
	
	@OneToOne(fetch=FetchType.LAZY, mappedBy="addressModel")
	private CityModel cityModel;
	
	@OneToOne(fetch=FetchType.LAZY, mappedBy="addressModel")
	private DistrictModel districtModel;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="general_data_id")
	private GeneralDataModel generalDataModel;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDs_country() {
		return ds_country;
	}

	public void setDs_country(String ds_country) {
		this.ds_country = ds_country;
	}

	public String getZip_cod() {
		return zip_cod;
	}

	public void setZip_cod(String zip_cod) {
		this.zip_cod = zip_cod;
	}

	public String getTp_street() {
		return tp_street;
	}

	public void setTp_street(String tp_street) {
		this.tp_street = tp_street;
	}

	public String getNm_street() {
		return nm_street;
	}

	public void setNm_street(String nm_street) {
		this.nm_street = nm_street;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public boolean isNoNumber() {
		return noNumber;
	}

	public void setNoNumber(boolean noNumber) {
		this.noNumber = noNumber;
	}

	public String getDs_complement() {
		return ds_complement;
	}

	public void setDs_complement(String ds_complement) {
		this.ds_complement = ds_complement;
	}

	public StateModel getStateModel() {
		return stateModel;
	}

	public void setStateModel(StateModel stateModel) {
		this.stateModel = stateModel;
	}

	public CityModel getCityModel() {
		return cityModel;
	}

	public void setCityModel(CityModel cityModel) {
		this.cityModel = cityModel;
	}

	public DistrictModel getDistrictModel() {
		return districtModel;
	}

	public void setDistrictModel(DistrictModel districtModel) {
		this.districtModel = districtModel;
	}

	public GeneralDataModel getGeneralDataModel() {
		return generalDataModel;
	}

	public void setGeneralDataModel(GeneralDataModel generalDataModel) {
		this.generalDataModel = generalDataModel;
	}
	
	
	
}
