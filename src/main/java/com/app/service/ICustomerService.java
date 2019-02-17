package com.app.service;

import java.util.List;

import com.app.model.Customer;

public interface ICustomerService {
	public Integer saveCustomer(Customer customer);
	public void updateCustomer(Customer customer);
	public void deleteCustomer(Integer customerId);
	public Customer getOneCustomerById(Integer customerId);
	public List<Customer> getAllCustomers();


}
