package com.app.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IUomDao;
import com.app.model.Item;
import com.app.model.Uom;
@Repository
public class UomDaoImpl implements IUomDao {

	@Autowired
	private HibernateTemplate ht;
	@Override
	public Integer saveUom(Uom uom) {
		return (Integer)ht.save(uom);
	}

	@Override
	public void updateUom(Uom uom) {
		ht.update(uom);
	}

	@Override
	public void deleteUom(Integer uomId) {
		Uom uom=new Uom();
		uom.setId(uomId);
		ht.delete(uom);
	}

	@Override
	public Uom getOneUomById(Integer uomId) {
		// TODO Auto-generated method stub
		return ht.get(Uom.class, uomId);
	}

	@Override
	public List<Uom> getAllUoms() {
		// TODO Auto-generated method stub
		return ht.loadAll(Uom.class);
	}
	@Override
	public boolean isUomModelExist(String uomModel) {
		@SuppressWarnings("unchecked")
		List<Long> rowCount=(List<Long>)
		ht.findByCriteria(
				DetachedCriteria.forClass(Uom.class)
				.setProjection(Projections.rowCount())
				.add(Restrictions.eq("model", uomModel)));
		return rowCount.get(0)!=0?true:false;
	}

	@Override
	public boolean isUomConnectedWithItem(Integer id) {

		@SuppressWarnings("unchecked")
		List<Long> rowCount=(List<Long>)
		ht.findByCriteria(
				DetachedCriteria.forClass(Item.class)
				.setProjection(Projections.rowCount())
				.add(Restrictions.eq("uom.id", id)));

		return rowCount.get(0)!=0?true:false;
	}
	
	@Override
	public List<Object[]> getUomTypeCount() {
		String hql=" select type, count(type) "
				+" from "+Uom.class.getName()
				+" group by type ";
		
		return (List<Object[]>) ht.find(hql);
	}

}
