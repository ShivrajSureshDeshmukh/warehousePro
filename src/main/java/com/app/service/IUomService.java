package com.app.service;

import java.util.List;

import com.app.model.Uom;

public interface IUomService {
	public Integer saveUom(Uom uom);
	public void updateUom(Uom uom);
	public void deleteUom(Integer uomId);
	public Uom getOneUomById(Integer uomId);
	public List<Uom> getAllUoms();
	public boolean isUomModelExist(String uomModel);
	public boolean isUomConnectedWithItem(Integer id);
	public List<Object[]> getUomTypeCount();


}