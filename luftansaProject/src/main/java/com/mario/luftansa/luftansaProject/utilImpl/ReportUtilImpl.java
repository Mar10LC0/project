package com.mario.luftansa.luftansaProject.utilImpl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.stereotype.Component;

import com.mario.luftansa.luftansaProject.util.ReportUtil;

@Component
public class ReportUtilImpl implements ReportUtil
{

	@Override
	public void generatePieChart(String path, List<Object[]> data) 
	{
		//kjo e konverton datasetin ne nje tip qe e njeh
		//mer te dhenat
		DefaultPieDataset dataset = new DefaultPieDataset();
		
		//mer cdo objekt me vete per secilin me vet
		for(Object[] objects : data)
		{
			//ktu i vendosim vleren cdo arrey objekti
			dataset.setValue(objects[0].toString(), new Double(objects[1].toString()));
		}
		
		//perdor JFreeChart si API dhe egzaktesisht ChartFactory
		JFreeChart chart = ChartFactory.createPieChart3D("Raporti i Punonjesve", dataset );
		
		try 
		{
			ChartUtilities.saveChartAsJPEG(new File(path + "/pieChart.jpeg"), chart, 300, 300);
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

}
