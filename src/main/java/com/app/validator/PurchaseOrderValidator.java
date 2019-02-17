package com.app.validator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.PurchaseOrder;
@Component
public class PurchaseOrderValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return PurchaseOrder.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		PurchaseOrder po=(PurchaseOrder)target;
		if(!Pattern.compile("[A-Z0-9]{4,10}").matcher(po.getPurchaseCode()).matches())
		{
			errors.rejectValue("purchaseCode", null , "Enter valid code[4 to 10 Uppercase Only]");
		}
		if(po.getShipmentCode()==null||po.getShipmentCode().getId()==null) {
			errors.rejectValue("shipmenCode", null, "Select Shipment type");
		}
		if(!Pattern.compile("[A-Z0-9]{4}[\\-][A-Z0-9]{4}[\\-][A-Z0-9]{4}").matcher(po.getPurchaseRef()).matches())
		{
			errors.rejectValue("purchaseRef", null, "Enter valid Reference[xxxx-xxxx-xxxx]Uppercase Only");
		}
		if(po.getPurchaseQuality()==null||"".equals(po.getPurchaseQuality())) {
			errors.rejectValue("purchaseQuality", null, "Please Choose one");
		}
		if(!Pattern.compile("[A-Za-z0-9\\s\\.\\,\\_]{10,200}").matcher(po.getDsc()).matches())
		{
			errors.rejectValue("dsc", null, "Please enter description.[10 to 200 chars]");
		}

		
	}

}
