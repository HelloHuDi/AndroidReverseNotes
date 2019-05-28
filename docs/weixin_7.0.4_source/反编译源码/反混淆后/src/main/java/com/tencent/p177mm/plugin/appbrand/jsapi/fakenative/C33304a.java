package com.tencent.p177mm.plugin.appbrand.jsapi.fakenative;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C38450n;
import com.tencent.p177mm.plugin.appbrand.C41243o;
import com.tencent.p177mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33327h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.fakenative.a */
public final class C33304a extends C10296a<C33327h> {
    public static final int CTRL_INDEX = 593;
    public static final String NAME = "navigateBackH5";

    /* renamed from: a */
    public final /* synthetic */ void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(131026);
        C33327h c33327h = (C33327h) c2241c;
        AppBrandLaunchReferrer appBrandLaunchReferrer = c33327h.getRuntime().mo15035yf().hgF;
        HashMap hashMap;
        if (appBrandLaunchReferrer == null || appBrandLaunchReferrer.hgQ != 2) {
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(-2));
            C4990ab.m7416i("MicroMsg.JsApiNavigateBackH5", "fail the MiniProgram is not from a HTML5 page");
            c33327h.mo6107M(i, mo73394j("fail the MiniProgram is not from a HTML5 page", hashMap));
            AppMethodBeat.m2505o(131026);
        } else if ((c33327h.getRuntime() instanceof C41243o) && OpenBusinessViewUtil.m30040l((C41243o) c33327h.getRuntime())) {
            String str = appBrandLaunchReferrer.businessType;
            String optString = jSONObject.optString("extraData");
            C4990ab.m7417i("MicroMsg.JsApiNavigateBackH5", "navigate back H5, businessType:%s", str);
            OpenBusinessViewUtil.m30043p(str, optString, 0);
            C38450n.m65049xb(c33327h.getAppId()).gPl = true;
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(0));
            c33327h.mo6107M(i, mo73394j("ok", hashMap));
            c33327h.getRuntime().finish();
            AppMethodBeat.m2505o(131026);
        } else {
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(-1));
            C4990ab.m7416i("MicroMsg.JsApiNavigateBackH5", "fail system error");
            c33327h.mo6107M(i, mo73394j("fail system error", hashMap));
            AppMethodBeat.m2505o(131026);
        }
    }
}
