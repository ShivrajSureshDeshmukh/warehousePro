package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IWhUserTypeDao;
import com.app.model.WhUserType;
import com.app.service.IWhUserTypeService;
@Service
public class WhUserTypeServiceImpl implements IWhUserTypeService {

	@Autowired
	private IWhUserTypeDao dao;
	@Override
	@Transactional
	public Integer saveWhUserType(WhUserType whusertype) {
		// TODO Auto-generated method stu
		return dao.saveWhUserType(whusertype);
	}

	@Override
	@Transactional
	public void updateWhUserType(WhUserType whusertype) {
		dao.updateWhUserType(whusertype);
	}

	@Override
	@Transactional
	public void deleteWhUserType(Integer whUserTypeId) {
		dao.deleteWhUserType(whUserTypeId);
	}

	@Override
	@Transactional(readOnly=true)
	public WhUserType getOneWhUserTypeById(Integer whUserTypeId) {
		return dao.getOneWhUserTypeById(whUserTypeId);
	}

	@Override
	@Transactional(readOnly=true)
	public List<WhUserType> getAllWhUserTypes() {
		return dao.getAllWhUserTypes();
	}

	@Override
	@Transactional(readOnly=true)
	public List<WhUserType> getWhUserTypesByType(String type) {
		return dao.getWhUserTypesByType(type);
	}

}
