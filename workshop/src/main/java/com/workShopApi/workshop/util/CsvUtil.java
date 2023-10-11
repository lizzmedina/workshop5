package com.workShopApi.workshop.util;
import com.workShopApi.workshop.modeldto.Persona;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.springframework.stereotype.Component;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CsvUtil {
    public static List<Persona> leerCSV(String pathfile) {
        List<Persona> personas = new ArrayList<>();

        try (Reader reader = new FileReader(pathfile);
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader())) {
            personas = csvParser.getRecords().stream()
                    .map(record -> new Persona(
                            record.get("Index"),
                            record.get("User Id"),
                            record.get("First Name"),
                            record.get("Last Name"),
                            record.get("Sex"),
                            record.get("Email"),
                            record.get("Phone"),
                            record.get("Date of birth"),
                            record.get("Job Title")))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }

        personas.forEach(System.out::println);
        return personas;
    }
}

