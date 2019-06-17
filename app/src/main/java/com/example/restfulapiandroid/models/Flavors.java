package com.example.restfulapiandroid.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Flavors {

    @SerializedName("piquant")
    @Expose
    private Double piquant;
    @SerializedName("meaty")
    @Expose
    private Double meaty;
    @SerializedName("bitter")
    @Expose
    private Double bitter;
    @SerializedName("sweet")
    @Expose
    private Double sweet;
    @SerializedName("sour")
    @Expose
    private Double sour;
    @SerializedName("salty")
    @Expose
    private Double salty;

    public Flavors(Double piquant, Double meaty, Double bitter, Double sweet, Double sour, Double salty) {
        this.piquant = piquant;
        this.meaty = meaty;
        this.bitter = bitter;
        this.sweet = sweet;
        this.sour = sour;
        this.salty = salty;
    }

    public Double getPiquant() {
        return piquant;
    }

    public void setPiquant(Double piquant) {
        this.piquant = piquant;
    }

    public Double getMeaty() {
        return meaty;
    }

    public void setMeaty(Double meaty) {
        this.meaty = meaty;
    }

    public Double getBitter() {
        return bitter;
    }

    public void setBitter(Double bitter) {
        this.bitter = bitter;
    }

    public Double getSweet() {
        return sweet;
    }

    public void setSweet(Double sweet) {
        this.sweet = sweet;
    }

    public Double getSour() {
        return sour;
    }

    public void setSour(Double sour) {
        this.sour = sour;
    }

    public Double getSalty() {
        return salty;
    }

    public void setSalty(Double salty) {
        this.salty = salty;
    }
}
