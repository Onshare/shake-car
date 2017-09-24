package com.android.shake.bean;

/**
 * Created by NoName on 2017/9/24.
 */

public class MapEntity {

    private long time;
    private int code;
    private int radius ;
    private double mLatitude, mLongitude;//纬度 经度
    private String mCity;
    private String mStreet;
    private String mDistrict;
    private String mLocationDescribe;

    public double[] getLatLng(){
        return new double[]{mLatitude, mLongitude};
    }

    public int getRadius() {
        return radius;
    }

    public long getTime() {
        return time;
    }

    public String getmLocationDescribe() {
        return mLocationDescribe;
    }

    public boolean isEnable(){
        return code == 61 || code == 161;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public void setLatLng(double lat, double lng){
        this.mLatitude = lat;
        this.mLongitude = lng;
    }

    public void setCity(String mCity) {
        this.mCity = mCity;
    }

    public void setStreet(String mStreet) {
        this.mStreet = mStreet;
    }

    public void setDistrict(String mDistrict) {
        this.mDistrict = mDistrict;
    }

    public void setLocationDescribe(String mLocationDescribe) {
        this.mLocationDescribe = mLocationDescribe;
    }
}
