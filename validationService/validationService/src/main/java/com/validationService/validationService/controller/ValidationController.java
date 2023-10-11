package com.validationService.validationService.controller;

import com.validationService.validationService.service.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/validar")
public class ValidationController {

    private final CSVValidatorService csvValidatorService;
    private final XLSXValidatorService xlsxValidatorService;
    
    @Autowired
    public FileValidatorController(CSVValidatorService csvValidatorService, XLSXValidatorService xlsxValidatorService) {
        this.csvValidatorService = csvValidatorService;
        this.xlsxValidatorService = xlsxValidatorService;
    }

    @Autowired
    private ValidationService validationService;

    @PostMapping("/csv")
    public boolean validateCSV(@RequestBody Person person) {
            return this.csvValidatorService.validateCSV(person);
    }

    @PostMapping("/xlsx")
    public boolean validateXLSX(@RequestBody SafetyIncident safetyIncident) {
        return this.xlsxValidatorService.validateXLSX(safetyIncident);
    }
}
