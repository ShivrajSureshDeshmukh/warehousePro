package com.app.service;

import java.util.List;

import com.app.model.ShipmentType;

public interface IShipmentTypeService {
	public Integer saveShipmentType(ShipmentType shipmenttype);
	public void updateShipmentType(ShipmentType shipmenttype);
	public void deleteShipmentType(Integer shipmentTypeId);
	public ShipmentType getOneShipmentTypeById(Integer shipmentTypeId);
	public List<ShipmentType> getAllShipmentTypes();
	public List<ShipmentType> getShipmentTypeByCode(String code);
}
