package com.tencent.p177mm.modelgeo;

import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationListener;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.mm.modelgeo.f */
public abstract class C26447f implements TencentLocationListener {
    private final Map<String, Integer> fCg = new HashMap();

    public C26447f() {
        this.fCg.put("gps", Integer.valueOf(0));
        this.fCg.put(TencentLocation.NETWORK_PROVIDER, Integer.valueOf(1));
    }

    public void onLocationChanged(TencentLocation tencentLocation, int i, String str) {
        C4990ab.m7417i("MicroMsg.SLocationListener", "lat=%f, lng=%f, accuracy=%f errcode=%d, areastat=%d, speed=%f, bearing=%f, reason=%s, provider=%s", Double.valueOf(tencentLocation.getLatitude()), Double.valueOf(tencentLocation.getLongitude()), Float.valueOf(tencentLocation.getAccuracy()), Integer.valueOf(i), tencentLocation.getAreaStat(), Float.valueOf(tencentLocation.getSpeed()), Float.valueOf(tencentLocation.getBearing()), str, tencentLocation.getProvider());
        if (i == 0) {
            C7060h.pYm.mo8378a(584, 1, 1, true);
            mo44209a(true, tencentLocation.getLatitude(), tencentLocation.getLongitude(), ((Integer) this.fCg.get(tencentLocation.getProvider())).intValue(), (double) tencentLocation.getSpeed(), (double) tencentLocation.getAccuracy(), tencentLocation.getAltitude(), tencentLocation.getIndoorBuildingId(), tencentLocation.getIndoorBuildingFloor(), tencentLocation.getIndoorLocationType());
            return;
        }
        C7060h.pYm.mo8378a(584, 2, 1, true);
        if (i == 1) {
            C7060h.pYm.mo8378a(584, 3, 1, true);
        } else if (i == 4) {
            C7060h.pYm.mo8378a(584, 4, 1, true);
        }
        mo44209a(false, tencentLocation.getLatitude(), tencentLocation.getLongitude(), ((Integer) this.fCg.get(tencentLocation.getProvider())).intValue(), (double) tencentLocation.getSpeed(), (double) tencentLocation.getAccuracy(), tencentLocation.getAltitude(), tencentLocation.getIndoorBuildingId(), tencentLocation.getIndoorBuildingFloor(), tencentLocation.getIndoorLocationType());
    }

    public void onStatusUpdate(String str, int i, String str2) {
        C4990ab.m7411d("MicroMsg.SLocationListener", "onStatusUpdate, name=%s, status=%d, desc=%s", str, Integer.valueOf(i), str2);
    }

    /* renamed from: a */
    public void mo44209a(boolean z, double d, double d2, int i, double d3, double d4, double d5, String str, String str2, int i2) {
    }
}
