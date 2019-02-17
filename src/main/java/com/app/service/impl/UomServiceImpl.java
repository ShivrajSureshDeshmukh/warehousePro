package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IUomDao;
import com.app.model.Uom;
import com.app.service.IUomService;
@Service
public class UomServiceImpl implements IUomService {

	@Autowired
	private IUomDao dao;
	@Override
	@Transactional
	public Integer saveUom(Uom uom) {
		return dao.saveUom(uom);
	}

	@Override
	@Transactional
	public void updateUom(Uom uom) {
		dao.updateUom(uom);
	}

	@Override
	@Transactional
	public void deleteUom(Integer uomId) {
		dao.deleteUom(uomId);
	}

	@Override
	@Transactional(readOnly=true)
	public Uom getOneUomById(Integer uomId) {
		return dao.getOneUomById(uomId);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Uom> getAllUoms() {
		return dao.getAllUoms();
	}

	@Transactional(readOnly=true)
	public boolean isUomModelExist(String uomModel) {
		return dao.isUomModelExist(uomModel);
	}

	@Transactional(readOnly=true)
	public boolean isUomConnectedWithItem(Integer id) {
		return dao.isUomConnectedWithItem(id);
	}

	@Transactional(readOnly=true)
	public List<Object[]> getUomTypeCount() {
		// TODO Auto-generated method stub
		return dao.getUomTypeCount();
	}
}
