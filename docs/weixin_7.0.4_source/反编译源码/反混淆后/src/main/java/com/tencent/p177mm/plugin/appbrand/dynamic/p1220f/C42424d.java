package com.tencent.p177mm.plugin.appbrand.dynamic.p1220f;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p652z.p1101b.C46727c;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.dynamic.f.d */
public final class C42424d extends C46727c {
    public C42424d() {
        super("onNetworkStatusChange");
    }

    C42424d(int i) {
        super("onNetworkStatusChange", i);
    }

    public final JSONObject toJSONObject() {
        AppMethodBeat.m2504i(10913);
        HashMap hashMap = new HashMap();
        Context context = C4996ah.getContext();
        boolean isConnected = C5023at.isConnected(context);
        hashMap.put("isConnected", Boolean.valueOf(isConnected));
        if (!isConnected) {
            hashMap.put("networkType", "none");
        } else if (C5023at.is2G(context)) {
            hashMap.put("networkType", "2g");
        } else if (C5023at.is3G(context)) {
            hashMap.put("networkType", "3g");
        } else if (C5023at.is4G(context)) {
            hashMap.put("networkType", "4g");
        } else if (C5023at.isWifi(context)) {
            hashMap.put("networkType", "wifi");
        } else {
            hashMap.put("networkType", "unknown");
        }
        JSONObject jSONObject = new JSONObject(hashMap);
        AppMethodBeat.m2505o(10913);
        return jSONObject;
    }
}
