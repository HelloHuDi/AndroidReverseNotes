package com.tencent.p177mm.plugin.appbrand.jsapi.wifi.wifisdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.b */
public final class C19528b {
    public String idi = "";
    public String idj = "";
    public int idk;
    public boolean idl = false;
    public boolean idm = false;
    public boolean idn = false;

    public final String toString() {
        AppMethodBeat.m2504i(94379);
        String str = "WiFiItem{mSsid='" + this.idi + '\'' + ", mBssid='" + this.idj + '\'' + ", mSignalStrength=" + this.idk + ", mSecurity=" + this.idl + '}';
        AppMethodBeat.m2505o(94379);
        return str;
    }

    public final JSONObject toJSONObject() {
        AppMethodBeat.m2504i(94380);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("SSID", this.idi);
        jSONObject.put("BSSID", this.idj);
        jSONObject.put("secure", this.idl);
        jSONObject.put("signalStrength", this.idk);
        AppMethodBeat.m2505o(94380);
        return jSONObject;
    }
}
