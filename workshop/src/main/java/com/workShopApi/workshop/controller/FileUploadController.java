package com.workShopApi.workshop.controller;

import com.workShopApi.workshop.modeldto.Persona;
import com.workShopApi.workshop.service.FileProcessingService;
import com.workShopApi.workshop.util.CsvUtil;
import com.workShopApi.workshop.util.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/files")
public class FileUploadController {
    @Autowired
    private FileProcessingService fileProcessingService;

    @PostMapping("/upload")
    public String uploadFile(@RequestBody Map<String, String> request) {
        try {
            String pathfile = request.get("pathfile");
            String fileType = request.get("tipo");

            if (pathfile == null || pathfile.isEmpty()) {
              return "Error: File path is required";
            }

            if ("csv".equalsIgnoreCase(fileType)) {
            //    List<Persona> output = CsvUtil.leerCSV(pathfile);
             //   System.out.println(output);
               return fileProcessingService.processFile(pathfile);
            } else if ("xlsx".equalsIgnoreCase(fileType)) {
                MultipartFile xlsxFile = ExcelUtil.obtenerArchivoXLSX(pathfile);

                ExcelUtil.leerXLSX(xlsxFile);
            } else {
                return "Error: Unsupported file type";
            }

            return "File processed successfully";

        } catch (IllegalArgumentException e) {
            return ("Error: " + e.getMessage());
        }
    }
}