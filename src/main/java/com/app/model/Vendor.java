package com.app.model;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

@Entity
@Table(name="vendorTbl")
public class Vendor {
	@Id
	@GeneratedValue
	private Integer venId;
	private String venName;
	private String venCode;
	private String venDesg;
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name="vendorPreserveTbl",joinColumns=@JoinColumn(name="venId"))
	@OrderColumn(name="pos")
	@Column(name="data")
	private List<String> venPreserve;
	public Vendor() {
		super();
	}
	public Vendor(Integer venId) {
		super();
		this.venId = venId;
	}
	public Vendor(Integer venId, String venName, String venCode, String venDesg, List<String> venPreserve) {
		super();
		this.venId = venId;
		this.venName = venName;
		this.venCode = venCode;
		this.venDesg = venDesg;
		this.venPreserve = venPreserve;
	}
	//set,get method
	public Integer getVenId() {
		return venId;
	}
	public void setVenId(Integer venId) {
		this.venId = venId;
	}
	public String getVenName() {
		return venName;
	}
	public void setVenName(String venName) {
		this.venName = venName;
	}
	public String getVenCode() {
		return venCode;
	}
	public void setVenCode(String venCode) {
		this.venCode = venCode;
	}
	public String getVenDesg() {
		return venDesg;
	}
	public void setVenDesg(String venDesg) {
		this.venDesg = venDesg;
	}
	public List<String> getVenPreserve() {
		return venPreserve;
	}
	public void setVenPreserve(List<String> venPreserve) {
		this.venPreserve = venPreserve;
	}
	
	//toString() method
	@Override
	public String toString() {
		return "Vendor [venId=" + venId + ", venName=" + venName + ", venCode=" + venCode + ", venDesg=" + venDesg
				+ ", venPreserve=" + venPreserve + "]";
	}
	
	
	
	

}
