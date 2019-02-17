package com.app.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.ShipmentType;
import com.app.service.IShipmentTypeService;

@RestController
@RequestMapping("/rest/shipment")
public class ShipmentTypeRestController {
	@Autowired
	private IShipmentTypeService service;
	
	@GetMapping("/all")
	public ResponseEntity<?> getAll()
	{
		ResponseEntity<?> re=null;
		List<ShipmentType> shipmentType=service.getAllShipmentTypes();
		///String msg=null;
		if(shipmentType==null) {
			
			re=new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}else
		{
			re=new ResponseEntity<List<ShipmentType>>(shipmentType,HttpStatus.OK);
		}
		//String body=""
		//re=new ResponseEntity<String>("")
		
		
		return re;
	}
	

}
