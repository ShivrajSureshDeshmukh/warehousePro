package com.app.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.WhUserType;
@Component
public class WhUserTypeValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return WhUserType.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		WhUserType whusertype=(WhUserType)target;
		if("".equals(whusertype.getType()))
		{
			errors.rejectValue("type", null , "Please choose one Type");
		}
		if("".equals(whusertype.getCode().trim()))
		{
			errors.rejectValue("code", null , "Please choose Code");
		}
	}

}
