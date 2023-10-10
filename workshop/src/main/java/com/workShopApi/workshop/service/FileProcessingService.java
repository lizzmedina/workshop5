package com.workShopApi.workshop.service;



import com.workShopApi.workshop.feign.FeignUtil;
import com.workShopApi.workshop.modeldto.ValidationResult;
import com.workShopApi.workshop.util.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class FileProcessingService {

    @Autowired
    private ValidationService validationService;
    @Autowired
    private FeignUtil feignUtil;

    public List<Persona> getPerson(){
        return feignUtil.getPerson();
    }
    public void saveUser(Persona persona){
        feignUtil.saveData(persona);
    }
    public ValidationResult processFile(MultipartFile file) {
        // Lógica para procesar el archivo
        // Leer línea por línea
        // Enviar peticiones HTTP al servicio de validación con cada línea
        // Registrar el número de líneas válidas e inválidas
        return null;
    }
}




