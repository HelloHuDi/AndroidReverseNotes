package com.tencent.mm.modelgeo;

import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationListener;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.Map;

public abstract class g implements TencentLocationListener {
    private final Map<String, Integer> fCg = new HashMap();

    public g() {
        this.fCg.put("gps", Integer.valueOf(0));
        this.fCg.put(TencentLocation.NETWORK_PROVIDER, Integer.valueOf(1));
    }

    public void onLocationChanged(TencentLocation tencentLocation, int i, String str) {
        ab.i("MicroMsg.SLocationListenerWgs84", "lat=%f, lng=%f, accuracy=%f errcode=%d, areastat=%d, speed=%f, bearing=%f, reason=%s, provider=%s", Double.valueOf(tencentLocation.getLatitude()), Double.valueOf(tencentLocation.getLongitude()), Float.valueOf(tencentLocation.getAccuracy()), Integer.valueOf(i), tencentLocation.getAreaStat(), Float.valueOf(tencentLocation.getSpeed()), Float.valueOf(tencentLocation.getBearing()), str, tencentLocation.getProvider());
        if (i == 0) {
            a(true, tencentLocation.getLatitude(), tencentLocation.getLongitude(), ((Integer) this.fCg.get(tencentLocation.getProvider())).intValue(), (double) tencentLocation.getSpeed(), (double) tencentLocation.getAccuracy(), tencentLocation.getAltitude(), tencentLocation.getIndoorBuildingId(), tencentLocation.getIndoorBuildingFloor(), tencentLocation.getIndoorLocationType());
            return;
        }
        a(false, tencentLocation.getLatitude(), tencentLocation.getLongitude(), ((Integer) this.fCg.get(tencentLocation.getProvider())).intValue(), (double) tencentLocation.getSpeed(), (double) tencentLocation.getAccuracy(), tencentLocation.getAltitude(), tencentLocation.getIndoorBuildingId(), tencentLocation.getIndoorBuildingFloor(), tencentLocation.getIndoorLocationType());
    }

    public void onStatusUpdate(String str, int i, String str2) {
        ab.d("MicroMsg.SLocationListenerWgs84", "onStatusUpdate, name=%s, status=%d, desc=%s", str, Integer.valueOf(i), str2);
    }

    public void a(boolean z, double d, double d2, int i, double d3, double d4, double d5, String str, String str2, int i2) {
    }
}
