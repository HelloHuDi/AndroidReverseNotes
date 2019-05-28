package com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import org.json.JSONArray;

public final class c {
    public String hAa = "ok";
    public List<b> ido = null;

    public final String toString() {
        AppMethodBeat.i(94381);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("mErrorMsg:");
        stringBuilder.append(this.hAa);
        stringBuilder.append(" mWifiList:");
        if (this.ido == null || this.ido.size() <= 0) {
            stringBuilder.append("null:");
        } else {
            for (b bVar : this.ido) {
                stringBuilder.append(" WiFiItem:");
                stringBuilder.append(bVar);
            }
        }
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.o(94381);
        return stringBuilder2;
    }

    public final JSONArray aGx() {
        AppMethodBeat.i(94382);
        JSONArray jSONArray = new JSONArray();
        for (b toJSONObject : this.ido) {
            jSONArray.put(toJSONObject.toJSONObject());
        }
        AppMethodBeat.o(94382);
        return jSONArray;
    }
}
