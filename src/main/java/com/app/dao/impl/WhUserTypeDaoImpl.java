package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IWhUserTypeDao;
import com.app.model.WhUserType;
@Repository
public class WhUserTypeDaoImpl implements IWhUserTypeDao {

	@Autowired
	private HibernateTemplate ht;
	@Override
	public Integer saveWhUserType(WhUserType whusertype) {
		// TODO Auto-generated method stub
		return (Integer)ht.save(whusertype);
	}

	@Override
	public void updateWhUserType(WhUserType whusertype) {
		ht.update(whusertype);
	}

	@Override
	public void deleteWhUserType(Integer whUserTypeId) {
		WhUserType whusertype=new WhUserType();
		whusertype.setId(whUserTypeId);
		ht.delete(whusertype);
	}

	@Override
	public WhUserType getOneWhUserTypeById(Integer whUserTypeId) {
		return ht.get(WhUserType.class, whUserTypeId);
	}

	@Override
	public List<WhUserType> getAllWhUserTypes() {
		return ht.loadAll(WhUserType.class);
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<WhUserType> getWhUserTypesByType(String type) {
		String hql=" from "+WhUserType.class.getName()+" where type=?";
		List<WhUserType> users=(List<WhUserType>) ht.find(hql, type);
		return users;
	}

}
