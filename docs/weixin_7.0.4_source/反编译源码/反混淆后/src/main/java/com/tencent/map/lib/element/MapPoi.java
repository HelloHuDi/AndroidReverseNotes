package com.tencent.map.lib.element;

public class MapPoi {
    /* renamed from: a */
    double f17138a;
    /* renamed from: b */
    String f17139b;
    /* renamed from: c */
    private double f17140c;

    public MapPoi(double d, double d2, String str) {
        this.f17140c = d;
        this.f17138a = d2;
        this.f17139b = str;
    }

    public double getLatitude() {
        return this.f17140c;
    }

    public double getLongitude() {
        return this.f17138a;
    }

    public String getPoiName() {
        return this.f17139b;
    }
}
