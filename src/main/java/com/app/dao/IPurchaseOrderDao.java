package com.app.dao;

import java.util.List;

import com.app.model.PurchaseOrder;

public interface IPurchaseOrderDao {
	public Integer savePurchaseOrder(PurchaseOrder purchaseorder);
	public void updatePurchaseOrder(PurchaseOrder purchaseorder);
	public void deletePurchaseOrder(Integer purchaseorderId);
	public PurchaseOrder getOnePurchaseOrderById(Integer purchaseorderId);
	public List<PurchaseOrder> getAllPurchaseOrders();


}
