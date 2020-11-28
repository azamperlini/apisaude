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

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="TB_REGISTERINTERSHIP")
public class RegisterIntershipModel implements Serializable{

	private static final long serialVersionUID = 1L;  
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(length=15)
	private String start_date;

	@Column(length=15)
	private String end_date;
	
	@Column(length=20)
	private String coodination;
	
	@Column(length=15)
	private String amount_of_hours;
	
	@JsonIgnore
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_user")
	private UserModel userModel;
	
	@OneToOne(fetch=FetchType.LAZY, mappedBy="registerIntershipModel")
	private OnDutyModel onDutyModel;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public String getCoodination() {
		return coodination;
	}

	public void setCoodination(String coodination) {
		this.coodination = coodination;
	}

	public String getAmount_of_hours() {
		return amount_of_hours;
	}

	public void setAmount_of_hours(String amount_of_hours) {
		this.amount_of_hours = amount_of_hours;
	}

	public UserModel getUserModel() {
		return userModel;
	}

	public void setUserModel(UserModel userModel) {
		this.userModel = userModel;
	}

	public OnDutyModel getOnDutyModel() {
		return onDutyModel;
	}

	public void setOnDutyModel(OnDutyModel onDutyModel) {
		this.onDutyModel = onDutyModel;
	}
	
}
