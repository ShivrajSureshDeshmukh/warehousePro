package com.app.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;

import com.app.model.OrderMethod;
import com.app.model.Uom;
import com.app.model.WhUserType;
import com.app.service.IOrderMethodService;
import com.app.service.IUomService;
import com.app.service.IWhUserTypeService;
@Component	
public class ItemUtil {
	@Autowired
	private IUomService uomservice;
	@Autowired
	private IOrderMethodService omservice;
	@Autowired
	private IWhUserTypeService whservice;

	public void addUiComponents(ModelMap map) {

		//Uom model
		List<Uom> uoms=uomservice.getAllUoms();
		map.addAttribute("uoms", uoms);
		//Order Method Sale mode
		List<OrderMethod> sales=omservice.getOrderMethodsByMode("Sale");
		map.addAttribute("sales",sales );
		//Order Method Purchase mode
		List<OrderMethod> purchases=omservice.getOrderMethodsByMode("Purchase");
		map.addAttribute("purchases", purchases);
		//WhUserType Vendor
		List<WhUserType> vendors=whservice.getWhUserTypesByType("Vendor");
		map.addAttribute("vendors", vendors);
		//WhUserType Customer
		List<WhUserType> customers=whservice.getWhUserTypesByType("Consumer");
		map.addAttribute("customers", customers);
	}

}
