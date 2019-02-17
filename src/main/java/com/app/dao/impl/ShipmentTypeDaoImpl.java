package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IShipmentTypeDao;
import com.app.model.ShipmentType;
@Repository
public class ShipmentTypeDaoImpl implements IShipmentTypeDao {
	@Autowired
	private HibernateTemplate ht;
	
	@Override
	public Integer saveShipmentType(ShipmentType shipmenttype) {
		// TODO Auto-generated method stub
		return (Integer)ht.save(shipmenttype);
	}

	@Override
	public void updateShipmentType(ShipmentType shipmenttype) {
		ht.update(shipmenttype);
	}

	@Override
	public void deleteShipmentType(Integer shipmentTypeId) {
		ShipmentType shipmenttype=new ShipmentType();
		shipmenttype.setId(shipmentTypeId);
		ht.delete(shipmenttype);
	}

	@Override
	public ShipmentType getOneShipmentTypeById(Integer shipmentTypeId) {
		return ht.get(ShipmentType.class, shipmentTypeId);
	}

	@Override
	public List<ShipmentType> getAllShipmentTypes() {
		// TODO Auto-generated method stub
		return ht.loadAll(ShipmentType.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ShipmentType> getShipmentTypeByCode(String code) {
		String hql="from "+ShipmentType.class.getName()+" where enabled=?";
		// TODO Auto-generated method stub
		return (List<ShipmentType>) ht.find(hql, code);
	}

}
