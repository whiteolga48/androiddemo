package com.mariusapps.paisesbanderas.model;

public class Pais {


    private String name;

    private String alpha2Code;

    private String capital;

    private  String nativeName;

    private  int population;

    private String
            region;

    public Pais(String name, String alpha2Code, String capital, String nativeName, int population, String region) {
        this.name = name;
        this.alpha2Code = alpha2Code;
        this.capital = capital;
        this.nativeName = nativeName;
        this.population = population;
        this.region = region;
    }

    @Override
    public String toString() {
        return "Pais{" +
                "name='" + name + '\'' +
                ", alpha2Code='" + alpha2Code + '\'' +
                ", capital='" + capital + '\'' +
                ", nativeName='" + nativeName + '\'' +
                ", population=" + population +
                ", region='" + region + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlpha2Code() {
        return alpha2Code;
    }

    public void setAlpha2Code(String alpha2Code) {
        this.alpha2Code = alpha2Code;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getNativeName() {
        return nativeName;
    }

    public void setNativeName(String nativeName) {
        this.nativeName = nativeName;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }


// otros 3 atributos






}
