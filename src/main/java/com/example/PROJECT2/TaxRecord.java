package com.example.PROJECT2;

public class TaxRecord {
    private String countryCode;
    private String countryName;
    private Double standartRate;

    public TaxRecord(){

    }

    public TaxRecord(String countryCode, String countryName, Double standartRate) {
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.standartRate = standartRate;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public Double getStandartRate() {
        return standartRate;
    }

    public void setStandartRate(Double standartRate) {
        this.standartRate = standartRate;
    }
}
