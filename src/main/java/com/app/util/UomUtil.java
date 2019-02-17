package com.app.util;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.stereotype.Component;
@Component
public class UomUtil {
	public void genratePie(String path, List<Object[]> data) {
		//1.Creating dataset
		DefaultPieDataset dataset=new DefaultPieDataset();
		for(Object[] d: data) {
			dataset.setValue(d[0].toString(), new Double(d[1].toString()));	
		}
		//2.Convert dataset to jFreeChart
		
		      //createPieChart(title, dataset, legend, tooltips, urls)
		JFreeChart chart=ChartFactory.createPieChart3D("Uom Type Chart", dataset, true, true, false);
		//3.Save as image
		try {
		ChartUtils.saveChartAsJPEG(new File(path+"/resources/images/UomPie.jpg"), chart, 300, 300);
		}catch(IOException e)
		{
			System.out.println(e);
		}
	}

}
