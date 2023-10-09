package com.workShopApi.workshop.modeldto;



public class ValidationResult {
    private int validCount;
    private int invalidCount;


    // Getters y setters
    public int getValidCount() {
        return validCount;
    }
    public void setValidCount(int validCount) {
        this.validCount = validCount;
    }
    public int getInvalidCount() {
        return invalidCount;
    }
    public void setInvalidCount(int invalidCount) {
        this.invalidCount = invalidCount;
    }
}
