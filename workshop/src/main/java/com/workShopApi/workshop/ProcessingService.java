package com.workShopApi.workshop;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ProcessingService {
    public static void LeerCSV(String pathfile) {
        try (Reader reader = new FileReader(pathfile);
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT)) {
            for (CSVRecord record : csvParser) {
                System.out.println(record.get(0) + "," + record.get(1) + "," + record.get(2) + "," + record.get(3));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void LeerXLSX(MultipartFile pathfile) {
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(pathfile.getInputStream());
            XSSFSheet sheet = workbook.getSheetAt(0);

            for(int i=0; i<sheet.getPhysicalNumberOfRows(); i++) {
                XSSFRow row = sheet.getRow(i);
                for(int j=0;j<row.getPhysicalNumberOfCells();j++) {
                    System.out.print(row.getCell(j) +" ");
                }
                System.out.println();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
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
