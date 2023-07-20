package com.example.currencyconverterapplication;

public class countryitem {
    String countryname;
    int countryflag;

    public countryitem(String countryname,int countryflag)
    {
        this.countryname=countryname;
        this.countryflag=countryflag;

    }

    public String getCountryname() {
        return countryname;
    }

    public void setCountryname(String countryname) {
        this.countryname = countryname;
    }

    public int getCountryflag() {
        return countryflag;
    }

    public void setCountryflag(int countryflag) {
        this.countryflag = countryflag;
    }
}
