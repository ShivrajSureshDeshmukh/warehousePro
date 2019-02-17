package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="purchase_order_tbl")
public class PurchaseOrder {
	@Id
	@GeneratedValue
	@Column(name="purchase_id")
	private Integer purchaseId;
	@Column(name="purchase_code")
	private String purchaseCode;
	
	@ManyToOne
	@JoinColumn(name="shipment_idFk")
	private ShipmentType shipmentCode;
	
	@ManyToOne
	@JoinColumn(name="vendorType_idFk")
	private WhUserType vendorType;
	
	@Column(name="purchase_ref")
	private String purchaseRef;
	
	@Column(name="purchase_quality")
	private String purchaseQuality;
	
	@Column(name="purchase_Status")
	private String purchaseStatus;
	
	private String dsc;

	public PurchaseOrder() {
		super();
	}

	public PurchaseOrder(Integer purchaseId) {
		super();
		this.purchaseId = purchaseId;
	}

	public PurchaseOrder(Integer purchaseId, String purchaseCode, ShipmentType shipmentCode, WhUserType vendorType,
			String purchaseRef, String purchaseQuality, String purchaseStatus, String dsc) {
		super();
		this.purchaseId = purchaseId;
		this.purchaseCode = purchaseCode;
		this.shipmentCode = shipmentCode;
		this.vendorType = vendorType;
		this.purchaseRef = purchaseRef;
		this.purchaseQuality = purchaseQuality;
		this.purchaseStatus = purchaseStatus;
		this.dsc = dsc;
	}

	public Integer getPurchaseId() {
		return purchaseId;
	}

	public void setPurchaseId(Integer purchaseId) {
		this.purchaseId = purchaseId;
	}

	public String getPurchaseCode() {
		return purchaseCode;
	}

	public void setPurchaseCode(String purchaseCode) {
		this.purchaseCode = purchaseCode;
	}

	public ShipmentType getShipmentCode() {
		return shipmentCode;
	}

	public void setShipmentCode(ShipmentType shipmentCode) {
		this.shipmentCode = shipmentCode;
	}

	public WhUserType getVendorType() {
		return vendorType;
	}

	public void setVendorType(WhUserType vendorType) {
		this.vendorType = vendorType;
	}

	public String getPurchaseRef() {
		return purchaseRef;
	}

	public void setPurchaseRef(String purchaseRef) {
		this.purchaseRef = purchaseRef;
	}

	public String getPurchaseQuality() {
		return purchaseQuality;
	}

	public void setPurchaseQuality(String purchaseQuality) {
		this.purchaseQuality = purchaseQuality;
	}

	public String getPurchaseStatus() {
		return purchaseStatus;
	}

	public void setPurchaseStatus(String purchaseStatus) {
		this.purchaseStatus = purchaseStatus;
	}

	public String getDsc() {
		return dsc;
	}

	public void setDsc(String dsc) {
		this.dsc = dsc;
	}

	@Override
	public String toString() {
		return "PurchaseOrder [purchaseId=" + purchaseId + ", purchaseCode=" + purchaseCode + ", shipmentCode="
				+ shipmentCode + ", vendorType=" + vendorType + ", purchaseRef=" + purchaseRef + ", purchaseQuality="
				+ purchaseQuality + ", purchaseStatus=" + purchaseStatus + ", dsc=" + dsc + "]";
	}
}
