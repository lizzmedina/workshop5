package com.workShopApi.workshop;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
@RequestMapping("api/v1")
public class ProcessingController {
    //read csv
    @PostMapping("/csv")
    public ResponseEntity<?> leercsv(@RequestBody Map<String, String> request) {
        try {
            String pathfile = request.get("pathfile");
            ProcessingService.procesarCVS(pathfile);
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    @PostMapping("/xlsx")
    public ResponseEntity<?> leerxlsx(@RequestBody Map<String, String> request) {
        try {
            String pathfile = request.get("pathfile");
            MultipartFile xlsxFile = ProcessingService.obtenerArchivoXLSX(pathfile);
            ProcessingService.procesarXLSX(xlsxFile);
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }
}
