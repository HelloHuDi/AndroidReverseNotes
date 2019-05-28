package com.tencent.p177mm.plugin.appbrand.jsapi.p304e;

import android.bluetooth.BluetoothAdapter;
import android.location.LocationManager;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.luggage.p815f.p816a.C8865a;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.ipcinvoker.wx_extension.p1463a.C42142a;
import com.tencent.p177mm.ipcinvoker.wx_extension.p1463a.C42142a.C32718b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.storage.C5141c;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.e.m */
public final class C45594m extends C8865a {
    private static volatile Boolean hLa;

    /* renamed from: yh */
    public final boolean mo20057yh() {
        boolean z;
        AppMethodBeat.m2504i(131113);
        if (hLa != null) {
            hLa.booleanValue();
        } else {
            C42142a c42142a = C32718b.eGM;
            C5141c ll = C42142a.m74295ll("100459");
            if (ll == null) {
                C4990ab.m7416i("MicroMsg.TencentLocationManagerWxImp", "[sLocationLogOpen] item is null");
                hLa = Boolean.FALSE;
            } else {
                if (ll.isValid() && "true".equals(ll.dru().get("isLocationLogOpen"))) {
                    z = true;
                } else {
                    z = false;
                }
                hLa = Boolean.valueOf(z);
                C4990ab.m7417i("MicroMsg.TencentLocationManagerWxImp", "sLocationLogOpen:%b", hLa);
                hLa.booleanValue();
            }
        }
        z = hLa.booleanValue();
        AppMethodBeat.m2505o(131113);
        return z;
    }

    static {
        AppMethodBeat.m2504i(131114);
        try {
            C4990ab.m7417i("MicroMsg.TencentLocationManagerWxImp", "printBluetoothEnable open:%b", Boolean.valueOf(BluetoothAdapter.getDefaultAdapter().isEnabled()));
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.TencentLocationManagerWxImp", e, "", new Object[0]);
            C4990ab.m7416i("MicroMsg.TencentLocationManagerWxImp", "printBluetoothEnable fail");
        }
        try {
            LocationManager locationManager = (LocationManager) C4996ah.getContext().getSystemService(C8741b.LOCATION);
            if (locationManager != null) {
                boolean isProviderEnabled = locationManager.isProviderEnabled("gps");
                C4990ab.m7416i("MicroMsg.TencentLocationManagerWxImp", "isGPSEnable " + isProviderEnabled + ", isNetworkEnable:" + locationManager.isProviderEnabled(TencentLocation.NETWORK_PROVIDER));
            } else {
                C4990ab.m7412e("MicroMsg.TencentLocationManagerWxImp", "locationManager is null");
            }
        } catch (Exception e2) {
            C4990ab.printErrStackTrace("MicroMsg.TencentLocationManagerWxImp", e2, "", new Object[0]);
        }
        C4990ab.m7417i("MicroMsg.TencentLocationManagerWxImp", "Imei:%s", C1427q.m3026LK());
        AppMethodBeat.m2505o(131114);
    }
}
