package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.OrderMethod;

public class OrderMethodExcelView extends AbstractXlsxView  {
	@Override
	public void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//set fileName and Download 
		response.addHeader("Content-Disposition", "attachment;filename=OrderMethod.xlsx");
		//Create Sheet with name
		Sheet sheet=workbook.createSheet("OrderMethod");
		//Create Head
		setHead(sheet);
		@SuppressWarnings("unchecked")
		List<OrderMethod> ordermethods=(List<OrderMethod>)model.get("ordermethods");
		//Create Body
		setBody(sheet, ordermethods);
		
	}
	private void setHead(Sheet sheet) {
		Row row=sheet.createRow(0);
		//add heading columns
		row.createCell(0).setCellValue("ORDER ID");
		row.createCell(1).setCellValue("ORDER MODE");
		row.createCell(2).setCellValue("ORDER CODE");
		row.createCell(3).setCellValue("ORDER METHOD");
		row.createCell(4).setCellValue("ORDER ACCEPT");
		row.createCell(5).setCellValue("DESCRIPTION");
		
		}
	private void setBody(Sheet sheet, List<OrderMethod> ordermethods) {
        int num=1;  
       //add DB to data to table
		for(OrderMethod o:ordermethods) {
		Row row=sheet.createRow(num++);
		row.createCell(0).setCellValue(o.getId().toString());
		row.createCell(1).setCellValue(o.getMode());
		row.createCell(2).setCellValue(o.getCode());
		row.createCell(3).setCellValue(o.getMethod());
		row.createCell(4).setCellValue(o.getAccept().toString());
		row.createCell(5).setCellValue(o.getDsc());
		
		}
	}


}
