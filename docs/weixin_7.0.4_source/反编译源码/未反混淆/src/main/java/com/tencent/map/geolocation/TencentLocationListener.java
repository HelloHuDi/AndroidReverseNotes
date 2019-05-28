package com.tencent.map.geolocation;

public interface TencentLocationListener {
    public static final String CELL = "cell";
    public static final String GPS = "gps";
    @Deprecated
    public static final String RADIO = "radio";
    public static final int STATUS_DENIED = 2;
    public static final int STATUS_DISABLED = 0;
    public static final int STATUS_ENABLED = 1;
    public static final int STATUS_GPS_AVAILABLE = 3;
    public static final int STATUS_GPS_UNAVAILABLE = 4;
    public static final int STATUS_LOCATION_SWITCH_OFF = 5;
    public static final int STATUS_UNKNOWN = -1;
    public static final String WIFI = "wifi";

    void onLocationChanged(TencentLocation tencentLocation, int i, String str);

    void onStatusUpdate(String str, int i, String str2);
}
