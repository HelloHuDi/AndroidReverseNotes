package com.tencent.liteav.network;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.p1169f.C45104b;
import com.tencent.liteav.basic.util.C17778b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.liteav.network.i */
public class C17801i {
    /* renamed from: a */
    protected static C17801i f4247a = new C17801i();
    /* renamed from: b */
    private Context f4248b = null;
    /* renamed from: c */
    private long f4249c = 3;

    /* renamed from: com.tencent.liteav.network.i$a */
    protected class C17802a {
        /* renamed from: a */
        public float f4250a = 0.0f;
        /* renamed from: b */
        public float f4251b = 0.0f;
        /* renamed from: c */
        public float f4252c = 0.0f;
        /* renamed from: d */
        public float f4253d = 0.0f;
        /* renamed from: e */
        public long f4254e = 0;

        protected C17802a() {
        }
    }

    static {
        AppMethodBeat.m2504i(67630);
        AppMethodBeat.m2505o(67630);
    }

    /* renamed from: a */
    public static C17801i m27844a() {
        return f4247a;
    }

    protected C17801i() {
    }

    /* renamed from: a */
    public void mo32953a(Context context) {
        AppMethodBeat.m2504i(67620);
        if (this.f4248b == null) {
            this.f4248b = context.getApplicationContext();
        }
        AppMethodBeat.m2505o(67620);
    }

    /* renamed from: b */
    public String mo32956b() {
        String str;
        AppMethodBeat.m2504i(67621);
        try {
            if (this.f4248b != null) {
                int c = C17778b.m27752c(this.f4248b);
                if (c == 255) {
                    str = "";
                    AppMethodBeat.m2505o(67621);
                    return str;
                } else if (c == 1) {
                    WifiManager wifiManager = (WifiManager) this.f4248b.getSystemService("wifi");
                    if (wifiManager != null) {
                        WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                        if (connectionInfo != null) {
                            str = "wifi:" + connectionInfo.getSSID();
                            AppMethodBeat.m2505o(67621);
                            return str;
                        }
                    }
                } else if (c == 2) {
                    str = "4g:";
                    AppMethodBeat.m2505o(67621);
                    return str;
                } else if (c == 3) {
                    str = "3g:";
                    AppMethodBeat.m2505o(67621);
                    return str;
                } else if (c == 4) {
                    str = "2g:";
                    AppMethodBeat.m2505o(67621);
                    return str;
                } else if (c == 5) {
                    str = "ethernet:";
                    AppMethodBeat.m2505o(67621);
                    return str;
                } else {
                    str = "xg:";
                    AppMethodBeat.m2505o(67621);
                    return str;
                }
            }
        } catch (Exception e) {
        }
        str = "";
        AppMethodBeat.m2505o(67621);
        return str;
    }

