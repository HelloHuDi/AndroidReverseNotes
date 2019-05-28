package com.tencent.mm.plugin.appbrand.jsapi.o;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.w;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.report.AppBrandIDKeyBatchReport;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.model.i;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONObject;

public final class g extends a<h> {
    public static final int CTRL_INDEX = 108;
    public static final String NAME = "reportRealtimeAction";

    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(131432);
        h hVar = (h) cVar;
        try {
            w wVar;
            i.a k;
            int i2;
            o oVar = (o) hVar.getRuntime();
            if (hVar instanceof w) {
                wVar = (w) hVar;
            } else {
                wVar = (w) ((q) hVar).ac(w.class);
            }
            String optString = jSONObject.optString("actionData");
            cwt cwt = new cwt();
            cwt.jCt = 2;
            cwt.fKh = oVar.mAppId;
            cwt.pXC = 0;
            cwt.lvf = (int) bo.anT();
            cwt.pXD = 0;
            cwt.xsp = optString;
            cwt.xsq = oVar.atH().hhd.gVt + 1;
            cwt.xsr = com.tencent.mm.plugin.appbrand.report.c.cV(ah.getContext());
            cwt.vGA = oVar.atI().xz();
            AppBrandStatObject appBrandStatObject = oVar.ya().bQn;
            cwt.ugc = appBrandStatObject.scene;
            cwt.xst = appBrandStatObject.cst;
            cwt.cOq = appBrandStatObject.cOq;
            cwt.cOr = appBrandStatObject.cOr;
            cwt.xss = appBrandStatObject.iAo;
            i aHX = oVar.atJ().getReporter().aHX();
            if (wVar != null) {
                k = aHX.k(wVar);
            } else {
                k = aHX.aLo();
            }
            cwt.xso = k.path;
            cwt.iBB = k.iBm == null ? null : k.iBm.path;
            if (aHX.DC(k.path)) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            cwt.iBG = i2;
            ab.i("MicroMsg.JsApiReportRealtimeAction", "report(%s), path %s, appState %d, sessionId %s, scene %d, sceneNote %s, preScene %d, preSceneNote %s, usedState %d, referPath %s, isEntrance %d", oVar.mAppId, cwt.xso, Integer.valueOf(cwt.xsq), cwt.vGA, Integer.valueOf(cwt.ugc), cwt.xst, Integer.valueOf(cwt.cOq), cwt.cOr, Integer.valueOf(cwt.xss), cwt.iBB, Integer.valueOf(cwt.iBG));
            AppBrandIDKeyBatchReport.a(cwt);
            hVar.M(i, j("ok", null));
            AppMethodBeat.o(131432);
        } catch (Exception e) {
            ab.e("MicroMsg.JsApiReportRealtimeAction", "report by service(%s), e = %s", hVar.getAppId(), e);
            hVar.M(i, j("fail:internal error", null));
            AppMethodBeat.o(131432);
        }
    }
}
