package com.tencent.p177mm.plugin.appbrand.jsapi.miniprogram_navigator;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.MiniProgramNavigationBackResult;
import com.tencent.p177mm.plugin.appbrand.jsapi.C19497u;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33327h;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.e */
public class C33377e extends C19497u<C33327h> {
    public static final int CTRL_INDEX = 252;
    public static final String NAME = "navigateBackMiniProgram";

    /* renamed from: b */
    public /* synthetic */ String mo6145b(C2241c c2241c, JSONObject jSONObject) {
        AppMethodBeat.m2504i(101982);
        String a = mo6157a((C33327h) c2241c, jSONObject);
        AppMethodBeat.m2505o(101982);
        return a;
    }

    /* renamed from: a */
    public String mo6157a(C33327h c33327h, JSONObject jSONObject) {
        AppMethodBeat.m2504i(101981);
        c33327h.getRuntime().mo14979a(MiniProgramNavigationBackResult.m64438a(jSONObject.optJSONObject("extraData"), jSONObject.optJSONObject("privateExtraData")));
        String j = mo73394j("ok", null);
        AppMethodBeat.m2505o(101981);
        return j;
    }
}
