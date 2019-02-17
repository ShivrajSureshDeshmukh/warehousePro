package com.app.controller;

import java.util.List;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateOptimisticLockingFailureException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.model.Uom;
import com.app.service.IUomService;
import com.app.util.UomUtil;
import com.app.validator.UomValidator;
import com.app.view.UomExcelView;
import com.app.view.UomPdfView;
@Controller
@RequestMapping("/uom")
public class UomController {
	@Autowired
	private IUomService service;
	@Autowired
	private UomValidator validator;
	//context for pie and bar chart 
	@Autowired
	private ServletContext context;
	// util for Pie and Bar chart
	@Autowired
	private UomUtil util;
	
	private static Logger log=Logger.getLogger(UomController.class);
	
	@RequestMapping("/create")
	public String showData(ModelMap map) {
		map.addAttribute("uom", new Uom());
		return "UomCreate";
	}
	
	@RequestMapping(value="insert",method=RequestMethod.POST)
	public String createUom(@ModelAttribute Uom uom,Errors errors,ModelMap map) {
		log.info(" Save Method started");
		validator.validate(uom, errors);
		int uomId;
		String message;
		if(!errors.hasErrors()) {
			try{
				log.info("Before save employee..");
		uomId=service.saveUom(uom);
		message="Uom is '"+uomId+"'Created...";
		map.addAttribute("message", message);
		log.debug("emp saved with id :"+uomId);
			}catch(Exception e){
			log.error(e); // log.fatal(e);
			}
		
		map.addAttribute("uom", new Uom());
		}
		return "UomCreate";
	}
	@RequestMapping("/all")
	public String showAll(ModelMap map) {
		List<Uom> uoms=service.getAllUoms();
		map.addAttribute("list", uoms);
		return "UomData";
	}
	@RequestMapping("/delete")
	public String deleteEmp(@RequestParam("id") Integer id,ModelMap map)
	{
		String msg;
		try {
			if(service.isUomConnectedWithItem(id))
			{
				msg="Uom can't be deleted, Its Link with Item ";
			}else {
		//call service Layer delete
		service.deleteUom(id);
		//construct final msg
		 msg="Uom'"+id+"'Deleted...";
		//get Remaining(new) data
		
			}
		}catch(HibernateOptimisticLockingFailureException e)
		{
			msg="Uom '"+id+"'is Not found";
		}
		map.addAttribute("message", msg);
		List<Uom> uoms=service.getAllUoms();
		map.addAttribute("list", uoms);
		return "UomData";
	}
	@RequestMapping("/edit")
	public String showEdit(@RequestParam("id") Integer id,ModelMap map){
		Uom uom=service.getOneUomById(id);
		map.addAttribute("uom",uom);
		return "UomEdit";
	}
	@RequestMapping(value="update",method=RequestMethod.POST)
	public String doUpdate(@ModelAttribute Uom Uom,ModelMap map) {
		service.updateUom(Uom);
		List<Uom> uoms=service.getAllUoms();
		String msg="Uom '"+Uom.getId()+"'Updated";
		map.addAttribute("message", msg);
		map.addAttribute("list", uoms);
		return "UomData";
	}
	//Export Data to Excel
	@RequestMapping("/excel")
	public ModelAndView showExcel() {
		//fetch data from DatabasFe
		List<Uom> uoms=service.getAllUoms();
		//Create ModelAndView
		ModelAndView m=new ModelAndView();
		//provide view class name
		m.setView(new UomExcelView());
		//provide data to it
		m.addObject("uoms", uoms);
		return m;
	}
	//Export Data to PDF
	@RequestMapping("/pdf")
	public ModelAndView showPdf() {
		//fetch data from Database
		List<Uom> uoms=service.getAllUoms();
		//Create ModelAndView
		ModelAndView m=new ModelAndView();
		//provide view class name
		m.setView(new UomPdfView());
		//provide data to it
		m.addObject("uoms", uoms);
		return m;
		//return null;
	}
	//PieChart report
	@RequestMapping("/pie")
	public String genrateChart() {
		
		String path=context.getRealPath("/");
		
		//System.out.println(path);
		List<Object[]> data=service.getUomTypeCount();
		util.genratePie(path, data);
		return "UomReport";
	}
	
}

