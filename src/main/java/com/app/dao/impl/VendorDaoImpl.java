package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IVendorDao;
import com.app.model.Vendor;
@Repository
public class VendorDaoImpl implements IVendorDao {

	@Autowired
	private HibernateTemplate ht;
	@Override
	public Integer saveVendor(Vendor Vendor) {
		return (Integer)ht.save(Vendor);
	}

	@Override
	public void updateVendor(Vendor Vendor) {
		ht.update(Vendor);
	}

	@Override
	public void deleteVendor(Integer vendorId) {
		Vendor Vendor=new Vendor();
		Vendor.setVenId(vendorId);
		ht.delete(Vendor);
	}

	@Override
	public Vendor getOneVendorById(Integer vendorId) {
		// TODO Auto-generated method stub
		return ht.get(Vendor.class, vendorId);
	}

	@Override
	public List<Vendor> getAllVendors() {
		// TODO Auto-generated method stub
		return ht.loadAll(Vendor.class);
	}

}
