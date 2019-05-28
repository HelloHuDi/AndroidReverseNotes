package com.tencent.p177mm.plugin.appbrand.jsapi.p308i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C19497u;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.i.b */
public abstract class C10433b extends C19497u<C2241c> {
    /* renamed from: OA */
    public abstract String mo21946OA();

    /* renamed from: a */
    public abstract void mo21947a(C2241c c2241c, JSONObject jSONObject, String str);

    public abstract String aBA();

    /* renamed from: b */
    public final String mo6145b(final C2241c c2241c, final JSONObject jSONObject) {
        final String aBA = aBA();
        HashMap hashMap = new HashMap();
        hashMap.put(mo21946OA(), aBA);
        c2241c.aBy().post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(108019);
                C10433b.this.mo21947a(c2241c, jSONObject, aBA);
                AppMethodBeat.m2505o(108019);
            }
        });
        return mo73394j("ok", hashMap);
    }
}
