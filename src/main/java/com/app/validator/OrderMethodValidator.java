package com.app.validator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.OrderMethod;

@Component
public class OrderMethodValidator implements  Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return OrderMethod.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		OrderMethod orderMethod=(OrderMethod)target;

		if(orderMethod.getMode()==null || orderMethod.getMode().isEmpty()){
			errors.rejectValue("mode", null, "Please choose One Mode");
		}
		if(!Pattern.compile("[A-Z]{4,10}").matcher(orderMethod.getCode()).matches()){
			errors.rejectValue("code", null, "Please enter valid Model(4 to 10 Uppercase only)");
		}
		if("".equals(orderMethod.getMethod()))
				{
				errors.rejectValue("method", null, "Please select Order Method ");
				}
		if(orderMethod.getAccept()==null||orderMethod.getAccept().isEmpty())
		{
			errors.rejectValue("accept", null, "Please choose order Accept");
		}
		
		if(!Pattern.compile("[A-Za-z0-9\\s\\.\\,\\_]{10,200}").matcher(orderMethod.getDsc()).matches())
		{
			errors.rejectValue("dsc", null, "Please enter description.[10 to 200 chars]");
		}		
	}

}
