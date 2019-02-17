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

import com.app.model.Vendor;
import com.app.service.IVendorService;
import com.app.view.VendorExcelView;
import com.app.view.VendorPdfView;

@Controller
@RequestMapping("/vendor")
public class VendorController {
	@Autowired
	private IVendorService service;

	@RequestMapping("/create")
	public String showData(ModelMap map) {
		map.addAttribute("vendor", new Vendor());
		return "VendorCreate";
	}
	
	@RequestMapping(value="insert",method=RequestMethod.POST)
	public String createVendor(@ModelAttribute Vendor vendor,ModelMap map) {
		int vendorId=service.saveVendor(vendor);
		String message="Vendor is '"+vendorId+"'Created...";
		map.addAttribute("message", message);
		return "VendorCreate";
	}
	@RequestMapping("/all")
	public String showAll(ModelMap map) {
		List<Vendor> vendors=service.getAllVendors();
		map.addAttribute("list", vendors);
		return "VendorData";
	}
	@RequestMapping("/delete")
	public String deleteEmp(@RequestParam("id") Integer id,ModelMap map)
	{
		//call service Layer delete
		service.deleteVendor(id);
		//construct final msg
		String msg="Vendor'"+id+"'Deleted...";
		//get Remaing(new) data
		List<Vendor> vendors=service.getAllVendors();
		map.addAttribute("message", msg);
		map.addAttribute("list", vendors);
		return "VendorData";
	}
	@RequestMapping("/edit")
	public String showEdit(@RequestParam("id") Integer id,ModelMap map){
		Vendor vendor=service.getOneVendorById(id);
		map.addAttribute("vendor",vendor);
		return "VendorEdit";
	}
	@RequestMapping(value="update",method=RequestMethod.POST)
	public String doUpdate(@ModelAttribute Vendor vendor,ModelMap map) {
		service.updateVendor(vendor);
		List<Vendor> vendors=service.getAllVendors();
		String msg="Vendor '"+vendor.getVenId()+"'Updated";
		map.addAttribute("message", msg);
		map.addAttribute("list", vendors);
		return "VendorData";
	}
	//Export Data to Excel
	@RequestMapping("/excel")
	public ModelAndView showExcel() {
		//fetch data from Database
		List<Vendor> vendors=service.getAllVendors();
		//Create ModelAndView
		ModelAndView m=new ModelAndView();
		//provide view class name
		m.setView(new VendorExcelView());
		//provide data to it
		m.addObject("vendors", vendors);
		return m;
	}
	//Export Data to PDF
	@RequestMapping("/pdf")
	public ModelAndView showPdf() {
		//fetch data from Database
		List<Vendor> vendors=service.getAllVendors();
		//Create ModelAndView
		ModelAndView m=new ModelAndView();
		//provide view class name
		m.setView(new VendorPdfView());
		//provide data to it
		m.addObject("vendors", vendors);
		return m;
		//return null;
	}
}
