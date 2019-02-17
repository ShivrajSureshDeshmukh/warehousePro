package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.Customer;

public class CustomerExcelView extends AbstractXlsxView {

	@Override
	public void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//set fileName and Download 
		response.addHeader("Content-Disposition", "attachment;filename=Customer.xlsx");
		//Create Sheet with name
		Sheet sheet=workbook.createSheet("Customer");
		//Create Head
		setHead(sheet);
		@SuppressWarnings("unchecked")
		List<Customer> customers=(List<Customer>)model.get("customers");
		//Create Body
		setBody(sheet, customers);
		
	}
	private void setHead(Sheet sheet) {
		Row row=sheet.createRow(0);
		//add heading columns
		row.createCell(0).setCellValue("CUSTOMER ID");
		row.createCell(1).setCellValue("CODE");
		row.createCell(2).setCellValue("ADDRESS");
		row.createCell(3).setCellValue("LOCATION");
		row.createCell(4).setCellValue("ENABLED");
		row.createCell(5).setCellValue("EMAIL");
		row.createCell(6).setCellValue("CONTACT");
		
		}
	private void setBody(Sheet sheet, List<Customer> customers) {
        int num=1;  
       //add DB to data to table
		for(Customer c:customers) {
		Row row=sheet.createRow(num++);
		row.createCell(0).setCellValue(c.getCustId().toString());
		row.createCell(1).setCellValue(c.getCustCode());
		row.createCell(2).setCellValue(c.getCustAddr());
		row.createCell(3).setCellValue(c.getCustLocs().toString());
		row.createCell(4).setCellValue(c.getCustEnabled());
		row.createCell(5).setCellValue(c.getCustEmail());
		row.createCell(6).setCellValue(c.getCustContact());
		
		}
	}
}
