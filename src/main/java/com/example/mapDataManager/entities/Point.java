package com.example.mapDataManager.entities;

public class Point {
    double lat;
    double lon;
    public Point(double lat,double lon){
        this.lat=lat;
        this.lon=lon;
    }
    public double getLat() {
        return lat;
    }
    public void setLat(float lat) {
        this.lat = lat;
    }
    public double getLon() {
        return lon;
    }
    public void setLon(float lon) {
        this.lon = lon;
    }

    public String toString(){
        String ptr = "lon = "+lon+"\nlat = "+lat ;
        return(ptr);
    }
}
