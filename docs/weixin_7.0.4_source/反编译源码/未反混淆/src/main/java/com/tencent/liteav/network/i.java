package com.tencent.liteav.network;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONArray;
import org.json.JSONObject;

public class i {
    protected static i a = new i();
    private Context b = null;
    private long c = 3;

    protected class a {
        public float a = 0.0f;
        public float b = 0.0f;
        public float c = 0.0f;
        public float d = 0.0f;
        public long e = 0;

        protected a() {
        }
    }

    static {
        AppMethodBeat.i(67630);
        AppMethodBeat.o(67630);
    }

    public static i a() {
        return a;
    }

    protected i() {
    }

    public void a(Context context) {
        AppMethodBeat.i(67620);
        if (this.b == null) {
            this.b = context.getApplicationContext();
        }
        AppMethodBeat.o(67620);
    }

    public String b() {
        String str;
        AppMethodBeat.i(67621);
        try {
            if (this.b != null) {
                int c = b.c(this.b);
                if (c == 255) {
                    str = "";
                    AppMethodBeat.o(67621);
                    return str;
                } else if (c == 1) {
                    WifiManager wifiManager = (WifiManager) this.b.getSystemService("wifi");
                    if (wifiManager != null) {
                        WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                        if (connectionInfo != null) {
                            str = "wifi:" + connectionInfo.getSSID();
                            AppMethodBeat.o(67621);
                            return str;
                        }
                    }
                } else if (c == 2) {
                    str = "4g:";
                    AppMethodBeat.o(67621);
                    return str;
                } else if (c == 3) {
                    str = "3g:";
                    AppMethodBeat.o(67621);
                    return str;
                } else if (c == 4) {
                    str = "2g:";
                    AppMethodBeat.o(67621);
                    return str;
                } else if (c == 5) {
                    str = "ethernet:";
                    AppMethodBeat.o(67621);
                    return str;
                } else {
                    str = "xg:";
                    AppMethodBeat.o(67621);
                    return str;
                }
            }
        } catch (Exception e) {
        }
        str = "";
        AppMethodBeat.o(67621);
        return str;
    }

