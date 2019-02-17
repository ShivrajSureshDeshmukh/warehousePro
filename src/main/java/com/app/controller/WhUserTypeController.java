package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.WhUserType;
import com.app.service.IWhUserTypeService;
import com.app.validator.WhUserTypeValidator;
@Controller
@RequestMapping("/whuser")
public class WhUserTypeController {

	@Autowired
	private IWhUserTypeService service;
	@Autowired
	private WhUserTypeValidator validator;

	@RequestMapping("/create")
	public String showData(ModelMap map) {
		map.addAttribute("whUserType", new WhUserType());
		return "WhUserTypeCreate";
	}
	
	@RequestMapping(value="insert",method=RequestMethod.POST)
	public String createWhUserType(@ModelAttribute WhUserType whusertype,Errors errors,ModelMap map) {
		
		validator.validate(whusertype, errors);
		
		if(!errors.hasErrors()) {
		int whUserTypeId=service.saveWhUserType(whusertype);
		String message="WhUserType is '"+whUserTypeId+"'Created...";
		map.addAttribute("message", message);
		//Clear all Data
		map.addAttribute("whUserType", new WhUserType());
		}
		return "WhUserTypeCreate";
	}
	@RequestMapping("/all")
	public String showAll(ModelMap map) {
		List<WhUserType> whusertypes=service.getAllWhUserTypes();
		map.addAttribute("list", whusertypes);
		return "WhUserTypeData";
	}
	@RequestMapping("/delete")
	public String deleteEmp(@RequestParam("id") Integer id,ModelMap map)
	{
		//call service Layer delete
		service.deleteWhUserType(id);
		//construct finnal msg
		String msg="WhUserType'"+id+"'Deleted...";
		//get Remainng(new) data
		List<WhUserType> whusertypes=service.getAllWhUserTypes();
		map.addAttribute("message", msg);
		map.addAttribute("list", whusertypes);
		return "WhUserTypeData";
	}
	@RequestMapping("/edit")
	public String showEdit(@RequestParam("id") Integer id,ModelMap map){
		WhUserType whusertype=service.getOneWhUserTypeById(id);
		map.addAttribute("whUserType",whusertype);
		return "WhUserTypeEdit";
	}
	@RequestMapping(value="update",method=RequestMethod.POST)
	public String doUpdate(@ModelAttribute WhUserType WhUserType,ModelMap map) {
		service.updateWhUserType(WhUserType);
		List<WhUserType> whusertypes=service.getAllWhUserTypes();
		String message="WhUserType '"+WhUserType.getId()+"'Updated";
		map.addAttribute("message", message);
		map.addAttribute("list", whusertypes);
		return "WhUserTypeData";
	}
	/*
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
*/
}
