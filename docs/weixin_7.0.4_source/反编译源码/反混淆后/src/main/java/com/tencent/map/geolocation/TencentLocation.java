package com.tencent.map.geolocation;

import android.os.Bundle;
import java.util.List;

public interface TencentLocation {
    public static final int ERROR_BAD_JSON = 2;
    public static final int ERROR_NETWORK = 1;
    public static final int ERROR_OK = 0;
    public static final int ERROR_UNKNOWN = 404;
    public static final int ERROR_WGS84 = 4;
    public static final String EXTRA_ADDRDESP_LANDMARK = "addrdesp.landmark";
    public static final String EXTRA_ADDRDESP_OTHERS_RESULTS = "addrdesp.results";
    public static final String EXTRA_ADDRDESP_SECOND_LANDMARK = "addrdesp.second_landmark";
    public static final String EXTRA_DIRECTION = "direction";
    public static final String EXTRA_RESP_JSON = "resp_json";
    public static final String GPS_PROVIDER = "gps";
    public static final String NETWORK_PROVIDER = "network";

    float getAccuracy();

    String getAddress();

    double getAltitude();

    Integer getAreaStat();

    float getBearing();

    String getCity();

    String getCityCode();

    int getCoordinateType();

    double getDirection();

    String getDistrict();

    long getElapsedRealtime();

    Bundle getExtra();

    int getGPSRssi();

    String getIndoorBuildingFloor();

    String getIndoorBuildingId();

    int getIndoorLocationType();

    double getLatitude();

    double getLongitude();

    String getName();

    String getNation();

    List<TencentPoi> getPoiList();

    String getProvider();

    String getProvince();

    float getSpeed();

    String getStreet();

    String getStreetNo();

    long getTime();

    String getTown();

    String getVillage();

    int isMockGps();
}
