package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ICustomerDao;
import com.app.model.Customer;
import com.app.service.ICustomerService;
@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private ICustomerDao dao;
	@Override
	@Transactional
	public Integer saveCustomer(Customer customer) {
		return dao.saveCustomer(customer);
	}

	@Override
	@Transactional
	public void updateCustomer(Customer customer) {
		dao.updateCustomer(customer);
	}

	@Override
	@Transactional
	public void deleteCustomer(Integer customerId) {
		dao.deleteCustomer(customerId);
	}

	@Override
	@Transactional(readOnly=true)
	public Customer getOneCustomerById(Integer customerId) {
		return dao.getOneCustomerById(customerId);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Customer> getAllCustomers() {
		return dao.getAllCustomers();
	}

}
