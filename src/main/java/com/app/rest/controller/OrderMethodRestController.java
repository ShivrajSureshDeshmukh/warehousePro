package com.app.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.OrderMethod;
import com.app.service.IOrderMethodService;

@RestController
@RequestMapping("/rest/order")
public class OrderMethodRestController {
	@Autowired
	private IOrderMethodService service;
	
	//getAll
	@GetMapping("/all")
	public ResponseEntity<?> getAll(){
	ResponseEntity<?> msg=null;
	List<OrderMethod> om=service.getAllOrderMethods();
	if(om==null||om.isEmpty())
	{
		msg=new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}else {
	msg=new ResponseEntity<List<OrderMethod>>(om,HttpStatus.OK);
	}
	return msg;
	}
	
	//2.getOneById
	@GetMapping("/get/{id}")
	public ResponseEntity<?> getOne(@PathVariable Integer id){
		ResponseEntity<?> msg=null;
		OrderMethod om=service.getOneOrderMethodById(id);
		if(om==null)
		{
			msg=new ResponseEntity<>("No Recored Found'"+id+"'DataBase",HttpStatus.NO_CONTENT);
		}else {
			msg=new ResponseEntity<OrderMethod>(om,HttpStatus.OK);
		}
		return msg;
	}
	
	//Delete By Id
	@DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteOne(){
		ResponseEntity<?> msg=null;
		return msg;
		
	}
}
