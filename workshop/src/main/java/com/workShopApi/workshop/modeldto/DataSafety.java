package com.workShopApi.workshop.modeldto;

public class DataSafety {

    private String date;
    private String injuryLocation;
    private String gender;
    private String ageGroup;
    private String incidentType;
    private double daysLost;
    private String plant;
    private String reportType;
    private String shift;
    private String department;
    private String incidentCost;
    private String wkDay;
    private int month;
    private int year;

    public DataSafety(String date, String injuryLocation, String gender, String ageGroup, String incidentType,
                     double daysLost, String plant, String reportType, String shift, String department,
                     String incidentCost, String wkDay, int month, int year) {
        this.date = date;
        this.injuryLocation = injuryLocation;
        this.gender = gender;
        this.ageGroup = ageGroup;
        this.incidentType = incidentType;
        this.daysLost = daysLost;
        this.plant = plant;
        this.reportType = reportType;
        this.shift = shift;
        this.department = department;
        this.incidentCost = incidentCost;
        this.wkDay = wkDay;
        this.month = month;
        this.year = year;
    }

}
