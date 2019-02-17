package com.app.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name="item_tbl")
public class Item {
	@Id
	@GeneratedValue
	@Column(name="item_id")
	private Integer itemId;
	@Column(name="item_code")
	private String itemCode;
	@Column(name="item_width")
	private double itemWidth;
	@Column(name="item_length")
	private double itemLength;
	@Column(name="item_hight")
	private double itemHight;
	@Column(name="base_cost")
	private String baseCost;
	@Column(name="base_currency")
	private String baseCurrency;
	@ManyToOne
	@JoinColumn(name="uid_fk")
	private Uom uom;

	@ManyToOne
	@JoinColumn(name="saleType_idFk")
	private OrderMethod saleType;

	@ManyToOne
	@JoinColumn(name="purchaseType_idFk")
	private OrderMethod purchaseType;

	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="item_vendor_tbl",joinColumns=@JoinColumn(name="vendorType_idFk"),
	inverseJoinColumns=@JoinColumn(name="whuse_ven_fk"))
	@Fetch(value=FetchMode.SUBSELECT)
	private List<WhUserType> vendorType= new ArrayList<WhUserType>(0);

	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="item_customer_tbl",joinColumns=@JoinColumn(name="customerType_idFk"),
	inverseJoinColumns=@JoinColumn(name="whuse_ven_fk"))
	@Fetch(value=FetchMode.SUBSELECT) 
	private List<WhUserType> customerType=new ArrayList<WhUserType>(0);

	private String dsc;
	public Item() {
		super();
	}
	public Item(Integer itemId) {
		super();
		this.itemId = itemId;
	}
	public Item(Integer itemId, String itemCode, double itemWidth, double itemLength, double itemHight, String baseCost,
			String baseCurrency, Uom uom, OrderMethod saleType, OrderMethod purchaseType, List<WhUserType> vendorType,
			List<WhUserType> customerType, String dsc) {
		super();
		this.itemId = itemId;
		this.itemCode = itemCode;
		this.itemWidth = itemWidth;
		this.itemLength = itemLength;
		this.itemHight = itemHight;
		this.baseCost = baseCost;
		this.baseCurrency = baseCurrency;
		this.uom = uom;
		this.saleType = saleType;
		this.purchaseType = purchaseType;
		this.vendorType = vendorType;
		this.customerType = customerType;
		this.dsc = dsc;
	}
	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public double getItemWidth() {
		return itemWidth;
	}
	public void setItemWidth(double itemWidth) {
		this.itemWidth = itemWidth;
	}
	public double getItemLength() {
		return itemLength;
	}
	public void setItemLength(double itemLength) {
		this.itemLength = itemLength;
	}
	public double getItemHight() {
		return itemHight;
	}
	public void setItemHight(double itemHight) {
		this.itemHight = itemHight;
	}
	public String getBaseCost() {
		return baseCost;
	}
	public void setBaseCost(String baseCost) {
		this.baseCost = baseCost;
	}
	public String getBaseCurrency() {
		return baseCurrency;
	}
	public void setBaseCurrency(String baseCurrency) {
		this.baseCurrency = baseCurrency;
	}
	public Uom getUom() {
		return uom;
	}
	public void setUom(Uom uom) {
		this.uom = uom;
	}
	public OrderMethod getSaleType() {
		return saleType;
	}
	public void setSaleType(OrderMethod saleType) {
		this.saleType = saleType;
	}
	public OrderMethod getPurchaseType() {
		return purchaseType;
	}
	public void setPurchaseType(OrderMethod purchaseType) {
		this.purchaseType = purchaseType;
	}
	public List<WhUserType> getVendorType() {
		return vendorType;
	}
	public void setVendorType(List<WhUserType> vendorType) {
		this.vendorType = vendorType;
	}
	public List<WhUserType> getCustomerType() {
		return customerType;
	}
	public void setCustomerType(List<WhUserType> customerType) {
		this.customerType = customerType;
	}
	public String getDsc() {
		return dsc;
	}
	public void setDsc(String dsc) {
		this.dsc = dsc;
	}
	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemCode=" + itemCode + ", itemWidth=" + itemWidth + ", itemLength="
				+ itemLength + ", itemHight=" + itemHight + ", baseCost=" + baseCost + ", baseCurrency=" + baseCurrency
				+ ", uom=" + uom + ", saleType=" + saleType + ", purchaseType=" + purchaseType + ", vendorType="
				+ vendorType + ", customerType=" + customerType + ", dsc=" + dsc + "]";
	}

}