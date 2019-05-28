package com.tencent.p177mm.plugin.offline.p478a;

import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.offline.a.g */
public final class C39468g extends C46117h {
    public C39468g(String str, String str2, String str3) {
        Object obj;
        AppMethodBeat.m2504i(43396);
        HashMap hashMap = new HashMap();
        hashMap.put("buss_type", str);
        hashMap.put(C8741b.METHOD, str2);
        String str4 = TencentLocation.NETWORK_PROVIDER;
        if (C5023at.isWifi(C4996ah.getContext())) {
            obj = "wifi";
        } else if (C5023at.is3G(C4996ah.getContext())) {
            obj = "3g";
        } else if (C5023at.is2G(C4996ah.getContext())) {
            obj = "2g";
        } else if (C5023at.isWap(C4996ah.getContext())) {
            obj = "wap";
        } else if (C5023at.is4G(C4996ah.getContext())) {
            obj = "4g";
        } else {
            obj = "unknown";
        }
        hashMap.put(str4, obj);
        hashMap.put("transactionid", str3);
        mo74062M(hashMap);
        AppMethodBeat.m2505o(43396);
    }

    public final int bgI() {
        return 122;
    }

    /* renamed from: a */
    public final void mo36860a(int i, String str, JSONObject jSONObject) {
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/datareport";
    }

    /* renamed from: ZU */
    public final int mo36859ZU() {
        return 1602;
    }
}
