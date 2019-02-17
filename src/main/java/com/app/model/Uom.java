package com.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="uomtbl")
public class Uom {
	@Id
	@GeneratedValue
	private Integer id;
	private String type;
	private String model;
	private String dsc;
	//default Constructor
	public Uom() {
		super();
	}
	//one parameterized (id)Constructor
	public Uom(Integer id) {
		super();
		this.id = id;
	}
	//parameterized Constructor
	public Uom(Integer id, String type, String model, String dsc) {
		super();
		this.id = id;
		this.type = type;
		this.model = model;
		this.dsc = dsc;
	}
	//set,get
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getDsc() {
		return dsc;
	}
	public void setDsc(String dsc) {
		this.dsc = dsc;
	}
	//toString() method
	@Override
	public String toString() {
		return "Uom [id=" + id + ", type=" + type + ", model=" + model + ", dsc=" + dsc + "]";
	}
}
