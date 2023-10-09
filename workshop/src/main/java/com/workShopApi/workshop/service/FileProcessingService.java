package com.workShopApi.workshop.service;



import com.workShopApi.workshop.modeldto.ValidationResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileProcessingService {

    @Autowired
    private ValidationService validationService;

    public ValidationResult processFile(MultipartFile file) {
        // Lógica para procesar el archivo
        // Leer línea por línea
        // Enviar peticiones HTTP al servicio de validación con cada línea
        // Registrar el número de líneas válidas e inválidas
        return validationResult;
    }
}




