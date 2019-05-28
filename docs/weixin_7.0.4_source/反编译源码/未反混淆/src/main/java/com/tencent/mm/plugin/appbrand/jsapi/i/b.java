package com.tencent.mm.plugin.appbrand.jsapi.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.u;
import java.util.HashMap;
import org.json.JSONObject;

public abstract class b extends u<c> {
    public abstract String OA();

    public abstract void a(c cVar, JSONObject jSONObject, String str);

    public abstract String aBA();

    public final String b(final c cVar, final JSONObject jSONObject) {
        final String aBA = aBA();
        HashMap hashMap = new HashMap();
        hashMap.put(OA(), aBA);
        cVar.aBy().post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(108019);
                b.this.a(cVar, jSONObject, aBA);
                AppMethodBeat.o(108019);
            }
        });
        return j("ok", hashMap);
    }
}
