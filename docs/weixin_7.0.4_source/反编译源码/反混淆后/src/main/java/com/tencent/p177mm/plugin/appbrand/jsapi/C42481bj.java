package com.tencent.p177mm.plugin.appbrand.jsapi;

import com.tencent.luggage.sdk.p819a.p820a.C45126b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.menu.MenuDelegate_EnableDebug;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.bj */
public final class C42481bj extends C10296a<C45126b> {
    public static final int CTRL_INDEX = 249;
    public static final String NAME = "setEnableDebug";

    /* renamed from: a */
    public final /* synthetic */ void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(101954);
        C45126b c45126b = (C45126b) c2241c;
        boolean optBoolean = jSONObject.optBoolean("enableDebug", false);
        if (c45126b.mo34954xL().mo43489xZ().bQp == optBoolean) {
            c45126b.mo6107M(i, mo73394j("ok", null));
            AppMethodBeat.m2505o(101954);
            return;
        }
        MenuDelegate_EnableDebug.m84308f(c45126b.getContext(), c45126b.getAppId(), optBoolean);
        c45126b.mo6107M(i, mo73394j("ok", null));
        AppMethodBeat.m2505o(101954);
    }
}
