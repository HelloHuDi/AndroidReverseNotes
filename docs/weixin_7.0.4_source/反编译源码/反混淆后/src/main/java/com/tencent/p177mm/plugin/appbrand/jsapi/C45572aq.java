package com.tencent.p177mm.plugin.appbrand.jsapi;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.graphics.Rect;
import android.location.LocationManager;
import android.net.wifi.WifiManager;
import android.support.p057v4.app.C17432y;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.luggage.p147g.C0991g;
import com.tencent.luggage.sdk.p819a.p820a.C45126b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.C5222ae;
import com.tencent.p177mm.p612ui.statusbar.C5540a;
import com.tencent.p177mm.plugin.appbrand.jsapi.p314q.C38372g;
import com.tencent.p177mm.plugin.appbrand.p328r.C42668g;
import com.tencent.p177mm.plugin.appbrand.p329s.C10732w;
import com.tencent.p177mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5058f;
import com.tencent.p177mm.sdk.platformtools.C5059g;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.aq */
public class C45572aq<C extends C45126b> extends C38372g<C> {
    public static final int CTRL_INDEX = 40;
    public static final String NAME = "getSystemInfo";
    private float hxe = -1.0f;

    /* renamed from: d */
    public /* synthetic */ Map mo61033d(C2241c c2241c) {
        AppMethodBeat.m2504i(101948);
        Map a = mo67966a((C45126b) c2241c);
        AppMethodBeat.m2505o(101948);
        return a;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: a */
    public Map<String, Object> mo67966a(C c) {
        AppMethodBeat.m2504i(101947);
        Map d = super.mo61033d(c);
        int[] h = C10732w.m18405h(c);
        d.put("windowWidth", Integer.valueOf(C42668g.m75569pZ(h[0])));
        d.put("windowHeight", Integer.valueOf(C42668g.m75569pZ(h[1])));
        h = C10732w.m18403d(c);
        int i = h[0];
        int i2 = h[1];
        d.put("screenWidth", Integer.valueOf(C42668g.m75569pZ(i)));
        d.put("screenHeight", Integer.valueOf(C42668g.m75569pZ(i2)));
        int ay = C5540a.m8359ay(c.mo61197ad(Activity.class));
        if (ay <= 0) {
            ay = C5222ae.getStatusBarHeight(c.getContext());
        }
        d.put("statusBarHeight", Integer.valueOf(C42668g.m75569pZ(ay)));
        d.put(FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE, C4988aa.m7403gw(c.getContext()));
        d.put("version", C5059g.m7672ar(null, C5058f.xxY));
        d.put("benchmarkLevel", Integer.valueOf(c.mo34954xL().mo43489xZ().bQL));
        ay = c.getContext().getResources().getConfiguration().orientation;
        if (2 == ay) {
            d.put("deviceOrientation", "landscape");
        } else if (1 == ay) {
            d.put("deviceOrientation", "portrait");
        }
        if (this.hxe != -1.0f) {
            d.put("fontSizeSetting", Integer.valueOf((int) (this.hxe * 16.0f)));
        } else {
            float f = c.getContext().getSharedPreferences(C4996ah.doA(), 0).getFloat("text_size_scale_key", 1.0f);
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
            hashMap.put("notificationAuthorized", Boolean.valueOf(C17432y.m27074L(context).areNotificationsEnabled()));
            LocationManager locationManager = (LocationManager) context.getSystemService(C8741b.LOCATION);
            if (locationManager != null) {
                hashMap.put("locationEnabled", Boolean.valueOf(locationManager.isProviderEnabled("gps")));
            } else {
                hashMap.put("locationEnabled", Boolean.FALSE);
            }
            try {
                hashMap.put("locationAuthorized", Boolean.valueOf(C0991g.m2253o(context, "android.permission.ACCESS_FINE_LOCATION")));
                hashMap.put("cameraAuthorized", Boolean.valueOf(C0991g.m2253o(context, "android.permission.CAMERA")));
                hashMap.put("microphoneAuthorized", Boolean.valueOf(C0991g.m2253o(context, "android.permission.RECORD_AUDIO")));
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.JsApiGetSystemInfo", "check permissions exception", e);
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
        C4990ab.m7417i("MicroMsg.JsApiGetSystemInfo", "check permissions:%s", hashMap);
        d.putAll(hashMap);
        HashMap hashMap2 = new HashMap(6);
        if (c.mo61197ad(Activity.class) == null) {
            C4990ab.m7420w("MicroMsg.JsApiGetSystemInfo", "hy: can not retrieve UI!");
        } else {
            Rect d2 = C5222ae.m7938d(c.mo61197ad(Activity.class), i, i2);
            if (d2 != null) {
                i2 = C42668g.m75569pZ(d2.left);
                int pZ = C42668g.m75569pZ(d2.top);
                int pZ2 = C42668g.m75569pZ(d2.right);
                i = C42668g.m75569pZ(d2.bottom);
                hashMap2.put("left", Integer.valueOf(i2));
                hashMap2.put("top", Integer.valueOf(pZ));
                hashMap2.put("right", Integer.valueOf(pZ2));
                hashMap2.put("bottom", Integer.valueOf(i));
                hashMap2.put("width", Integer.valueOf(pZ2 - i2));
                hashMap2.put("height", Integer.valueOf(i - pZ));
                d.put("safeArea", hashMap2);
            }
        }
        AppMethodBeat.m2505o(101947);
        return d;
    }
}
