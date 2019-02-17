package com.app.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.Customer;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class CustomerPdfView extends AbstractPdfView {
	@Override
	public void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//set fileName and Download
		response.addHeader("Content-Disposition", "attachment;filename=Customer.pdf");
		//Create Element
		Paragraph p=new Paragraph("Customer Data");
		p.setAlignment(Element.ALIGN_CENTER); 

		//add to document
		document.add(p);
		@SuppressWarnings("unchecked")
		//read data from map
		List<Customer> customers=(List<Customer>)model.get("customers");
		//create table
		PdfPTable t=new PdfPTable(7);
		t.setSpacingBefore(5); 
		PdfPCell cell = new PdfPCell();
		cell.setBorder(PdfPCell.NO_BORDER); 
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell.setColspan(7);
		t.addCell(cell);
		// t.setTotalWidth(450);
		 //t.setLockedWidth(true); 
		//add heading columns
		t.addCell("CUST_ID");
		t.addCell("CODE");
		t.addCell("ADDRESS");
		t.addCell("LOCATION");
		t.addCell("ENABLED");
		t.addCell("EMAIL");	
		t.addCell("CONTACT");
		
		//add DB to data to table
		for(Customer c:customers) {
			t.addCell(c.getCustId().toString());
			t.addCell(c.getCustCode());
			t.addCell(c.getCustAddr());
			t.addCell(c.getCustLocs().toString());
			t.addCell(c.getCustEnabled());
			t.addCell(c.getCustEmail());
			t.addCell(c.getCustContact());

		}
		//add to document
		document.add(t);
		//add date
		Paragraph p1=new Paragraph(new Date().toString());
		p1.setAlignment(Element.ALIGN_RIGHT); 

		document.add(p1);
	}


}
