package com.tencent.mm.plugin.appbrand.jsapi.fakenative;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.e;
import com.tencent.mm.plugin.appbrand.n;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONObject;

public final class b extends e {
    public final /* synthetic */ String b(c cVar, JSONObject jSONObject) {
        AppMethodBeat.i(131028);
        String a = a((h) cVar, jSONObject);
        AppMethodBeat.o(131028);
        return a;
    }

    public final String a(h hVar, JSONObject jSONObject) {
        AppMethodBeat.i(131027);
        if (hVar.getRuntime() instanceof o) {
            o oVar = (o) hVar.getRuntime();
            AppBrandLaunchReferrer appBrandLaunchReferrer = oVar.atI().hgF;
            if (appBrandLaunchReferrer != null && appBrandLaunchReferrer.hgQ == 1 && OpenBusinessViewUtil.l(oVar)) {
                String optString = jSONObject.optString("extraData");
                ab.i("MicroMsg.JsApiNavigateBackMiniProgramWC", "navigate back MiniProgram, businessType:%s", appBrandLaunchReferrer.businessType);
                OpenBusinessViewUtil.k(appBrandLaunchReferrer.businessType, d.OK.errCode, optString);
                n.xb(hVar.getAppId()).gPm = true;
            }
            OpenBusinessViewUtil.m(oVar);
        }
        String a = super.a(hVar, jSONObject);
        AppMethodBeat.o(131027);
        return a;
    }
}
