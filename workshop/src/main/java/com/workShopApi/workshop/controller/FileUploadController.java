package com.workShopApi.workshop.controller;

import com.workShopApi.workshop.modeldto.ValidationResult;
import com.workShopApi.workshop.service.FileProcessingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/files")
public class FileUploadController {
    @Autowired
    private FileProcessingService fileProcessingService;

    @PostMapping("/upload")
    public ValidationResult uploadFile(@RequestParam("file") MultipartFile file) {
        // Aquí procesarás el archivo y enviarás registros al servicio de validación
        return fileProcessingService.processFile(file);
    }

}
