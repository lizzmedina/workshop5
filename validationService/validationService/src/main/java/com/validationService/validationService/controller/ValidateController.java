package com.validationService.validationService.controller;
import com.validationService.validationService.service.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
@RequestMapping("/validar")
public class ValidateController {
    @Autowired
    private ValidationService validationService;

    @PostMapping("/cvs")
    public Boolean validarCvs(@RequestBody Map<String, String> request){
        return this.validationService.validateLine(request.get("email"), request.get("dateOfBirth"),request.get("jobTitle"));
        //{
        // email=alejandromassey@example.net,
        // dateOfBirth=1917-01-08,
        // jobTitle=Engineer
        // }
    }

//    @PostMapping("/xlsx")
//    public boolean validateXLSX(@RequestBody Map<String, String> request) {
//        return this.validationService.validateXLSX(request.get(""));
//    }
}