package com.app.validator;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.Uom;
import com.app.service.IUomService;
@Component
public class UomValidator implements Validator {

	@Autowired
	private IUomService service;
	@Override
	public boolean supports(Class<?> clazz) {
		return Uom.class.equals(clazz);
	}
	@Override
	public void validate(Object target, Errors errors) {	
		Uom uom=(Uom)target;
		if("".equals(uom.getType())){
			errors.rejectValue("type", null, "Please choose one Type");
		}
		if(!Pattern.compile("[A-Z]{4,10}").matcher(uom.getModel()).matches()){
			errors.rejectValue("model", null, "Please enter valid Model(4 to 10 Uppercase only)");
		}else if(service.isUomModelExist(uom.getModel()))
		{
			errors.rejectValue("model", null, "Already Exist, Choose other");
		}
		if(!Pattern.compile("[A-Za-z0-9\\s\\.\\,\\_]{10,200}").matcher(uom.getDsc()).matches())
		{
			errors.rejectValue("dsc", null, "Please enter description.[10 to 200 chars]");
		}
	}
}
