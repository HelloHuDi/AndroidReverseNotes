package com.tencent.map.lib.element;

public class MapPoi {
    double a;
    String b;
    private double c;

    public MapPoi(double d, double d2, String str) {
        this.c = d;
        this.a = d2;
        this.b = str;
    }

    public double getLatitude() {
        return this.c;
    }

    public double getLongitude() {
        return this.a;
    }

    public String getPoiName() {
        return this.b;
    }
}
