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
@Table(name="TB_OCCURRENCES")
public class OccurrencesModel implements Serializable{
	
	private static final long serialVersionUID = 1L;  
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(length=15)
	private String date;
	
	@Column(length=10)
	private String openning_time;
	
	@Column(length=10)
	private String closing_time;
	
	@Column(length=250)
	private String descripition;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_onDuty")
	private OnDutyModel onDutyModel;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_user")
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

	public String getOpenning_time() {
		return openning_time;
	}

	public void setOpenning_time(String openning_time) {
		this.openning_time = openning_time;
	}

	public String getClosing_time() {
		return closing_time;
	}

	public void setClosing_time(String closing_time) {
		this.closing_time = closing_time;
	}

	public String getDescripition() {
		return descripition;
	}

	public void setDescripition(String descripition) {
		this.descripition = descripition;
	}

	public OnDutyModel getOnDutyModel() {
		return onDutyModel;
	}

	public void setOnDutyModel(OnDutyModel onDutyModel) {
		this.onDutyModel = onDutyModel;
	}

	public UserModel getUserModel() {
		return userModel;
	}

	public void setUserModel(UserModel userModel) {
		this.userModel = userModel;
	}
	
}