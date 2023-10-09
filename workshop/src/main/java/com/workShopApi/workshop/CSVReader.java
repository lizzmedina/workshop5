package com.workShopApi.workshop;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class CSVReader {
    public static void LeerCSV(String pathfile) {
        try (Reader reader = new FileReader(pathfile);
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader())) {
            for (CSVRecord record : csvParser) {
                System.out.println(record.get("User Id") + "," + record.get("First Name") + "," + record.get("Last Name") + "," + record.get("Sex") + "," + record.get("Email") + "," + record.get("Phone")+ "," + record.get("Date of birth") + "," + record.get("Job Title"));
                verificarEmail(record.get("Email"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void verificarEmail(String Email) {
        if (Email != null && Email.contains("@")) {
            System.out.println("Correo valido");
        } else {
            System.out.println("Correo invalido");
        }
    }
}
