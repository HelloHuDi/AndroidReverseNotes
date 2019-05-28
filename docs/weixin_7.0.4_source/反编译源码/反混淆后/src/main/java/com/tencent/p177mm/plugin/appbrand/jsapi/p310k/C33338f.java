package com.tencent.p177mm.plugin.appbrand.jsapi.p310k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C19497u;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.page.C44709u;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.k.f */
public final class C33338f extends C19497u<C44709u> {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "initReady";

    /* renamed from: b */
    public final /* synthetic */ String mo6145b(C2241c c2241c, JSONObject jSONObject) {
        AppMethodBeat.m2504i(86971);
        ((C44709u) c2241c).onReady();
        String j = mo73394j("ok", null);
        AppMethodBeat.m2505o(86971);
        return j;
    }
}
