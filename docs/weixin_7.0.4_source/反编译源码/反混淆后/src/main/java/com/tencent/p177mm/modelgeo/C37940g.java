package com.tencent.p177mm.modelgeo;

import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationListener;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.mm.modelgeo.g */
public abstract class C37940g implements TencentLocationListener {
    private final Map<String, Integer> fCg = new HashMap();

    public C37940g() {
        this.fCg.put("gps", Integer.valueOf(0));
        this.fCg.put(TencentLocation.NETWORK_PROVIDER, Integer.valueOf(1));
    }

    public void onLocationChanged(TencentLocation tencentLocation, int i, String str) {
        C4990ab.m7417i("MicroMsg.SLocationListenerWgs84", "lat=%f, lng=%f, accuracy=%f errcode=%d, areastat=%d, speed=%f, bearing=%f, reason=%s, provider=%s", Double.valueOf(tencentLocation.getLatitude()), Double.valueOf(tencentLocation.getLongitude()), Float.valueOf(tencentLocation.getAccuracy()), Integer.valueOf(i), tencentLocation.getAreaStat(), Float.valueOf(tencentLocation.getSpeed()), Float.valueOf(tencentLocation.getBearing()), str, tencentLocation.getProvider());
        if (i == 0) {
            mo44211a(true, tencentLocation.getLatitude(), tencentLocation.getLongitude(), ((Integer) this.fCg.get(tencentLocation.getProvider())).intValue(), (double) tencentLocation.getSpeed(), (double) tencentLocation.getAccuracy(), tencentLocation.getAltitude(), tencentLocation.getIndoorBuildingId(), tencentLocation.getIndoorBuildingFloor(), tencentLocation.getIndoorLocationType());
            return;
        }
        mo44211a(false, tencentLocation.getLatitude(), tencentLocation.getLongitude(), ((Integer) this.fCg.get(tencentLocation.getProvider())).intValue(), (double) tencentLocation.getSpeed(), (double) tencentLocation.getAccuracy(), tencentLocation.getAltitude(), tencentLocation.getIndoorBuildingId(), tencentLocation.getIndoorBuildingFloor(), tencentLocation.getIndoorLocationType());
    }

    public void onStatusUpdate(String str, int i, String str2) {
        C4990ab.m7411d("MicroMsg.SLocationListenerWgs84", "onStatusUpdate, name=%s, status=%d, desc=%s", str, Integer.valueOf(i), str2);
    }

    /* renamed from: a */
    public void mo44211a(boolean z, double d, double d2, int i, double d3, double d4, double d5, String str, String str2, int i2) {
    }
}
