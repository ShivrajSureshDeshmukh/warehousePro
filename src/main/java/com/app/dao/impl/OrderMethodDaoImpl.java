package com.app.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IOrderMethodDao;
import com.app.model.OrderMethod;
@Repository
public class OrderMethodDaoImpl implements IOrderMethodDao {

	@Autowired
	private HibernateTemplate ht;
	@Override
	public Integer saveOrderMethod(OrderMethod ordermethod) {
		return (Integer)ht.save(ordermethod);
	}

	@Override
	public void updateOrderMethod(OrderMethod ordermethod) {
		ht.update(ordermethod);
		
	}

	@Override
	public void deleteOrderMethod(Integer orderMethodId) {
		OrderMethod ordermethod=new OrderMethod();
		ordermethod.setId(orderMethodId);
		ht.delete(ordermethod);
		
	}

	@Override
	public OrderMethod getOneOrderMethodById(Integer orderMethodId) {
		return ht.get(OrderMethod.class, orderMethodId);
	}

	@Override
	public List<OrderMethod> getAllOrderMethods() {
		return ht.loadAll(OrderMethod.class);
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<OrderMethod> getOrderMethodsByMode(String mode) {
		String hql=" from "+OrderMethod.class.getName()
				+" where mode=?";
		//DetachedCriteria.forClass(OrderMethod.class).add(Restrictions.eq(mode, mode));
		return (List<OrderMethod>) ht.find(hql,mode);
	}
	}
