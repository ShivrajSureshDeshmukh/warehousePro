package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.Vendor;

public class VendorExcelView extends AbstractXlsxView {

	@Override
	public void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//set fileName and Download 
		response.addHeader("Content-Disposition", "attachment;filename=Vendor.xlsx");
		//Create Sheet with name
		Sheet sheet=workbook.createSheet("VENDOR");
		//Create Head
		setHead(sheet);
		@SuppressWarnings("unchecked")
		List<Vendor> vendors=(List<Vendor>)model.get("vendors");
		//Create Body
		setBody(sheet, vendors);
		
	}
	private void setHead(Sheet sheet) {
		Row row=sheet.createRow(0);
		//add heading columns
		row.createCell(0).setCellValue("VENDOR_ID");
		row.createCell(1).setCellValue("VENDOR_NAME");
		row.createCell(2).setCellValue("VENDOR_CODE");
		row.createCell(3).setCellValue("VENDOR_DESIGNATION");
		row.createCell(4).setCellValue("VENDOR_PRESERVE");
		
		}
	private void setBody(Sheet sheet, List<Vendor> vendors) {
        int num=1;  
       //add DB to data to table
		for(Vendor e:vendors) {
		Row row=sheet.createRow(num++);
		row.createCell(0).setCellValue(e.getVenId());
		row.createCell(1).setCellValue(e.getVenName());
		row.createCell(2).setCellValue(e.getVenCode());
		row.createCell(3).setCellValue(e.getVenDesg());
		row.createCell(4).setCellValue(e.getVenPreserve().toString());

		}
	}
}
