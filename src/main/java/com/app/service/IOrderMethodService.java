package com.app.service;

import java.util.List;

import com.app.model.OrderMethod;

public interface IOrderMethodService {
	
	public Integer saveOrderMethod(OrderMethod ordermethod);
	public void updateOrderMethod(OrderMethod ordermethod);
	public void deleteOrderMethod(Integer orderMethodId);
	public OrderMethod getOneOrderMethodById(Integer orderMethodId);
	public List<OrderMethod> getAllOrderMethods();
	public List<OrderMethod> getOrderMethodsByMode(String mode);
	

}
