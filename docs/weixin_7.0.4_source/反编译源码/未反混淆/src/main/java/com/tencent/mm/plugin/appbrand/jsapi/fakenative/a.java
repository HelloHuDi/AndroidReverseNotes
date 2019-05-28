package com.tencent.mm.plugin.appbrand.jsapi.fakenative;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.n;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import org.json.JSONObject;

public final class a extends com.tencent.mm.plugin.appbrand.jsapi.a<h> {
    public static final int CTRL_INDEX = 593;
    public static final String NAME = "navigateBackH5";

    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(131026);
        h hVar = (h) cVar;
        AppBrandLaunchReferrer appBrandLaunchReferrer = hVar.getRuntime().yf().hgF;
        HashMap hashMap;
        if (appBrandLaunchReferrer == null || appBrandLaunchReferrer.hgQ != 2) {
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(-2));
            ab.i("MicroMsg.JsApiNavigateBackH5", "fail the MiniProgram is not from a HTML5 page");
            hVar.M(i, j("fail the MiniProgram is not from a HTML5 page", hashMap));
            AppMethodBeat.o(131026);
        } else if ((hVar.getRuntime() instanceof o) && OpenBusinessViewUtil.l((o) hVar.getRuntime())) {
            String str = appBrandLaunchReferrer.businessType;
            String optString = jSONObject.optString("extraData");
            ab.i("MicroMsg.JsApiNavigateBackH5", "navigate back H5, businessType:%s", str);
            OpenBusinessViewUtil.p(str, optString, 0);
            n.xb(hVar.getAppId()).gPl = true;
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(0));
            hVar.M(i, j("ok", hashMap));
            hVar.getRuntime().finish();
            AppMethodBeat.o(131026);
        } else {
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(-1));
            ab.i("MicroMsg.JsApiNavigateBackH5", "fail system error");
            hVar.M(i, j("fail system error", hashMap));
            AppMethodBeat.o(131026);
        }
    }
}
