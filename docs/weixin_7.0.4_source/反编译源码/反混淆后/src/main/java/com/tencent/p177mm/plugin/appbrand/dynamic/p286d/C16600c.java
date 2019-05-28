package com.tencent.p177mm.plugin.appbrand.dynamic.p286d;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p652z.p1101b.C40953b.C16115a;
import com.tencent.p177mm.p652z.p653c.C36405a;
import com.tencent.p177mm.plugin.appbrand.dynamic.p286d.p888a.C10200a;
import com.tencent.p177mm.plugin.appbrand.jsapi.p314q.C16674d;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.dynamic.d.c */
public final class C16600c extends C10200a {
    public C16600c(int i) {
        super(C16674d.NAME, i);
    }

    /* renamed from: a */
    public final void mo5955a(C36405a c36405a, JSONObject jSONObject, C16115a<JSONObject> c16115a) {
        AppMethodBeat.m2504i(10829);
        Context context = c36405a.getContext();
        HashMap hashMap = new HashMap();
        if (!C5023at.isConnected(context)) {
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
        c16115a.mo11732au(mo57327a(true, "", (Map) hashMap));
        AppMethodBeat.m2505o(10829);
    }
}