    public void a(String str, long j, long j2, long j3, float f, float f2, float f3) {
        AppMethodBeat.i(67622);
        if ((com.tencent.liteav.basic.f.b.a().a("Network", "QualityDataCacheCount") > 0 ? 1 : null) == null) {
            AppMethodBeat.o(67622);
            return;
        }
        TXCLog.e("UploadQualityData", String.format("updateQualityData: accessID = %s serverType = %d totalTime = %d networkRTT = %d avgBlockCnt = %f avgVideoQue = %f avgAudioQue = %f", new Object[]{str, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)}));
        if (b(str)) {
            AppMethodBeat.o(67622);
            return;
        }
        try {
            JSONObject jSONObject;
            Object jSONArray;
            SharedPreferences sharedPreferences = this.b.getSharedPreferences("com.tencent.liteav.network", 0);
            JSONObject c = c(sharedPreferences.getString("34238512-C08C-4931-A000-40E1D8B5BA5B", ""));
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
            if (((long) length) > this.c) {
                jSONArray = new JSONArray();
                for (int i = (int) (((long) length) - this.c); i < length; i++) {
                    jSONArray.put(optJSONArray.get(i));
                }
            } else {
                jSONArray = optJSONArray;
            }
            jSONObject.put(str2, jSONArray);
            c.put(str, jSONObject);
            sharedPreferences.edit().putString("34238512-C08C-4931-A000-40E1D8B5BA5B", c.toString()).commit();
            AppMethodBeat.o(67622);
        } catch (Exception e) {
            AppMethodBeat.o(67622);
        }
    }

    public boolean c() {
        AppMethodBeat.i(67623);
        d();
        String b = b();
        String str = "isDomainAddressBetter: accessID = " + b + " minQualityDataCount = " + this.c;
        a a = a(b, true);
        a a2 = a(b, false);
        if (a != null) {
            str = String.format("%s \n isDomainAddressBetter：domainQualityData count = %d avgNetworkRTT = %f avgBlockCount = %f avgVideoQueue = %f avgAudioQueue = %f", new Object[]{str, Long.valueOf(a.e), Float.valueOf(a.a), Float.valueOf(a.b), Float.valueOf(a.c), Float.valueOf(a.d)});
        }
        if (a2 != null) {
            str = String.format("%s \n isDomainAddressBetter：originQualityData count = %d avgNetworkRTT = %f avgBlockCount = %f avgVideoQueue = %f avgAudioQueue = %f", new Object[]{str, Long.valueOf(a2.e), Float.valueOf(a2.a), Float.valueOf(a2.b), Float.valueOf(a2.c), Float.valueOf(a2.d)});
        }
        TXCLog.e("UploadQualityData", str);
        if (a == null || a.e < this.c || a2 == null || a2.e < this.c) {
            AppMethodBeat.o(67623);
            return false;
        } else if (a.b >= a2.b || a.c >= a2.c || a.d >= a2.d) {
            AppMethodBeat.o(67623);
            return false;
        } else {
            AppMethodBeat.o(67623);
            return true;
        }
    }

    private a a(String str, boolean z) {
        AppMethodBeat.i(67624);
        if (b(str)) {
            AppMethodBeat.o(67624);
            return null;
        }
        try {
            String string = this.b.getSharedPreferences("com.tencent.liteav.network", 0).getString("34238512-C08C-4931-A000-40E1D8B5BA5B", "");
            if (b(string)) {
                AppMethodBeat.o(67624);
                return null;
            }
            JSONObject optJSONObject = new JSONObject(string).optJSONObject(str);
            if (optJSONObject == null) {
                AppMethodBeat.o(67624);
                return null;
            }
            JSONArray optJSONArray = optJSONObject.optJSONArray(z ? "DomainArrayData" : "OriginArrayData");
            if (optJSONArray == null) {
                AppMethodBeat.o(67624);
                return null;
            }
            long length = (long) optJSONArray.length();
            if (length == 0) {
                AppMethodBeat.o(67624);
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
            a aVar = new a();
            aVar.a = f;
            aVar.b = f2;
            aVar.c = f3;
            aVar.d = f4;
            aVar.e = length;
            AppMethodBeat.o(67624);
            return aVar;
        } catch (Exception e) {
            AppMethodBeat.o(67624);
            return null;
        }
    }

    private boolean b(String str) {
        AppMethodBeat.i(67625);
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(67625);
            return true;
        }
        AppMethodBeat.o(67625);
        return false;
    }

    private JSONObject c(String str) {
        JSONObject jSONObject;
        AppMethodBeat.i(67626);
        if (!b(str)) {
            try {
                jSONObject = new JSONObject(str);
                AppMethodBeat.o(67626);
                return jSONObject;
            } catch (Exception e) {
            }
        }
        jSONObject = new JSONObject();
        AppMethodBeat.o(67626);
        return jSONObject;
    }

    private void d() {
        AppMethodBeat.i(67627);
        this.c = com.tencent.liteav.basic.f.b.a().a("Network", "QualityDataCacheCount");
        if (this.c == -1 || this.c < 3) {
            this.c = 3;
        }
        AppMethodBeat.o(67627);
    }

    public long a(String str) {
        AppMethodBeat.i(67628);
        if (this.b != null) {
            long j = this.b.getSharedPreferences("com.tencent.liteav.network", 0).getLong(str, 0);
            AppMethodBeat.o(67628);
            return j;
        }
        AppMethodBeat.o(67628);
        return 0;
    }

    public void a(String str, long j) {
        AppMethodBeat.i(67629);
        if (this.b != null) {
            this.b.getSharedPreferences("com.tencent.liteav.network", 0).edit().putLong(str, j).commit();
        }
        AppMethodBeat.o(67629);
    }
}
