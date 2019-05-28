package com.tencent.mapsdk.raster.model;

public class MapPoi {
    private String mName;
    private LatLng mPosition;

    public MapPoi(String str, LatLng latLng) {
        this.mName = str;
        this.mPosition = latLng;
    }

    public String getName() {
        return this.mName;
    }

    public LatLng getPosition() {
        return this.mPosition;
    }
}
