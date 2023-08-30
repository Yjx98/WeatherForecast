package com.example.weatherforecast.Bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class WeatherBean implements Serializable {

    @SerializedName("cityId")
    private String cityId;

    @SerializedName("city")
    private String city;

    @SerializedName("update_time")
    private String updateTime;

    @SerializedName("data")
    private List<DayWeatherBean> dayWeatherBeans;


    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getCity() {
        return city;
    }

    public List<DayWeatherBean> getDayWeatherBeans() {
        return dayWeatherBeans;
    }

    public void setDayWeatherBeans(List<DayWeatherBean> dayWeatherBeans) {
        this.dayWeatherBeans = dayWeatherBeans;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "WeatherBean{" +
                "cityId='" + cityId + '\'' +
                ", city='" + city + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", dayWeatherBeans=" + dayWeatherBeans +
                '}';
    }
}
