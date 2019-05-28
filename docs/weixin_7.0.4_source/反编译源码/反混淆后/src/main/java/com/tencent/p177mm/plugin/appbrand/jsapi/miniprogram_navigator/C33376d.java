package com.tencent.p177mm.plugin.appbrand.jsapi.miniprogram_navigator;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.plugin.appbrand.jsapi.C19497u;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.d */
public final class C33376d extends C19497u<C38492q> {
    static final int CTRL_INDEX = 191;
    public static final String NAME = "exitMiniProgram";

    /* renamed from: b */
    public final /* synthetic */ String mo6145b(C2241c c2241c, JSONObject jSONObject) {
        AppMethodBeat.m2504i(101980);
        String c = mo53856c((C38492q) c2241c);
        AppMethodBeat.m2505o(101980);
        return c;
    }

    /* renamed from: c */
    public final String mo53856c(C38492q c38492q) {
        AppMethodBeat.m2504i(101979);
        c38492q.getRuntime().finish();
        String j = mo73394j("ok", null);
        AppMethodBeat.m2505o(101979);
        return j;
    }
}
