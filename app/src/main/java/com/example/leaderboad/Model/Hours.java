package com.example.leaderboad.Model;

import com.google.gson.annotations.SerializedName;

public class Hours {
    @SerializedName("name")
    String name;
    @SerializedName("hours")
    String hours;
    @SerializedName("country")
    String country;
    @SerializedName("badgeUrl")
    String badgeUrl;

    public Hours() {
    }

    public Hours(String name, String hours, String country, String badgeUrl) {
        this.name = name;
        this.hours = hours;
        this.country = country;
        this.badgeUrl = badgeUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getBadgeUrl() {
        return badgeUrl;
    }

    public void setBadgeUrl(String badgeUrl) {
        this.badgeUrl = badgeUrl;
    }
}
