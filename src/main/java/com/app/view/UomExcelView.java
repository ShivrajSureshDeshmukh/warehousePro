package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.Uom;

public class UomExcelView extends AbstractXlsxView {

	@Override
	public void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//set fileName and Download 
		response.addHeader("Content-Disposition", "attachment;filename=Uom.xlsx");
		//Create Sheet with name
		Sheet sheet=workbook.createSheet("UOM");
		//Create Head
		setHead(sheet);
		@SuppressWarnings("unchecked")
		List<Uom> uoms=(List<Uom>)model.get("uoms");
		//Create Body
		setBody(sheet, uoms);
		
	}
	private void setHead(Sheet sheet) {
		Row row=sheet.createRow(0);
		//add heading columns
		row.createCell(0).setCellValue("UOM_ID");
		row.createCell(1).setCellValue("UOM_TYPE");
		row.createCell(2).setCellValue("UOM_MODEL");
		row.createCell(3).setCellValue("DESCRIPTION");
		}
	private void setBody(Sheet sheet, List<Uom> uoms) {
        int num=1;  
       //add DB to data to table
		for(Uom e:uoms) {
		Row row=sheet.createRow(num++);
		row.createCell(0).setCellValue(e.getId());
		row.createCell(1).setCellValue(e.getType());
		row.createCell(2).setCellValue(e.getModel());
		row.createCell(3).setCellValue(e.getDsc());
		}
	}
}
