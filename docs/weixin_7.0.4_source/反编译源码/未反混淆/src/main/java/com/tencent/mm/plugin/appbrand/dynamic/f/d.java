package com.tencent.mm.plugin.appbrand.dynamic.f;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.z.b.c;
import java.util.HashMap;
import org.json.JSONObject;

public final class d extends c {
    public d() {
        super("onNetworkStatusChange");
    }

    d(int i) {
        super("onNetworkStatusChange", i);
    }

    public final JSONObject toJSONObject() {
        AppMethodBeat.i(10913);
        HashMap hashMap = new HashMap();
        Context context = ah.getContext();
        boolean isConnected = at.isConnected(context);
        hashMap.put("isConnected", Boolean.valueOf(isConnected));
        if (!isConnected) {
            hashMap.put("networkType", "none");
        } else if (at.is2G(context)) {
            hashMap.put("networkType", "2g");
        } else if (at.is3G(context)) {
            hashMap.put("networkType", "3g");
        } else if (at.is4G(context)) {
            hashMap.put("networkType", "4g");
        } else if (at.isWifi(context)) {
            hashMap.put("networkType", "wifi");
        } else {
            hashMap.put("networkType", "unknown");
        }
        JSONObject jSONObject = new JSONObject(hashMap);
        AppMethodBeat.o(10913);
        return jSONObject;
    }
}
