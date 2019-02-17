package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IItemDao;
import com.app.model.Item;
@Repository
public class ItemDaoImpl implements IItemDao {

	@Autowired
	private HibernateTemplate ht;
	@Override
	public Integer saveItem(Item item) {
		return (Integer)ht.save(item);
	}

	@Override
	public void updateItem(Item item) {
		ht.update(item);
	}

	@Override
	public void deleteItem(Integer itemId) {
		Item item=new Item();
		item.setItemId(itemId);
		ht.delete(item);
	}

	@Override
	public Item getOneItemById(Integer itemId) {
		// TODO Auto-generated method stub
		return ht.get(Item.class, itemId);
	}

	@Override
	public List<Item> getAllItems() {
		// TODO Auto-generated method stub
		return ht.loadAll(Item.class);
	}

}
