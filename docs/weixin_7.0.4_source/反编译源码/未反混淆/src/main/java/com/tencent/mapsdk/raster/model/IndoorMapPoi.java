package com.tencent.mapsdk.raster.model;

public class IndoorMapPoi extends MapPoi {
    private String buildingId;
    private String buildingName;
    private String floorName;

    public IndoorMapPoi(String str, LatLng latLng, String str2, String str3, String str4) {
        super(str, latLng);
        this.buildingId = str2;
        this.buildingName = str3;
        this.floorName = str4;
    }

    public String getBuildingId() {
        return this.buildingId;
    }

    public String getBuildingName() {
        return this.buildingName;
    }

    public String getFloorName() {
        return this.floorName;
    }
}
