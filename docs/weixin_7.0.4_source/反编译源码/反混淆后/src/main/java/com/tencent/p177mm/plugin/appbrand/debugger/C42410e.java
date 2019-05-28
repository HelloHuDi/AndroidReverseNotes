package com.tencent.p177mm.plugin.appbrand.debugger;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C19497u;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33327h;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.debugger.e */
public final class C42410e extends C19497u<C33327h> {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "remoteDebugInfo";

    /* renamed from: b */
    public final /* synthetic */ String mo6145b(C2241c c2241c, JSONObject jSONObject) {
        AppMethodBeat.m2504i(101822);
        C33327h c33327h = (C33327h) c2241c;
        String j;
        if (c33327h.getRuntime().mo15032xT() instanceof C26849i) {
            ((C26849i) c33327h.getRuntime().mo15032xT()).mo44623zH(jSONObject.toString());
            j = mo73394j("ok", null);
            AppMethodBeat.m2505o(101822);
            return j;
        }
        j = mo73394j("fail:not debug", null);
        AppMethodBeat.m2505o(101822);
        return j;
    }
}
