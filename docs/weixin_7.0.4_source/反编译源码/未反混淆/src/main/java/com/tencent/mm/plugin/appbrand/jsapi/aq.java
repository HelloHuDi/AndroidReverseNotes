package com.tencent.mm.plugin.appbrand.jsapi;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.graphics.Rect;
import android.location.LocationManager;
import android.net.wifi.WifiManager;
import android.support.v4.app.y;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.luggage.sdk.a.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.q.g;
import com.tencent.mm.plugin.appbrand.s.w;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.ui.ae;
import com.tencent.mm.ui.statusbar.a;
import java.util.HashMap;
import java.util.Map;

public class aq<C extends b> extends g<C> {
    public static final int CTRL_INDEX = 40;
    public static final String NAME = "getSystemInfo";
    private float hxe = -1.0f;

    public /* synthetic */ Map d(c cVar) {
        AppMethodBeat.i(101948);
        Map a = a((b) cVar);
        AppMethodBeat.o(101948);
        return a;
    }

    /* Access modifiers changed, original: protected */
    public Map<String, Object> a(C c) {
        AppMethodBeat.i(101947);
        Map d = super.d(c);
        int[] h = w.h(c);
        d.put("windowWidth", Integer.valueOf(com.tencent.mm.plugin.appbrand.r.g.pZ(h[0])));
        d.put("windowHeight", Integer.valueOf(com.tencent.mm.plugin.appbrand.r.g.pZ(h[1])));
        h = w.d(c);
        int i = h[0];
        int i2 = h[1];
        d.put("screenWidth", Integer.valueOf(com.tencent.mm.plugin.appbrand.r.g.pZ(i)));
        d.put("screenHeight", Integer.valueOf(com.tencent.mm.plugin.appbrand.r.g.pZ(i2)));
        int ay = a.ay(c.ad(Activity.class));
        if (ay <= 0) {
            ay = ae.getStatusBarHeight(c.getContext());
        }
        d.put("statusBarHeight", Integer.valueOf(com.tencent.mm.plugin.appbrand.r.g.pZ(ay)));
        d.put(FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE, aa.gw(c.getContext()));
        d.put("version", com.tencent.mm.sdk.platformtools.g.ar(null, f.xxY));
        d.put("benchmarkLevel", Integer.valueOf(c.xL().xZ().bQL));
        ay = c.getContext().getResources().getConfiguration().orientation;
        if (2 == ay) {
            d.put("deviceOrientation", "landscape");
        } else if (1 == ay) {
            d.put("deviceOrientation", "portrait");
        }
        if (this.hxe != -1.0f) {
            d.put("fontSizeSetting", Integer.valueOf((int) (this.hxe * 16.0f)));
        } else {
            float f = c.getContext().getSharedPreferences(ah.doA(), 0).getFloat("text_size_scale_key", 1.0f);
            d.put("fontSizeSetting", Integer.valueOf((int) (f * 16.0f)));
            this.hxe = f;
        }
        HashMap hashMap = new HashMap();
        Context context = c.getContext();
        if (context == null || !(context instanceof Activity)) {
            hashMap.put("wifiEnabled", Boolean.FALSE);
            hashMap.put("notificationAuthorized", Boolean.FALSE);
            hashMap.put("locationEnabled", Boolean.FALSE);
            hashMap.put("locationAuthorized", Boolean.FALSE);
            hashMap.put("cameraAuthorized", Boolean.FALSE);
            hashMap.put("microphoneAuthorized", Boolean.FALSE);
        } else {
            WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
            if (wifiManager != null) {
                hashMap.put("wifiEnabled", Boolean.valueOf(wifiManager.isWifiEnabled()));
            } else {
                hashMap.put("wifiEnabled", Boolean.FALSE);
            }
            hashMap.put("notificationAuthorized", Boolean.valueOf(y.L(context).areNotificationsEnabled()));
            LocationManager locationManager = (LocationManager) context.getSystemService(FirebaseAnalytics.b.LOCATION);
            if (locationManager != null) {
                hashMap.put("locationEnabled", Boolean.valueOf(locationManager.isProviderEnabled("gps")));
            } else {
                hashMap.put("locationEnabled", Boolean.FALSE);
            }
            try {
                hashMap.put("locationAuthorized", Boolean.valueOf(com.tencent.luggage.g.g.o(context, "android.permission.ACCESS_FINE_LOCATION")));
                hashMap.put("cameraAuthorized", Boolean.valueOf(com.tencent.luggage.g.g.o(context, "android.permission.CAMERA")));
                hashMap.put("microphoneAuthorized", Boolean.valueOf(com.tencent.luggage.g.g.o(context, "android.permission.RECORD_AUDIO")));
            } catch (Exception e) {
                ab.e("MicroMsg.JsApiGetSystemInfo", "check permissions exception", e);
                hashMap.put("locationAuthorized", Boolean.FALSE);
                hashMap.put("cameraAuthorized", Boolean.FALSE);
                hashMap.put("microphoneAuthorized", Boolean.FALSE);
            }
        }
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter != null) {
            hashMap.put("bluetoothEnabled", Boolean.valueOf(defaultAdapter.isEnabled()));
        } else {
            hashMap.put("bluetoothEnabled", Boolean.FALSE);
        }
        ab.i("MicroMsg.JsApiGetSystemInfo", "check permissions:%s", hashMap);
        d.putAll(hashMap);
        HashMap hashMap2 = new HashMap(6);
        if (c.ad(Activity.class) == null) {
            ab.w("MicroMsg.JsApiGetSystemInfo", "hy: can not retrieve UI!");
        } else {
            Rect d2 = ae.d(c.ad(Activity.class), i, i2);
            if (d2 != null) {
                i2 = com.tencent.mm.plugin.appbrand.r.g.pZ(d2.left);
                int pZ = com.tencent.mm.plugin.appbrand.r.g.pZ(d2.top);
                int pZ2 = com.tencent.mm.plugin.appbrand.r.g.pZ(d2.right);
                i = com.tencent.mm.plugin.appbrand.r.g.pZ(d2.bottom);
                hashMap2.put("left", Integer.valueOf(i2));
                hashMap2.put("top", Integer.valueOf(pZ));
                hashMap2.put("right", Integer.valueOf(pZ2));
                hashMap2.put("bottom", Integer.valueOf(i));
                hashMap2.put("width", Integer.valueOf(pZ2 - i2));
                hashMap2.put("height", Integer.valueOf(i - pZ));
                d.put("safeArea", hashMap2);
            }
        }
        AppMethodBeat.o(101947);
        return d;
    }
}
