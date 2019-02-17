package com.app.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.Vendor;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class VendorPdfView extends AbstractPdfView {
	@Override
	public void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//set fileName and Download
		response.addHeader("Content-Disposition", "attachment;filename=Vendor.pdf");
		//Create Element
		Paragraph p=new Paragraph("Vendor Data");
		//add to document
		document.add(p);
		
		@SuppressWarnings("unchecked")
		//read data from map
		List<Vendor> vendors=(List<Vendor>)model.get("vendors");
		//create table
		PdfPTable t=new PdfPTable(5);
		//add heading columns
		t.addCell("VENDOR_ID");
		t.addCell("VENDOR_NAME");
		t.addCell("VENDOR_CODE");
		t.addCell("VENDOR_DESIGNATION");
		t.addCell("VENDOR_PRESERVE");
		//add DB to data to table
		for(Vendor e:vendors) {
			t.addCell(e.getVenId().toString());
			t.addCell(e.getVenName());
			t.addCell(e.getVenCode());
			t.addCell(e.getVenDesg());
			t.addCell(e.getVenPreserve().toString());
		}
		//add to document
		document.add(t);
		//add date
		document.add(new Paragraph(new Date().toString()));
	}


}
