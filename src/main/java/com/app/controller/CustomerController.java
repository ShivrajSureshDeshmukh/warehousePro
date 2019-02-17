package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.model.Customer;
import com.app.service.ICustomerService;
import com.app.view.CustomerExcelView;
import com.app.view.CustomerPdfView;
@Controller
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private ICustomerService service;

	@RequestMapping("/create")
	public String showData(ModelMap map) {
		map.addAttribute("customer", new Customer());
		return "CustomerCreate";
	}
	
	@RequestMapping(value="insert",method=RequestMethod.POST)
	public String createCustomer(@ModelAttribute Customer customer,ModelMap map) {
		int customerId=service.saveCustomer(customer);
		String message="Customer is '"+customerId+"'Created...";
		map.addAttribute("message", message);
		return "CustomerCreate";
	}
	@RequestMapping("/all")
	public String showAll(ModelMap map) {
		List<Customer> customers=service.getAllCustomers();
		map.addAttribute("list", customers);
		return "CustomerData";
	}
	@RequestMapping("/delete")
	public String deleteEmp(@RequestParam("id") Integer id,ModelMap map)
	{
		//call service Layer delete
		service.deleteCustomer(id);
		//construct finnal msg
		String msg="Customer'"+id+"'Deleted...";
		//get Remainng(new) data
		List<Customer> customers=service.getAllCustomers();
		map.addAttribute("message", msg);
		map.addAttribute("list", customers);
		return "CustomerData";
	}
	@RequestMapping("/edit")
	public String showEdit(@RequestParam("id") Integer id,ModelMap map){
		Customer customer=service.getOneCustomerById(id);
		map.addAttribute("customer",customer);
		return "CustomerEdit";
	}
	@RequestMapping(value="update",method=RequestMethod.POST)
	public String doUpdate(@ModelAttribute Customer Customer,ModelMap map) {
		service.updateCustomer(Customer);
		List<Customer> customers=service.getAllCustomers();
		String msg="Customer '"+Customer.getCustId()+"'Updated";
		map.addAttribute("message", msg);
		map.addAttribute("list", customers);
		return "CustomerData";
	}
	//Export Data to Excel
	@RequestMapping("/excel")
	public ModelAndView showExcel() {
		//fetch data from Database
		List<Customer> customers=service.getAllCustomers();
		//Create ModelAndView
		ModelAndView m=new ModelAndView();
		//provide view class name
		m.setView(new CustomerExcelView());
		//provide data to it
		m.addObject("customers", customers);
		return m;
	}
	//Export Data to PDF
	@RequestMapping("/pdf")
	public ModelAndView showPdf() {
		//fetch data from Database
		List<Customer> customers=service.getAllCustomers();
		//Create ModelAndView
		ModelAndView m=new ModelAndView();
		//provide view class name
		m.setView(new CustomerPdfView());
		//provide data to it
		m.addObject("customers", customers);
		return m;
	}
	
}
