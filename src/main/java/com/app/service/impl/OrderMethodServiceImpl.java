package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IOrderMethodDao;
import com.app.model.OrderMethod;
import com.app.service.IOrderMethodService;
@Service
public class OrderMethodServiceImpl implements IOrderMethodService {

	@Autowired
	private IOrderMethodDao dao;
	@Override
	@Transactional
	public Integer saveOrderMethod(OrderMethod ordermethod) {
		return dao.saveOrderMethod(ordermethod);
	}

	@Override
	@Transactional
	public void updateOrderMethod(OrderMethod ordermethod) {
		dao.updateOrderMethod(ordermethod);
	}

	@Override
	@Transactional
	public void deleteOrderMethod(Integer orderMethodId) {
		dao.deleteOrderMethod(orderMethodId);
	}

	@Override
	@Transactional(readOnly=true)
	public OrderMethod getOneOrderMethodById(Integer orderMethodId) {
		return dao.getOneOrderMethodById(orderMethodId);
	}

	@Override
	@Transactional(readOnly=true)
	public List<OrderMethod> getAllOrderMethods() {
		return dao.getAllOrderMethods();
	}

	@Override
	@Transactional(readOnly=true)
	public List<OrderMethod> getOrderMethodsByMode(String mode) {
		return dao.getOrderMethodsByMode(mode);
	}

}
