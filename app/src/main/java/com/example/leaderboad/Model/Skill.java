package com.example.leaderboad.Model;

import com.google.gson.annotations.SerializedName;

public class Skill {
    //i hope you know what @serialzedName does , well....
    // this class represents the data we want to fetch from the Json
    @SerializedName("name")
    String name;
    @SerializedName("score")
    String score;
    @SerializedName("country")
    String country;
    @SerializedName("badgeUrl")
    String badgeUrl;

    public Skill() {
    }

    public Skill(String name, String score, String country, String badgeUrl) {
        this.name = name;
        this.score = score;
        this.country = country;
        this.badgeUrl = badgeUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
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

    @Override
    public String toString() {
        //useful but not now
        return "Skill{" +
                "name='" + name + '\'' +
                ", score='" + score + '\'' +
                ", country='" + country + '\'' +
                ", badgeUrl='" + badgeUrl + '\'' +
                '}';
    }
}
