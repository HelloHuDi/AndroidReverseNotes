package com.p081b.p082a.p083a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.hardware.SensorManager;
import android.location.LocationManager;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.util.Base64;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.actions.SearchIntents;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.b.a.a.f */
public final class C37152f {
    private final WifiManager bCU;
    private final LocationManager bCV;
    final SensorManager bCW;
    final PackageManager bCX;
    PackageInfo bCY;
    String bCZ;
    String bDa;
    String bDb;
    private int bDc = 0;
    private int bDd = 0;
    int bDe = 0;
    int bDf = 0;
    int bDg = 0;
    int bDh = 0;
    String imei;
    final Context mContext;
    private String source = "203";
    private String version = "2.0.1";
    String versionName;

    public C37152f(Context context) {
        AppMethodBeat.m2504i(55536);
        this.mContext = context;
        this.bCU = (WifiManager) this.mContext.getSystemService("wifi");
        this.bCV = (LocationManager) this.mContext.getSystemService(C8741b.LOCATION);
        this.bCW = (SensorManager) this.mContext.getSystemService("sensor");
        this.bCX = this.mContext.getPackageManager();
        this.bCY = new PackageInfo();
        try {
            this.bCY = this.bCX.getPackageInfo(this.mContext.getPackageName(), 0);
            AppMethodBeat.m2505o(55536);
        } catch (NameNotFoundException e) {
            AppMethodBeat.m2505o(55536);
        }
    }

    /* renamed from: t */
    public final String mo59233t(byte[] bArr) {
        int i;
        int i2 = 1;
        AppMethodBeat.m2504i(55537);
        HashMap hashMap = new HashMap();
        hashMap.put("version", this.version);
        hashMap.put(NativeProtocol.BRIDGE_ARG_APP_NAME_STRING, C37152f.m62241bo(this.versionName));
        if (this.bCZ != null) {
            hashMap.put("app_label", C37152f.m62241bo(Base64.encodeToString(this.bCZ.getBytes(), 0)));
        } else {
            hashMap.put("app_label", "");
        }
        String str = "chips";
        if (m62242wa()) {
            i = 1;
        } else {
            i = 0;
        }
        this.bDd = i;
        if (this.bCU == null || !this.bCU.isWifiEnabled()) {
            i = 0;
        } else {
            i = 1;
        }
        if ((i | m62243wb()) == 0) {
            i2 = 0;
        }
        this.bDc = i2;
        hashMap.put(str, Integer.toBinaryString((((((this.bDh | 0) | (this.bDg << 1)) | (this.bDf << 2)) | (this.bDe << 3)) | (this.bDd << 4)) | (this.bDc << 5)));
        hashMap.put("source", this.source);
        hashMap.put(SearchIntents.EXTRA_QUERY, new String(bArr));
        try {
            HashMap hashMap2 = new HashMap();
            hashMap2.put("model", C37152f.m62241bo(Base64.encodeToString(this.bDa.getBytes(), 0)));
            hashMap2.put("version", C37152f.m62241bo(this.bDb));
            hashMap2.put("imei", C37152f.m62241bo(this.imei));
            String jSONObject = new JSONObject(hashMap).put("attribute", new JSONObject(hashMap2)).toString();
            AppMethodBeat.m2505o(55537);
            return jSONObject;
        } catch (JSONException e) {
            AppMethodBeat.m2505o(55537);
            return null;
        }
    }

    /* renamed from: bo */
    private static String m62241bo(String str) {
        if (str == null) {
            return "";
        }
        return str;
    }

    /* renamed from: wa */
    private boolean m62242wa() {
        AppMethodBeat.m2504i(55538);
        boolean z = false;
        try {
            z = this.bCV.isProviderEnabled("gps");
        } catch (Exception e) {
        }
        AppMethodBeat.m2505o(55538);
        return z;
    }

    @SuppressLint({"NewApi"})
    /* renamed from: wb */
    private boolean m62243wb() {
        AppMethodBeat.m2504i(55539);
        boolean z = false;
        if (this.bCU != null) {
            z = this.bCU.isWifiEnabled();
            if (!z) {
                try {
                    if (VERSION.SDK_INT >= 18) {
                        z = this.bCU.isScanAlwaysAvailable();
                    }
                } catch (Error | Exception e) {
                }
            }
        }
        AppMethodBeat.m2505o(55539);
        return z;
    }
}