    /* renamed from: a */
    public void mo32955a(String str, long j, long j2, long j3, float f, float f2, float f3) {
        AppMethodBeat.m2504i(67622);
        if ((C45104b.m82752a().mo72874a("Network", "QualityDataCacheCount") > 0 ? 1 : null) == null) {
            AppMethodBeat.m2505o(67622);
            return;
        }
        TXCLog.m15676e("UploadQualityData", String.format("updateQualityData: accessID = %s serverType = %d totalTime = %d networkRTT = %d avgBlockCnt = %f avgVideoQue = %f avgAudioQue = %f", new Object[]{str, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)}));
        if (m27845b(str)) {
            AppMethodBeat.m2505o(67622);
            return;
        }
        try {
            JSONObject jSONObject;
            Object jSONArray;
            SharedPreferences sharedPreferences = this.f4248b.getSharedPreferences("com.tencent.liteav.network", 0);
            JSONObject c = m27846c(sharedPreferences.getString("34238512-C08C-4931-A000-40E1D8B5BA5B", ""));
            JSONObject optJSONObject = c.optJSONObject(str);
            if (optJSONObject == null) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = optJSONObject;
            }
            String str2 = j == 3 ? "DomainArrayData" : "OriginArrayData";
            JSONArray optJSONArray = jSONObject.optJSONArray(str2);
            if (optJSONArray == null) {
                optJSONArray = new JSONArray();
            }
            optJSONObject = new JSONObject();
            optJSONObject.put("totalTime", j2);
            optJSONObject.put("networkRTT", j3);
            optJSONObject.put("avgBlockCnt", (double) f);
            optJSONObject.put("avgVideoQue", (double) f2);
            optJSONObject.put("avgAudioQue", (double) f3);
            optJSONArray.put(optJSONObject);
            int length = optJSONArray.length();
            if (((long) length) > this.f4249c) {
                jSONArray = new JSONArray();
                for (int i = (int) (((long) length) - this.f4249c); i < length; i++) {
                    jSONArray.put(optJSONArray.get(i));
                }
            } else {
                jSONArray = optJSONArray;
            }
            jSONObject.put(str2, jSONArray);
            c.put(str, jSONObject);
            sharedPreferences.edit().putString("34238512-C08C-4931-A000-40E1D8B5BA5B", c.toString()).commit();
            AppMethodBeat.m2505o(67622);
        } catch (Exception e) {
            AppMethodBeat.m2505o(67622);
        }
    }

    /* renamed from: c */
    public boolean mo32957c() {
        AppMethodBeat.m2504i(67623);
        m27847d();
        String b = mo32956b();
        String str = "isDomainAddressBetter: accessID = " + b + " minQualityDataCount = " + this.f4249c;
        C17802a a = m27843a(b, true);
        C17802a a2 = m27843a(b, false);
        if (a != null) {
            str = String.format("%s \n isDomainAddressBetter：domainQualityData count = %d avgNetworkRTT = %f avgBlockCount = %f avgVideoQueue = %f avgAudioQueue = %f", new Object[]{str, Long.valueOf(a.f4254e), Float.valueOf(a.f4250a), Float.valueOf(a.f4251b), Float.valueOf(a.f4252c), Float.valueOf(a.f4253d)});
        }
        if (a2 != null) {
            str = String.format("%s \n isDomainAddressBetter：originQualityData count = %d avgNetworkRTT = %f avgBlockCount = %f avgVideoQueue = %f avgAudioQueue = %f", new Object[]{str, Long.valueOf(a2.f4254e), Float.valueOf(a2.f4250a), Float.valueOf(a2.f4251b), Float.valueOf(a2.f4252c), Float.valueOf(a2.f4253d)});
        }
        TXCLog.m15676e("UploadQualityData", str);
        if (a == null || a.f4254e < this.f4249c || a2 == null || a2.f4254e < this.f4249c) {
            AppMethodBeat.m2505o(67623);
            return false;
        } else if (a.f4251b >= a2.f4251b || a.f4252c >= a2.f4252c || a.f4253d >= a2.f4253d) {
            AppMethodBeat.m2505o(67623);
            return false;
        } else {
            AppMethodBeat.m2505o(67623);
            return true;
        }
    }

    /* renamed from: a */
    private C17802a m27843a(String str, boolean z) {
        AppMethodBeat.m2504i(67624);
        if (m27845b(str)) {
            AppMethodBeat.m2505o(67624);
            return null;
        }
        try {
            String string = this.f4248b.getSharedPreferences("com.tencent.liteav.network", 0).getString("34238512-C08C-4931-A000-40E1D8B5BA5B", "");
            if (m27845b(string)) {
                AppMethodBeat.m2505o(67624);
                return null;
            }
            JSONObject optJSONObject = new JSONObject(string).optJSONObject(str);
            if (optJSONObject == null) {
                AppMethodBeat.m2505o(67624);
                return null;
            }
            JSONArray optJSONArray = optJSONObject.optJSONArray(z ? "DomainArrayData" : "OriginArrayData");
            if (optJSONArray == null) {
                AppMethodBeat.m2505o(67624);
                return null;
            }
            long length = (long) optJSONArray.length();
            if (length == 0) {
                AppMethodBeat.m2505o(67624);
                return null;
            }
            String str2 = "";
            float f = 0.0f;
            float f2 = 0.0f;
            float f3 = 0.0f;
            float f4 = 0.0f;
            for (int i = 0; ((long) i) < length; i++) {
                JSONObject jSONObject = optJSONArray.getJSONObject(i);
                f += (float) jSONObject.optLong("networkRTT");
                f2 = (float) (((double) f2) + jSONObject.optDouble("avgBlockCnt"));
                f3 = (float) (((double) f3) + jSONObject.optDouble("avgVideoQue"));
                f4 = (float) (((double) f4) + jSONObject.optDouble("avgAudioQue"));
                str2 = String.format("%s \n isDomainAddressBetter：itemData domain = %b NetworkRTT = %d avgBlockCount = %f avgVideoQueue = %f avgAudioQueue = %f", new Object[]{str2, Boolean.valueOf(z), Long.valueOf(jSONObject.optLong("networkRTT")), Double.valueOf(jSONObject.optDouble("avgBlockCnt")), Double.valueOf(jSONObject.optDouble("avgVideoQue")), Double.valueOf(jSONObject.optDouble("avgAudioQue"))});
            }
            f /= (float) length;
            f2 /= (float) length;
            f3 /= (float) length;
            f4 /= (float) length;
            C17802a c17802a = new C17802a();
            c17802a.f4250a = f;
            c17802a.f4251b = f2;
            c17802a.f4252c = f3;
            c17802a.f4253d = f4;
            c17802a.f4254e = length;
            AppMethodBeat.m2505o(67624);
            return c17802a;
        } catch (Exception e) {
            AppMethodBeat.m2505o(67624);
            return null;
        }
    }

    /* renamed from: b */
    private boolean m27845b(String str) {
        AppMethodBeat.m2504i(67625);
        if (str == null || str.length() == 0) {
            AppMethodBeat.m2505o(67625);
            return true;
        }
        AppMethodBeat.m2505o(67625);
        return false;
    }

    /* renamed from: c */
    private JSONObject m27846c(String str) {
        JSONObject jSONObject;
        AppMethodBeat.m2504i(67626);
        if (!m27845b(str)) {
            try {
                jSONObject = new JSONObject(str);
                AppMethodBeat.m2505o(67626);
                return jSONObject;
            } catch (Exception e) {
            }
        }
        jSONObject = new JSONObject();
        AppMethodBeat.m2505o(67626);
        return jSONObject;
    }

    /* renamed from: d */
    private void m27847d() {
        AppMethodBeat.m2504i(67627);
        this.f4249c = C45104b.m82752a().mo72874a("Network", "QualityDataCacheCount");
        if (this.f4249c == -1 || this.f4249c < 3) {
            this.f4249c = 3;
        }
        AppMethodBeat.m2505o(67627);
    }

    /* renamed from: a */
    public long mo32952a(String str) {
        AppMethodBeat.m2504i(67628);
        if (this.f4248b != null) {
            long j = this.f4248b.getSharedPreferences("com.tencent.liteav.network", 0).getLong(str, 0);
            AppMethodBeat.m2505o(67628);
            return j;
        }
        AppMethodBeat.m2505o(67628);
        return 0;
    }

    /* renamed from: a */
    public void mo32954a(String str, long j) {
        AppMethodBeat.m2504i(67629);
        if (this.f4248b != null) {
            this.f4248b.getSharedPreferences("com.tencent.liteav.network", 0).edit().putLong(str, j).commit();
        }
        AppMethodBeat.m2505o(67629);
    }
}
