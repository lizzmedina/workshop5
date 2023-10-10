package com.workShopApi.workshop.util;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Component
public class ExcelUtil {
    public List<DataSafety> LeerXLSX(MultipartFile pathfile) {
        List<DataSafety> incidentes = new ArrayList<>();

        try {
            XSSFWorkbook workbook = new XSSFWorkbook(pathfile.getInputStream());
            XSSFSheet sheet = workbook.getSheetAt(0);

            for(int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
                XSSFRow row = sheet.getRow(i);

                String date = row.getCell(0).getStringCellValue();
                String injuryLocation = row.getCell(1).getStringCellValue();
                String gender = row.getCell(2).getStringCellValue();
                String ageGroup = row.getCell(3).getStringCellValue();
                String incidentType = row.getCell(4).getStringCellValue();
                double daysLost = row.getCell(5).getNumericCellValue();
                String plant = row.getCell(6).getStringCellValue();
                String reportType = row.getCell(7).getStringCellValue();
                String shift = row.getCell(8).getStringCellValue();
                String department = row.getCell(9).getStringCellValue();
                String incidentCost = row.getCell(10).getStringCellValue();
                String wkDay = row.getCell(11).getStringCellValue();
                int month = (int) row.getCell(12).getNumericCellValue();
                int year = (int) row.getCell(13).getNumericCellValue();

                incidentes.add(new DataSafety(date, injuryLocation, gender, ageGroup, incidentType,
                        daysLost, plant, reportType, shift, department, incidentCost, wkDay, month, year));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return incidentes;
    }

    public static MultipartFile obtenerArchivoXLSX(String filePath) {
        try {
            Path path = Paths.get(filePath);
            String name = path.getFileName().toString();
            String originalFileName = name.substring(0, name.lastIndexOf("."));
            String contentType = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
            byte[] content = Files.readAllBytes(path);
            return new MockMultipartFile(name, originalFileName, contentType, content);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}