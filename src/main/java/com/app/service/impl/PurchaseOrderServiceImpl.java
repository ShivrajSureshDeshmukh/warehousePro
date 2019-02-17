package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IPurchaseOrderDao;
import com.app.model.PurchaseOrder;
import com.app.service.IPurchaseOrderService;
@Service
public class PurchaseOrderServiceImpl implements IPurchaseOrderService {

	@Autowired
	private IPurchaseOrderDao dao;
	@Override
	@Transactional
	public Integer savePurchaseOrder(PurchaseOrder purchaseorder) {
		return dao.savePurchaseOrder(purchaseorder);
	}

	@Override
	@Transactional
	public void updatePurchaseOrder(PurchaseOrder purchaseorder) {
		dao.updatePurchaseOrder(purchaseorder);
	}

	@Override
	@Transactional
	public void deletePurchaseOrder(Integer purchaseorderId) {
		dao.deletePurchaseOrder(purchaseorderId);
	}

	@Override
	@Transactional(readOnly=true)
	public PurchaseOrder getOnePurchaseOrderById(Integer purchaseorderId) {
		return dao.getOnePurchaseOrderById(purchaseorderId);
	}

	@Override
	@Transactional(readOnly=true)
	public List<PurchaseOrder> getAllPurchaseOrders() {
		return dao.getAllPurchaseOrders();
	}

}
