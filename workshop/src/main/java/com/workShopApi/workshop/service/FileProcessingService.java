package com.workShopApi.workshop.service;
import com.workShopApi.workshop.feign.FeignUtil;
import com.workShopApi.workshop.modeldto.Persona;
import com.workShopApi.workshop.util.CsvUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.List;

@Service
public class FileProcessingService {
    @Autowired
    private ValidationService validationService;
    @Autowired
    private FeignUtil feignUtil;

    public String processFile(String file) {
        int invalidCount = 0, validCount = 0;
        try {
            List<Persona> listaPersonas = CsvUtil.leerCSV(file);
            for (Persona persona : listaPersonas) {
                //metodo que se supone debe validar | Da error pq no hemos hecho conexion ni nda
                boolean lineaEsValida = this.validationService.validateLine( "csv");
                if (lineaEsValida) {
                    validCount++;
                } else {
                    invalidCount++;
                }
            }
        } catch (Exception e) {
            return "Error processing the file: " + e.getMessage();
        }
        return "Lineas validas: " + validCount + " Lineas Invalidas: " + invalidCount;
    }
}




