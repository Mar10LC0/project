package com.mario.luftansa.luftansaProject.serviceImpl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mario.luftansa.luftansaProject.entity.Leje;
import com.mario.luftansa.luftansaProject.service.LejeService;

@Service
public class ExporterServiceImpl
{
	@Autowired
	LejeService service;
	
	
	private static final String CSV_LINE_SEPARATOR = "\n";
	private static final String CSV_FIELD_SEPARATOR = ",";
	private static final String CSV_TITLE = "Raporte te aplikanteve: ";
	private static final String[] CSV_HEADER = { "id", "pershkrim", "date_fillimi", "date_mbarimi", "state", "punonjes_Id" };

	@Transactional
	public ByteArrayInputStream print(List<String> idsList) throws Exception
	{
		try
		{
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			String data = buildCsv(idsList);
			outputStream.write(data.getBytes(StandardCharsets.UTF_8));
			final byte[] bytes = outputStream.toByteArray();
			return new ByteArrayInputStream(bytes);
		}
		catch (Exception e) 
		{
			throw new Exception("Gabim Eksporti csv");
		}
	}

	private String buildCsv(List<String> idsList) {
		DateFormat footerFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		StringBuilder result = new StringBuilder();
		result.append(CSV_TITLE)
				.append(footerFormat.format(new Date()).concat(CSV_LINE_SEPARATOR).concat(CSV_LINE_SEPARATOR));

		for (String s : CSV_HEADER) {
			result.append(s += CSV_FIELD_SEPARATOR);

		}
		result.append(CSV_LINE_SEPARATOR);

		idsList.forEach(id -> {
			Leje leje = service.getById(Integer.parseInt(id));
			//FornitoriBibliotecheDto fornitoreB = fBiblioService.findByCodFornitore(fornitore.getCodFornitore());

			result.append(replaceFieldSeparator(leje.getId().toString())).append(CSV_FIELD_SEPARATOR);
			result.append(replaceFieldSeparator(leje.getPershkrim())).append(CSV_FIELD_SEPARATOR);
			result.append(leje.getDateFillimi()).append(CSV_FIELD_SEPARATOR);

			result.append(leje.getDateMbarimi()).append(CSV_FIELD_SEPARATOR);
			
			result.append(replaceFieldSeparator(leje.getState())).append(CSV_FIELD_SEPARATOR);

			result.append(leje.getPunonjes());


			result.append(CSV_LINE_SEPARATOR);
		});

		return result.toString();
	}

	private String replaceFieldSeparator(String string) {
		return string != null ? string.replace(CSV_FIELD_SEPARATOR, ".") : "";
	}
	/*
	public void exportFornitoreCsv(HttpServletResponse response, List<Leje> lejet) {

		try {

			List<Leje> filtroRicerca = fromFornitoreBibliotecheDto(lejet);
			ObjectMapper mapper = new ObjectMapper();

			String rawJsonData = mapper.writeValueAsString(filtroRicerca);
			JasperReport report = JasperCompileManager
					.compileReport(new ClassPathResource("FornitoreCsv.jrxml").getInputStream());

			ByteArrayInputStream jsonDataStream = new ByteArrayInputStream(rawJsonData.getBytes());
			JsonDataSource ds = new JsonDataSource(jsonDataStream);

			Map parameters = new HashMap();
			parameters.put("title", "Jasper csv example");
			JasperPrint jasperPrint = JasperFillManager.fillReport(report, parameters, ds);

			response.setContentType("text/csv");
			response.addHeader("Content-disposition", "attachment; filename=Fornitore.csv");
			ServletOutputStream outputStream = response.getOutputStream();
			;

			JRXlsxExporter exporter = new JRXlsxExporter();
			exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
			exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(outputStream));

			SimpleXlsxReportConfiguration configuration = new SimpleXlsxReportConfiguration();
			configuration.setOnePagePerSheet(true);
			configuration.setDetectCellType(true);
			exporter.setConfiguration(configuration);
			exporter.exportReport();


			response.flushBuffer();
		} catch (JRException ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
*/
}
