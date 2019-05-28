package com.tencent.p177mm.plugin.appbrand.jsapi.wifi.wifisdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import org.json.JSONArray;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.c */
public final class C27137c {
    public String hAa = "ok";
    public List<C19528b> ido = null;

    public final String toString() {
        AppMethodBeat.m2504i(94381);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("mErrorMsg:");
        stringBuilder.append(this.hAa);
        stringBuilder.append(" mWifiList:");
        if (this.ido == null || this.ido.size() <= 0) {
            stringBuilder.append("null:");
        } else {
            for (C19528b c19528b : this.ido) {
                stringBuilder.append(" WiFiItem:");
                stringBuilder.append(c19528b);
            }
        }
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.m2505o(94381);
        return stringBuilder2;
    }

    public final JSONArray aGx() {
        AppMethodBeat.m2504i(94382);
        JSONArray jSONArray = new JSONArray();
        for (C19528b toJSONObject : this.ido) {
            jSONArray.put(toJSONObject.toJSONObject());
        }
        AppMethodBeat.m2505o(94382);
        return jSONArray;
    }
}
