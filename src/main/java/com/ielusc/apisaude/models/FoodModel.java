package com.ielusc.apisaude.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="TB_FOOD")
public class FoodModel implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(length=60)
	private String ds_food;
	
	@ManyToMany(mappedBy = "foodModel")
    private Set<AllergyModel> allergyModel = new HashSet<>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDs_food() {
		return ds_food;
	}

	public void setDs_food(String ds_food) {
		this.ds_food = ds_food;
	}

	public Set<AllergyModel> getAllergyModel() {
		return allergyModel;
	}

	public void setAllergyModel(Set<AllergyModel> allergyModel) {
		this.allergyModel = allergyModel;
	}
	
}
