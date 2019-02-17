package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.model.OrderMethod;
import com.app.service.IOrderMethodService;
import com.app.validator.OrderMethodValidator;
import com.app.view.OrderMethodExcelView;
import com.app.view.OrderMethodPdfView;
@Controller
@RequestMapping("/order")
public class OrderMethodController {
	@Autowired
	private IOrderMethodService service;
	@Autowired
	private OrderMethodValidator validator;

	@RequestMapping("/create")
	public String showData(ModelMap map) {
		map.addAttribute("orderMethod", new OrderMethod());
		return "OrderMethodCreate";
	}
	
	@RequestMapping(value="insert",method=RequestMethod.POST)
	public String createOrderMethod(@ModelAttribute OrderMethod orderMethod,Errors errors,ModelMap map) {
		
		validator.validate(orderMethod, errors);
		if(!errors.hasErrors())
		{
		int orderMethodId=service.saveOrderMethod(orderMethod);
		String message="OrderMethod is '"+orderMethodId+"'Created...";
		map.addAttribute("message", message);
		//Clear all Data
		map.addAttribute("orderMethod", new OrderMethod());
		}
		return "OrderMethodCreate";
	}
	@RequestMapping("/all")
	public String showAll(ModelMap map) {
		List<OrderMethod> ordermethods=service.getAllOrderMethods();
		map.addAttribute("list", ordermethods);
		return "OrderMethodData";
	}
	@RequestMapping("/delete")
	public String deleteEmp(@RequestParam("id") Integer id,ModelMap map)
	{
		String msg;
		try {
		//call service Layer delete
		service.deleteOrderMethod(id);
		//construct finnal msg
		msg="OrderMethod'"+id+"'Deleted...";
		}catch(Exception e)
		{
			msg="Record '"+id+"' is Not Found.";
		}
		//get Remainng(new) data
		List<OrderMethod> ordermethods=service.getAllOrderMethods();
		map.addAttribute("message", msg);
		map.addAttribute("list", ordermethods);
		return "OrderMethodData";
	}
	@RequestMapping("/edit")
	public String showEdit(@RequestParam("id") Integer id,ModelMap map){
		OrderMethod orderMethod=service.getOneOrderMethodById(id);
		map.addAttribute("orderMethod",orderMethod);
		return "OrderMethodEdit";
	}
	@RequestMapping(value="update",method=RequestMethod.POST)
	public String doUpdate(@ModelAttribute OrderMethod orderMethod,ModelMap map) {
		service.updateOrderMethod(orderMethod);
		List<OrderMethod> ordermethods=service.getAllOrderMethods();
		String message="OrderMethod '"+orderMethod.getId()+"'Updated";
		map.addAttribute("message", message);
		map.addAttribute("list", ordermethods);
		return "OrderMethodData";
	}
	//Export Data to Excel
	@RequestMapping("/excel")
	public ModelAndView showExcel() {
		//fetch data from Database
		List<OrderMethod> ordermethods=service.getAllOrderMethods();
		//Create ModelAndView
		ModelAndView m=new ModelAndView();
		//provide view class name
		m.setView(new OrderMethodExcelView());
		//provide data to it
		m.addObject("ordermethods", ordermethods);
		return m;
	}
	//Export Data to PDF
	@RequestMapping("/pdf")
	public ModelAndView showPdf() {
		//fetch data from Database
		List<OrderMethod> ordermethods=service.getAllOrderMethods();
		//Create ModelAndView
		ModelAndView m=new ModelAndView();
		//provide view class name
		m.setView(new OrderMethodPdfView());
		//provide data to it
		m.addObject("ordermethods", ordermethods);
		return m;
		//return null;
	}


}
