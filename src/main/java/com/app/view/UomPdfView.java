package com.app.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.Uom;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class UomPdfView extends AbstractPdfView {
	@Override
	public void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//set fileName and Download
		response.addHeader("Content-Disposition", "attachment;filename=Uom.pdf");
		//Create Element
		Paragraph p=new Paragraph("Uom Data");
		p.setAlignment(Element.ALIGN_CENTER); 
		//add to document
		document.add(p);
		
		@SuppressWarnings("unchecked")
		//read data from map
		List<Uom> uoms=(List<Uom>)model.get("uoms");
		//create table
		PdfPTable t=new PdfPTable(4);
		t.setSpacingBefore(5); 
		PdfPCell cell = new PdfPCell();
		cell.setBorder(PdfPCell.NO_BORDER); 
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell.setColspan(7);
		t.addCell(cell);
		
		//add heading columns
		t.addCell("UOM_ID");
		t.addCell("UOM_TYPE");
		t.addCell("UOM_MODEL");
		t.addCell("DESCRIPTION");
		//add DB to data to table
		for(Uom e:uoms) {
			t.addCell(e.getId().toString());
			t.addCell(e.getType());
			t.addCell(e.getModel());
			t.addCell(e.getDsc());
		}
		//add to document
		document.add(t);
		//add date
		document.add(new Paragraph(new Date().toString()));
	}


}
