package com.sample.serviceImpl;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sample.domain.SampleDomain;
import com.sample.repository.SampleRepo;

@Service
public class SampleServiceImpl implements SampleService {
	@Autowired
	SampleRepo sampleRepo;

	@Override
	public String excelDataConvertion(MultipartFile file) throws IOException {

		try {
			InputStream inputStream = file.getInputStream();
			XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
			// Workbook wb = WorkbookFactory.create(inputStream);
			Map<Integer, String> map = new HashMap<Integer, String>();
			List<String> sheetNames = new ArrayList<String>();
			for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
				sheetNames.add(workbook.getSheetName(i));
				map.put(i, workbook.getSheetName(i));
			}
			System.out.println(map);
			System.out.println(sheetNames);

			XSSFSheet sheet = workbook.getSheetAt(2);
			Iterator<Row> rowIterator = sheet.iterator();
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				// For each row, iterate through all the columns
				Iterator<Cell> cellIterator = row.cellIterator();

				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();

					switch (cell.getCellType()) {

					case NUMERIC:
						System.out.print(cell.getNumericCellValue() + "\t");
						break;
					case STRING:

						System.out.print(cell.getStringCellValue() + "\t");

						break;
					case BLANK:
						System.out.print(" " + "\t");
						break;
					case _NONE:
						System.out.print(" " + "\t");
						break;

					case BOOLEAN:
						System.out.print(cell.getBooleanCellValue() + "\t");
						break;
					case ERROR:
						System.out.print(cell.getErrorCellValue() + "\t");
						break;

					}
				}
				System.out.println(" ");

			}
			inputStream.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public String readByColumnName(MultipartFile file) {
		try {
			InputStream inputStream = file.getInputStream();
			XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
			XSSFSheet sheet = workbook.getSheet("XYZ IT and PAM");
			List<SampleDomain> samples= new ArrayList<SampleDomain>();
			SampleDomain sampleDomain;
			for (int rowIndex = 2; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
				Row row = sheet.getRow(rowIndex);
				if (row != null) {
					 String businessServices = row.getCell(0).getStringCellValue();
		             String fullApplicationName = row.getCell(1).getStringCellValue();
		             String abapOrJava= row.getCell(2).getStringCellValue();
		             String sid= row.getCell(3).getStringCellValue();
		             String aka= row.getCell(4).getStringCellValue();
		             String environmentRole= row.getCell(5).getStringCellValue();
		             String physicalServerName= row.getCell(6).getStringCellValue();
		             String dbOrCiOrApp= row.getCell(7).getStringCellValue();
		             String sapOrBi= row.getCell(8).getStringCellValue();
		             sampleDomain = new SampleDomain(businessServices,fullApplicationName,abapOrJava,sid,
		            		 aka,environmentRole,physicalServerName,dbOrCiOrApp,sapOrBi);
		             samples.add(sampleDomain);
		             sampleRepo.saveAndFlush(sampleDomain);
				}
				
			}
			
			return "Data pushed to Db";
		} catch (Exception e) {
			// TODO: handle exception
			return "error";
		}
		

	}
	
	
}
