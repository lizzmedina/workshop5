package com.workShopApi.workshop.service;

import com.workShopApi.workshop.modeldto.DataSafety;

import java.util.HashSet;

public class XLSXValidatorService {

    private final HashSet<String> reportTypes = new HashSet<>();

    public XLSXValidatorService(){
        this.reportTypes.add("near miss");
        this.reportTypes.add("lost time");
        this.reportTypes.add("first aid");
    }

    public boolean validateXLSX(DataSafety dataSafety) {
        return validateInjuryLocation(dataSafety.getInjuryLocation()) &&
                validateReportType(dataSafety.getReportType());
    }

    public boolean validateInjuryLocation(String injuryLocation){
        if (validateBlank(injuryLocation)) {
            return false;
        }
        return !injuryLocation.equals("N/A");
    }

    public boolean validateReportType(String reportType){
        if (validateBlank(reportType)){
            return false;
        }
        return this.reportTypes.contains(reportType.toLowerCase());
    }

    //función que comprueba si una cadena de texto está vacía o es nula.
    public boolean validateBlank(String textToValidate){
        return textToValidate == null || textToValidate.trim().isEmpty();
    }

}
