package com.workShopApi.workshop.controller;

import com.workShopApi.workshop.feign.FeignUtil;
import com.workShopApi.workshop.util.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/feignService")
public class FeignController {

//
//    @GetMapping("/f-validate-cvs")
//    public String isValidateCvs(){
//        return feignUtil.isValidateCvs();
//    }
//    @GetMapping("/f-validate-exc")
//    public String isValidateExc(){
//        return feignUtil.isValidateExc();
//    }
}
