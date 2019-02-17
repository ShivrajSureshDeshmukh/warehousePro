package com.app.validator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.Item;
@Component
public class ItemValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Item.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		Item item=(Item)target;
		if(!Pattern.compile("[A-Z0-9]{4,10}").matcher(item.getItemCode()).matches())
		{
			errors.rejectValue("itemCode", null , "Enter valid code[4 to 10 Uppercase Only]");
		}
		if(item.getItemWidth()<=0.0||item.getItemLength()<=0.0||item.getItemHight()<=0.0)
		{
			errors.rejectValue("itemWidth", null , "Enter valid Item Dimensions.");
		}
		if(!Pattern.compile("[1-9][0-9\\.]{1,8}").matcher(item.getBaseCost()).matches())
		{
			errors.rejectValue("baseCost", null, "Enter valid Cost[1 to 8 range]");
		}
		if("".equals(item.getBaseCurrency()))
		{
			errors.rejectValue("baseCurrency", null, "Select Base Currency.");
		}
		if(item.getUom()==null||item.getUom().getId()==null)	
		{
			errors.rejectValue("uom", null, "Select Item UOM.");
		}
		if(item.getSaleType()==null||item.getSaleType().getId()==null)
		{
			errors.rejectValue("saleType", null, "Please select Sale Type .");
		}
		if(item.getPurchaseType()==null||item.getPurchaseType().getId()==null)
		{
			errors.rejectValue("purchaseType", null, "Please select Purchase Type.");
		}
		if(item.getVendorType()==null||item.getVendorType().isEmpty())
		{
			errors.rejectValue("vendorType", null, "Please select vendors .");
		}
		if(item.getCustomerType()==null||item.getCustomerType().isEmpty())
		{
			errors.rejectValue("customerType", null, "Please select Customers.");
		}
		if(!Pattern.compile("[A-Za-z0-9\\s\\.\\,\\_]{10,200}").matcher(item.getDsc()).matches())
		{
			errors.rejectValue("dsc", null, "Please enter description.[10 to 200 chars]");
		}
	}
}
