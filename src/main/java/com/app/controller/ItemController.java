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

import com.app.model.Item;
import com.app.model.OrderMethod;
import com.app.model.Uom;
import com.app.model.WhUserType;
import com.app.service.IItemService;
import com.app.service.IOrderMethodService;
import com.app.service.IUomService;
import com.app.service.IWhUserTypeService;
import com.app.util.ItemUtil;
import com.app.validator.ItemValidator;
@Controller
@RequestMapping("/item")
public class ItemController {
	@Autowired
	private IItemService service;
	@Autowired
	private ItemValidator validator;
	@Autowired
	private ItemUtil util;

	@RequestMapping("/create")
	public String showData(ModelMap map) {
		map.addAttribute("item", new Item());
		util.addUiComponents(map);
		return "ItemCreate";
	}

	@RequestMapping(value="insert",method=RequestMethod.POST)
	public String createItem(@ModelAttribute Item item,Errors errors,ModelMap map) {

		validator.validate(item, errors);
		if(!errors.hasErrors()) {
			int itemId=service.saveItem(item);
			String message="Item is '"+itemId+"'Created...";
			map.addAttribute("message", message);
		}
		util.addUiComponents(map);
		
		return "ItemCreate";
	}
	@RequestMapping("/all")
	public String showAll(ModelMap map) {
		List<Item> items=service.getAllItems();
		map.addAttribute("list", items);
		return "ItemData";
	}
	@RequestMapping("/delete")
	public String deleteEmp(@RequestParam("id") Integer id,ModelMap map)
	{
		//call service Layer delete
		service.deleteItem(id);
		//construct final message
		String msg="Item'"+id+"'Deleted...";
		//get Remaining(new) data
		List<Item> items=service.getAllItems();
		map.addAttribute("message", msg);
		map.addAttribute("list", items);
		return "ItemData";
	}
	@RequestMapping("/edit")
	public String showEdit(@RequestParam("id") Integer id,ModelMap map){
		util.addUiComponents(map);
		Item item=service.getOneItemById(id);
		map.addAttribute("item",item);
		return "ItemEdit";
	}
	@RequestMapping(value="update",method=RequestMethod.POST)
	public String doUpdate(@ModelAttribute Item item,ModelMap map) {
		service.updateItem(item);
		List<Item> items=service.getAllItems();
		String msg="Item '"+item.getItemId()+"'Updated";
		map.addAttribute("message", msg);
		map.addAttribute("list", items);
		map.addAttribute("item", new Item());

		return "ItemData";
	}
	/*	//Export Data to Excel
	@RequestMapping("/excel")
	public ModelAndView showExcel() {
		//fetch data from Database
		List<Item> items=service.getAllItems();
		//Create ModelAndView
		ModelAndView m=new ModelAndView();
		//provide view class name
		m.setView(new ItemExcelView());
		//provide data to it
		m.addObject("items", items);
		return m;
	}
	//Export Data to PDF
	@RequestMapping("/pdf")
	public ModelAndView showPdf() {
		//fetch data from Database
		List<Item> items=service.getAllItems();
		//Create ModelAndView
		ModelAndView m=new ModelAndView();
		//provide view class name
		m.setView(new ItemPdfView());
		//provide data to it
		m.addObject("items", items);
		return m;
		//return null;
	}
	 */
	
}
