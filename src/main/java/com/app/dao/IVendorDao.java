package com.app.dao;

import java.util.List;

import com.app.model.Vendor;

public interface IVendorDao {
	public Integer saveVendor(Vendor vendor);
	public void updateVendor(Vendor vendor);
	public void deleteVendor(Integer vendorId);
	public Vendor getOneVendorById(Integer vendorId);
	public List<Vendor> getAllVendors();
	
}
