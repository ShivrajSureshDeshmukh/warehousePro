package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IPurchaseOrderDao;
import com.app.model.PurchaseOrder;
@Repository
public class PurchaseOrderDaoImpl implements IPurchaseOrderDao {

	@Autowired
	private HibernateTemplate ht;
	@Override
	public Integer savePurchaseOrder(PurchaseOrder purchaseorder) {
		return (Integer)ht.save(purchaseorder);
	}

	@Override
	public void updatePurchaseOrder(PurchaseOrder purchaseorder) {
		ht.update(purchaseorder);
	}

	@Override
	public void deletePurchaseOrder(Integer purchaseorderId) {
		PurchaseOrder purchaseorder=new PurchaseOrder();
		purchaseorder.setPurchaseId(purchaseorderId);
		ht.delete(purchaseorder);
	}

	@Override
	public PurchaseOrder getOnePurchaseOrderById(Integer purchaseorderId) {
		// TODO Auto-generated method stub
		return ht.get(PurchaseOrder.class, purchaseorderId);
	}

	@Override
	public List<PurchaseOrder> getAllPurchaseOrders() {
		// TODO Auto-generated method stub
		return ht.loadAll(PurchaseOrder.class);
	}

}
