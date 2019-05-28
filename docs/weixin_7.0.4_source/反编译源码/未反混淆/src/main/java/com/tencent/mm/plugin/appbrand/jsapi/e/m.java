package com.tencent.mm.plugin.appbrand.jsapi.e;

import android.bluetooth.BluetoothAdapter;
import android.location.LocationManager;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.luggage.f.a.a;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.ipcinvoker.wx_extension.a.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.storage.c;

public final class m extends a {
    private static volatile Boolean hLa;

    public final boolean yh() {
        boolean z;
        AppMethodBeat.i(131113);
        if (hLa != null) {
            hLa.booleanValue();
        } else {
            com.tencent.mm.ipcinvoker.wx_extension.a.a aVar = b.eGM;
            c ll = com.tencent.mm.ipcinvoker.wx_extension.a.a.ll("100459");
            if (ll == null) {
                ab.i("MicroMsg.TencentLocationManagerWxImp", "[sLocationLogOpen] item is null");
                hLa = Boolean.FALSE;
            } else {
                if (ll.isValid() && "true".equals(ll.dru().get("isLocationLogOpen"))) {
                    z = true;
                } else {
                    z = false;
                }
                hLa = Boolean.valueOf(z);
                ab.i("MicroMsg.TencentLocationManagerWxImp", "sLocationLogOpen:%b", hLa);
                hLa.booleanValue();
            }
        }
        z = hLa.booleanValue();
        AppMethodBeat.o(131113);
        return z;
    }

    static {
        AppMethodBeat.i(131114);
        try {
            ab.i("MicroMsg.TencentLocationManagerWxImp", "printBluetoothEnable open:%b", Boolean.valueOf(BluetoothAdapter.getDefaultAdapter().isEnabled()));
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.TencentLocationManagerWxImp", e, "", new Object[0]);
            ab.i("MicroMsg.TencentLocationManagerWxImp", "printBluetoothEnable fail");
        }
        try {
            LocationManager locationManager = (LocationManager) ah.getContext().getSystemService(FirebaseAnalytics.b.LOCATION);
            if (locationManager != null) {
                boolean isProviderEnabled = locationManager.isProviderEnabled("gps");
                ab.i("MicroMsg.TencentLocationManagerWxImp", "isGPSEnable " + isProviderEnabled + ", isNetworkEnable:" + locationManager.isProviderEnabled(TencentLocation.NETWORK_PROVIDER));
            } else {
                ab.e("MicroMsg.TencentLocationManagerWxImp", "locationManager is null");
            }
        } catch (Exception e2) {
            ab.printErrStackTrace("MicroMsg.TencentLocationManagerWxImp", e2, "", new Object[0]);
        }
        ab.i("MicroMsg.TencentLocationManagerWxImp", "Imei:%s", q.LK());
        AppMethodBeat.o(131114);
    }
}
