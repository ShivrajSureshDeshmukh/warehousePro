package com.app.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.OrderMethod;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class OrderMethodPdfView extends AbstractPdfView {
	@Override
	public void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//set fileName and Download
		response.addHeader("Content-Disposition", "attachment;filename=OrderMethod.pdf");
		//Create Element
		Paragraph p=new Paragraph("OrderMethod Data");
		p.setAlignment(Element.ALIGN_CENTER); 

		//add to document
		document.add(p);
		@SuppressWarnings("unchecked")
		//read data from map
		List<OrderMethod> ordermethods=(List<OrderMethod>)model.get("ordermethods");
		//create table
		PdfPTable t=new PdfPTable(6);
		t.setSpacingBefore(5); 
		PdfPCell cell = new PdfPCell();
		cell.setBorder(PdfPCell.NO_BORDER); 
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell.setColspan(6);
		t.addCell(cell);
		// t.setTotalWidth(450);
		 //t.setLockedWidth(true); 
		//add heading columns
		t.addCell("ORDER ID");
		t.addCell("MODE");
		t.addCell("CODE");
		t.addCell("METHOD");
		t.addCell("ACCEPT");
		t.addCell("DESCRIPTION");	
		//add DB to data to table
		for(OrderMethod o:ordermethods) {
			t.addCell(o.getId().toString());
			t.addCell(o.getMode());
			t.addCell(o.getCode());
			t.addCell(o.getMethod());
			t.addCell(o.getAccept().toString());
			t.addCell(o.getDsc());

		}
		//add to document
		document.add(t);
		//add date
		Paragraph p1=new Paragraph(new Date().toString());
		p1.setAlignment(Element.ALIGN_RIGHT); 
		document.add(p1);
	}


}
