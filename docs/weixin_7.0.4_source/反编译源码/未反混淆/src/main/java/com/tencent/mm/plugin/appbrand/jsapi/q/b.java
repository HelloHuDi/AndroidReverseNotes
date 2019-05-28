package com.tencent.mm.plugin.appbrand.jsapi.q;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.u;
import com.tencent.mm.plugin.appbrand.s.a.a;
import java.util.HashMap;
import org.json.JSONObject;

public final class b extends u {
    public static final int CTRL_INDEX = 425;
    public static final String NAME = "getBatteryInfo";

    public final String b(c cVar, JSONObject jSONObject) {
        AppMethodBeat.i(126405);
        com.tencent.mm.plugin.appbrand.s.a.c aOb = a.iRU.aOb();
        HashMap hashMap = new HashMap();
        hashMap.put("level", Integer.valueOf(aOb.iSe));
        hashMap.put("isCharging", Boolean.valueOf(aOb.iSd));
        String j = j("ok", hashMap);
        AppMethodBeat.o(126405);
        return j;
    }
}
