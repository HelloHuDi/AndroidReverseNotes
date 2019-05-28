package com.tencent.p177mm.plugin.appbrand.jsapi.fakenative;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C38450n;
import com.tencent.p177mm.plugin.appbrand.C41243o;
import com.tencent.p177mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33327h;
import com.tencent.p177mm.plugin.appbrand.jsapi.miniprogram_navigator.C33377e;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.fakenative.b */
public final class C2280b extends C33377e {
    /* renamed from: b */
    public final /* synthetic */ String mo6145b(C2241c c2241c, JSONObject jSONObject) {
        AppMethodBeat.m2504i(131028);
        String a = mo6157a((C33327h) c2241c, jSONObject);
        AppMethodBeat.m2505o(131028);
        return a;
    }

    /* renamed from: a */
    public final String mo6157a(C33327h c33327h, JSONObject jSONObject) {
        AppMethodBeat.m2504i(131027);
        if (c33327h.getRuntime() instanceof C41243o) {
            C41243o c41243o = (C41243o) c33327h.getRuntime();
            AppBrandLaunchReferrer appBrandLaunchReferrer = c41243o.atI().hgF;
            if (appBrandLaunchReferrer != null && appBrandLaunchReferrer.hgQ == 1 && OpenBusinessViewUtil.m30040l(c41243o)) {
                String optString = jSONObject.optString("extraData");
                C4990ab.m7417i("MicroMsg.JsApiNavigateBackMiniProgramWC", "navigate back MiniProgram, businessType:%s", appBrandLaunchReferrer.businessType);
                OpenBusinessViewUtil.m30038k(appBrandLaunchReferrer.businessType, C26968d.OK.errCode, optString);
                C38450n.m65049xb(c33327h.getAppId()).gPm = true;
            }
            OpenBusinessViewUtil.m30041m(c41243o);
        }
        String a = super.mo6157a(c33327h, jSONObject);
        AppMethodBeat.m2505o(131027);
        return a;
    }
}
