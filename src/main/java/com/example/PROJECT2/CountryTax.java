package com.example.PROJECT2;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class CountryTax extends ArrayList<TaxResponse> {

    String country;
    @JsonProperty(value = "standard_rate")
    Object standardRate;
    @JsonProperty(value = "reduced_rate")
    Object reducedRate;

    public CountryTax(){
    }


    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Object getStandardRate() {
        return standardRate;
    }

    public void setStandardRate(Object standardRate) {
        this.standardRate = standardRate;
    }

    public Object getReducedRate() {
        return reducedRate;
    }

    public void setReducedRate(Object reducedRate) {
        this.reducedRate = reducedRate;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CountryTax{");
        sb.append("country:'").append(country).append('\'');
        sb.append(", standardRate:").append(standardRate);
        sb.append(", reducedRate:").append(reducedRate);
        sb.append('}');
        return sb.toString();
    }


}
