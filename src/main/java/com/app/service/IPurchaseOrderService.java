package com.app.service;

import java.util.List;

import com.app.model.PurchaseOrder;

public interface IPurchaseOrderService {
	public Integer savePurchaseOrder(PurchaseOrder purchaseorder);
	public void updatePurchaseOrder(PurchaseOrder purchaseorder);
	public void deletePurchaseOrder(Integer purchaseorderId);
	public PurchaseOrder getOnePurchaseOrderById(Integer purchaseorderId);
	public List<PurchaseOrder> getAllPurchaseOrders();
}
