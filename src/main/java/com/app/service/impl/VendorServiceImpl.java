package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IVendorDao;
import com.app.model.Vendor;
import com.app.service.IVendorService;
@Service
public class VendorServiceImpl implements IVendorService {

	@Autowired
	private IVendorDao dao;
	@Override
	@Transactional
	public Integer saveVendor(Vendor vendor) {
		return dao.saveVendor(vendor);
	}

	@Override
	@Transactional
	public void updateVendor(Vendor vendor) {
		dao.updateVendor(vendor);
	}

	@Override
	@Transactional
	public void deleteVendor(Integer vendorId) {
		dao.deleteVendor(vendorId);
	}

	@Override
	@Transactional(readOnly=true)
	public Vendor getOneVendorById(Integer vendorId) {
		return dao.getOneVendorById(vendorId);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Vendor> getAllVendors() {
		return dao.getAllVendors();
	}

}
