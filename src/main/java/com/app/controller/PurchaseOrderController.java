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

import com.app.model.PurchaseOrder;
import com.app.model.ShipmentType;
import com.app.model.WhUserType;
import com.app.service.IPurchaseOrderService;
import com.app.service.IShipmentTypeService;
import com.app.service.IWhUserTypeService;
import com.app.validator.PurchaseOrderValidator;
@Controller
@RequestMapping("/purchaseorder")
public class PurchaseOrderController {
	@Autowired
	private IPurchaseOrderService service;
	@Autowired
	private IWhUserTypeService userservice;
	@Autowired
	private IShipmentTypeService shipmentservice;
	@Autowired
	private PurchaseOrderValidator validator;

	@RequestMapping("/create")
	public String showData(ModelMap map) {
		//Vendor 
		List<WhUserType> vendors=userservice.getWhUserTypesByType("Vendor");
		map.addAttribute("vendors", vendors);
		//ShipmentType
		List<ShipmentType> shipment=shipmentservice.getShipmentTypeByCode("Yes");
		map.addAttribute("shipment", shipment);

		map.addAttribute("purchaseOrder", new PurchaseOrder());
		return "PurchaseOrderCreate";
	}

	@RequestMapping(value="insert",method=RequestMethod.POST)
	public String createPurchaseOrder(@ModelAttribute PurchaseOrder purchaseOrder,Errors errors,ModelMap map) {

		validator.validate(purchaseOrder, errors);
		if(!errors.hasErrors()) {

			//Vendor 
			List<WhUserType> vendors=userservice.getWhUserTypesByType("Vendor");
			map.addAttribute("vendors", vendors);
			//ShipmentType
			List<ShipmentType> shipment=shipmentservice.getShipmentTypeByCode("Yes");
			map.addAttribute("shipment", shipment);

			int purchaseorderId=service.savePurchaseOrder(purchaseOrder);
			String message="PurchaseOrder is '"+purchaseorderId+"'Created...";
			map.addAttribute("message", message);
			map.addAttribute("purchaseOrder", new PurchaseOrder());
		}

		return "PurchaseOrderCreate";
	}
	@RequestMapping("/all")
	public String showAll(ModelMap map) {
		List<PurchaseOrder> purchaseorders=service.getAllPurchaseOrders();
		map.addAttribute("list", purchaseorders);
		return "PurchaseOrderData";
	}
	@RequestMapping("/delete")
	public String deleteEmp(@RequestParam("id") Integer id,ModelMap map)
	{
		//call service Layer delete
		service.deletePurchaseOrder(id);
		//construct final message
		String msg="PurchaseOrder'"+id+"'Deleted...";
		//get Remaining (new) data
		List<PurchaseOrder> purchaseorders=service.getAllPurchaseOrders();
		map.addAttribute("message", msg);
		map.addAttribute("list", purchaseorders);
		return "PurchaseOrderData";
	}
	@RequestMapping("/edit")
	public String showEdit(@RequestParam("id")Integer id,ModelMap map){

		PurchaseOrder purchaseOrder=service.getOnePurchaseOrderById(id);

		//Vendor 
		List<WhUserType> vendors=userservice.getWhUserTypesByType("Vendor");
		map.addAttribute("vendors", vendors);
		//ShipmentType
		List<ShipmentType> shipment=shipmentservice.getShipmentTypeByCode("Yes");
		map.addAttribute("shipment", shipment);

		map.addAttribute("purchaseOrder",purchaseOrder);
		return "PurchaseOrderEdit";
	}
	@RequestMapping(value="update",method=RequestMethod.POST)
	public String doUpdate(@ModelAttribute PurchaseOrder purchaseOrder,ModelMap map) {
		service.updatePurchaseOrder(purchaseOrder);
		List<PurchaseOrder> purchaseorders=service.getAllPurchaseOrders();
		String msg="PurchaseOrder '"+purchaseOrder.getPurchaseId()+"'Updated";
		map.addAttribute("message", msg);
		map.addAttribute("list", purchaseorders);
		return "PurchaseOrderData";
	}
	/*
	//Export Data to Excel
	@RequestMapping("/excel")
	public ModelAndView showExcel() {
		//fetch data from Database
		List<PurchaseOrder> purchaseorders=service.getAllPurchaseOrders();
		//Create ModelAndView
		ModelAndView m=new ModelAndView();
		//provide view class name
		m.setView(new PurchaseOrderExcelView());
		//provide data to it
		m.addObject("purchaseorders", purchaseorders);
		return m;
	}
	//Export Data to PDF
	@RequestMapping("/pdf")
	public ModelAndView showPdf() {
		//fetch data from Database
		List<PurchaseOrder> purchaseorders=service.getAllPurchaseOrders();
		//Create ModelAndView	
		ModelAndView m=new ModelAndView();
		//provide view class name
		m.setView(new PurchaseOrderPdfView());
		//provide data to it
		m.addObject("purchaseorders", purchaseorders);
		return m;
		//return null;
	}
	 */
}

