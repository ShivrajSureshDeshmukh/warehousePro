package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IShipmentTypeDao;
import com.app.model.ShipmentType;
import com.app.service.IShipmentTypeService;
@Service
public class ShipmentTypeServiceImpl implements IShipmentTypeService {

	@Autowired
	private IShipmentTypeDao dao;
	@Override
	@Transactional
	public Integer saveShipmentType(ShipmentType shipmenttype) {
		// TODO Auto-generated method stub
		return dao.saveShipmentType(shipmenttype);
	}

	@Override
	@Transactional
	public void updateShipmentType(ShipmentType shipmenttype) {
		// TODO Auto-generated method stub
		dao.updateShipmentType(shipmenttype);
	}

	@Override
	@Transactional
	public void deleteShipmentType(Integer shipmentTypeId) {
		// TODO Auto-generated method stub
		dao.deleteShipmentType(shipmentTypeId);
	}

	@Override
	@Transactional(readOnly=true)
	public ShipmentType getOneShipmentTypeById(Integer shipmentTypeId) {
		// TODO Auto-generated method stub
		return dao.getOneShipmentTypeById(shipmentTypeId);
	}

	@Override
	@Transactional(readOnly=true)
	public List<ShipmentType> getAllShipmentTypes() {
		// TODO Auto-generated method stub
		return dao.getAllShipmentTypes();
	}

	@Transactional(readOnly=true)
	public List<ShipmentType> getShipmentTypeByCode(String code) {
		return dao.getShipmentTypeByCode(code);
	}
	
}
