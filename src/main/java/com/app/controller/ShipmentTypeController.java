package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateOptimisticLockingFailureException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.ShipmentType;
import com.app.service.IShipmentTypeService;
@Controller
@RequestMapping("/shipment")
public class ShipmentTypeController {
	@Autowired
	private IShipmentTypeService service;

	@RequestMapping("/create")
	public String showData(ModelMap map) {
		map.addAttribute("shipmenttype", new ShipmentType());
		return "ShipmentTypeCreate";
	}
	
	@RequestMapping(value="insert",method=RequestMethod.POST)
	public String createShipmentType(@ModelAttribute ShipmentType shipmenttype,ModelMap map) {
		int shipmentTypeId=service.saveShipmentType(shipmenttype);
		String message="ShipmentType is '"+shipmentTypeId+"'Created...";
		map.addAttribute("message", message);
		//Clear all Data
		map.addAttribute("shipmenttype", new ShipmentType());
		return "ShipmentTypeCreate";
	}
	@RequestMapping("/all")
	public String showAll(ModelMap map) {
		List<ShipmentType> shipmenttypes=service.getAllShipmentTypes();
		map.addAttribute("list", shipmenttypes);
		return "ShipmentTypeData";
	}
	@RequestMapping("/delete")
	public String deleteEmp(@RequestParam("id") Integer id,ModelMap map)
	{
		String msg;
		try {
		//call service Layer delete
		service.deleteShipmentType(id);
		//construct finnal msg
		msg="ShipmentType '"+id+"'Deleted...";
		}catch(HibernateOptimisticLockingFailureException e) {
			msg="Record '"+id+"' is not Found.";
		}
		//get Remainng(new) data
		List<ShipmentType> shipmenttypes=service.getAllShipmentTypes();
		map.addAttribute("message", msg);
		map.addAttribute("list", shipmenttypes);
		return "ShipmentTypeData";
	}
	@RequestMapping("/edit")
	public String showEdit(@RequestParam("id") Integer id,ModelMap map){
		ShipmentType shipmenttype=service.getOneShipmentTypeById(id);
		map.addAttribute("shipmenttype",shipmenttype);
		return "ShipmentTypeEdit";
	}
	@RequestMapping(value="update",method=RequestMethod.POST)
	public String doUpdate(@ModelAttribute ShipmentType ShipmentType,ModelMap map) {
		service.updateShipmentType(ShipmentType);
		List<ShipmentType> shipmenttypes=service.getAllShipmentTypes();
		String message="ShipmentType '"+ShipmentType.getId()+"'Updated";
		map.addAttribute("message", message);
		map.addAttribute("list", shipmenttypes);
		return "ShipmentTypeData";
	}
	/*
	//Export Datalm to Excel
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
		//Create ModelAndViewo
		ModelAndView m=new ModelAndView();
		//provide view class name
		m.setView(new VendorPdfView());
		//provide data to it
		m.addObject("vendors", vendors);
		return m;
		//return null;
	}

*/

}
