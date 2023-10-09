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

    @Autowired
    private ValidationService validationService;

    @PostMapping("/csv")
    public Boolean validarCvc(){ // debe llevar @RequestBody Persona persona
        return true;  //this.validateCvs(persona);
    }


    @PostMapping("/excel")
    public Boolean validarExc(){ // debe llevar @RequestBody Persona persona
        return false; //this.validationService(persona);
    }
}
