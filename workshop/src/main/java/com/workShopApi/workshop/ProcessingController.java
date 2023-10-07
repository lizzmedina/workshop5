package com.workShopApi.workshop;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
@RequestMapping("api/v1")
public class ProcessingController {
    @PostMapping("/read")
    public ResponseEntity<?> Read(@RequestBody Map<String, String> request) {
        try {
            String pathfile = request.get("pathfile");
            String fileType = request.get("tipo");

            if ("csv".equalsIgnoreCase(fileType)) {
                ProcessingService.LeerCSV(pathfile);
            } else if ("xlsx".equalsIgnoreCase(fileType)) {
                MultipartFile xlsxFile = ProcessingService.obtenerArchivoXLSX(pathfile);
                ProcessingService.LeerXLSX(xlsxFile);
            } else {
                return ResponseEntity.badRequest().body("Error: Tipo de archivo no admitido");
            }
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

}
