package com.tencent.mm.plugin.offline.a;

import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import java.util.HashMap;
import org.json.JSONObject;

public final class g extends h {
    public g(String str, String str2, String str3) {
        Object obj;
        AppMethodBeat.i(43396);
        HashMap hashMap = new HashMap();
        hashMap.put("buss_type", str);
        hashMap.put(b.METHOD, str2);
        String str4 = TencentLocation.NETWORK_PROVIDER;
        if (at.isWifi(ah.getContext())) {
            obj = "wifi";
        } else if (at.is3G(ah.getContext())) {
            obj = "3g";
        } else if (at.is2G(ah.getContext())) {
            obj = "2g";
        } else if (at.isWap(ah.getContext())) {
            obj = "wap";
        } else if (at.is4G(ah.getContext())) {
            obj = "4g";
        } else {
            obj = "unknown";
        }
        hashMap.put(str4, obj);
        hashMap.put("transactionid", str3);
        M(hashMap);
        AppMethodBeat.o(43396);
    }

    public final int bgI() {
        return 122;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/datareport";
    }

    public final int ZU() {
        return 1602;
    }
}
