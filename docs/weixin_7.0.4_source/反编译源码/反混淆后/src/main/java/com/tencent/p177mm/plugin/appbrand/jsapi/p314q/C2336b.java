package com.tencent.p177mm.plugin.appbrand.jsapi.p314q;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C19497u;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.p329s.p330a.C2456a;
import com.tencent.p177mm.plugin.appbrand.p329s.p330a.C45679c;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.q.b */
public final class C2336b extends C19497u {
    public static final int CTRL_INDEX = 425;
    public static final String NAME = "getBatteryInfo";

    /* renamed from: b */
    public final String mo6145b(C2241c c2241c, JSONObject jSONObject) {
        AppMethodBeat.m2504i(126405);
        C45679c aOb = C2456a.iRU.aOb();
        HashMap hashMap = new HashMap();
        hashMap.put("level", Integer.valueOf(aOb.iSe));
        hashMap.put("isCharging", Boolean.valueOf(aOb.iSd));
        String j = mo73394j("ok", hashMap);
        AppMethodBeat.m2505o(126405);
        return j;
    }
}
