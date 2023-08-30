package com.example.weatherforecast.Bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class DayWeatherBean implements Serializable {

    @SerializedName("day")
    private String day;

    @SerializedName("date")
    private String date;

    @SerializedName("week")
    private String week;

    @SerializedName("wea")
    private String wea;

    @SerializedName("wea_img")
    private String weaImg;

    @SerializedName("wea_day")
    private String weaDay;

    @SerializedName("tem")
    private String tem;

    @SerializedName("tem1")
    private String tem1;

    @SerializedName("tem2")
    private String tem2;

    @SerializedName("win")
    private String[] win;

    @SerializedName("win_speed")
    private String winSpeed;

    @SerializedName("air")
    private String air;

    @SerializedName("air_level")
    private String airLevel;

    @SerializedName("air_tips")
    private String airTips;

    @SerializedName("index")
    private List<OtherTipsBean> mTipsBean;

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getWea() {
        return wea;
    }

    public void setWea(String wea) {
        this.wea = wea;
    }

    public String getWeaImg() {
        return weaImg;
    }

    public void setWeaImg(String weaImg) {
        this.weaImg = weaImg;
    }

    public String getWeaDay() {
        return weaDay;
    }

    public void setWeaDay(String weaDay) {
        this.weaDay = weaDay;
    }

    public String getTem() {
        return tem;
    }

    public void setTem(String tem) {
        this.tem = tem;
    }

    public String getTem1() {
        return tem1;
    }

    public void setTem1(String tem1) {
        this.tem1 = tem1;
    }

    public String getTem2() {
        return tem2;
    }

    public void setTem2(String tem2) {
        this.tem2 = tem2;
    }

    public String[] getWin() {
        return win;
    }

    public void setWin(String[] win) {
        this.win = win;
    }

    public String getWinSpeed() {
        return winSpeed;
    }

    public void setWinSpeed(String winSpeed) {
        this.winSpeed = winSpeed;
    }

    public String getAir() {
        return air;
    }

    public void setAir(String air) {
        this.air = air;
    }

    public String getAirLevel() {
        return airLevel;
    }

    public void setAirLevel(String airLevel) {
        this.airLevel = airLevel;
    }

    public String getAirTips() {
        return airTips;
    }

    public void setAirTips(String airTips) {
        this.airTips = airTips;
    }

    public List<OtherTipsBean> getTipsBean() {
        return mTipsBean;
    }

    public void setTipsBean(List<OtherTipsBean> mTipsBean) {
        this.mTipsBean = mTipsBean;
    }

    @Override
    public String toString() {
        return "DayWeatherBean{" +
                "day='" + day + '\'' +
                ", date='" + date + '\'' +
                ", week='" + week + '\'' +
                ", wea='" + wea + '\'' +
                ", weaImg='" + weaImg + '\'' +
                ", weaDay='" + weaDay + '\'' +
                ", tem='" + tem + '\'' +
                ", tem1='" + tem1 + '\'' +
                ", tem2='" + tem2 + '\'' +
                ", win=" + Arrays.toString(win) +
                ", winSpeed='" + winSpeed + '\'' +
                ", air='" + air + '\'' +
                ", airLevel='" + airLevel + '\'' +
                ", airTips='" + airTips + '\'' +
                ", mTipsBean=" + mTipsBean +
                '}';
    }
}
