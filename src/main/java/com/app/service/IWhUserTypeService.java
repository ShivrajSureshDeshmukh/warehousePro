package com.app.service;

import java.util.List;

import com.app.model.WhUserType;

public interface IWhUserTypeService {
	public Integer saveWhUserType(WhUserType whusertype);
	public void updateWhUserType(WhUserType whusertype);
	public void deleteWhUserType(Integer whUserTypeId);
	public WhUserType getOneWhUserTypeById(Integer whUserTypeId);
	public List<WhUserType> getAllWhUserTypes();
	public List<WhUserType> getWhUserTypesByType(String type);
	


}
