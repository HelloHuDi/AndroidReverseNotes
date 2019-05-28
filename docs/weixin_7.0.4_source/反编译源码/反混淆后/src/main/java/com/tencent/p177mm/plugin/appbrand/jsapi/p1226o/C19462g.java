package com.tencent.p177mm.plugin.appbrand.jsapi.p1226o;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.plugin.appbrand.C41243o;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33327h;
import com.tencent.p177mm.plugin.appbrand.page.C27242w;
import com.tencent.p177mm.plugin.appbrand.report.AppBrandIDKeyBatchReport;
import com.tencent.p177mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.p177mm.plugin.appbrand.report.C19690c;
import com.tencent.p177mm.plugin.appbrand.report.model.C2440i;
import com.tencent.p177mm.plugin.appbrand.report.model.C2440i.C2441a;
import com.tencent.p177mm.protocal.protobuf.cwt;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.o.g */
public final class C19462g extends C10296a<C33327h> {
    public static final int CTRL_INDEX = 108;
    public static final String NAME = "reportRealtimeAction";

    /* renamed from: a */
    public final /* synthetic */ void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(131432);
        C33327h c33327h = (C33327h) c2241c;
        try {
            C27242w c27242w;
            C2441a k;
            int i2;
            C41243o c41243o = (C41243o) c33327h.getRuntime();
            if (c33327h instanceof C27242w) {
                c27242w = (C27242w) c33327h;
            } else {
                c27242w = (C27242w) ((C38492q) c33327h).mo61196ac(C27242w.class);
            }
            String optString = jSONObject.optString("actionData");
            cwt cwt = new cwt();
            cwt.jCt = 2;
            cwt.fKh = c41243o.mAppId;
            cwt.pXC = 0;
            cwt.lvf = (int) C5046bo.anT();
            cwt.pXD = 0;
            cwt.xsp = optString;
            cwt.xsq = c41243o.atH().hhd.gVt + 1;
            cwt.xsr = C19690c.m30503cV(C4996ah.getContext());
            cwt.vGA = c41243o.atI().mo32993xz();
            AppBrandStatObject appBrandStatObject = c41243o.mo43491ya().bQn;
            cwt.ugc = appBrandStatObject.scene;
            cwt.xst = appBrandStatObject.cst;
            cwt.cOq = appBrandStatObject.cOq;
            cwt.cOr = appBrandStatObject.cOr;
            cwt.xss = appBrandStatObject.iAo;
            C2440i aHX = c41243o.atJ().getReporter().aHX();
            if (c27242w != null) {
                k = aHX.mo6357k(c27242w);
            } else {
                k = aHX.aLo();
            }
            cwt.xso = k.path;
            cwt.iBB = k.iBm == null ? null : k.iBm.path;
            if (aHX.mo6355DC(k.path)) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            cwt.iBG = i2;
            C4990ab.m7417i("MicroMsg.JsApiReportRealtimeAction", "report(%s), path %s, appState %d, sessionId %s, scene %d, sceneNote %s, preScene %d, preSceneNote %s, usedState %d, referPath %s, isEntrance %d", c41243o.mAppId, cwt.xso, Integer.valueOf(cwt.xsq), cwt.vGA, Integer.valueOf(cwt.ugc), cwt.xst, Integer.valueOf(cwt.cOq), cwt.cOr, Integer.valueOf(cwt.xss), cwt.iBB, Integer.valueOf(cwt.iBG));
            AppBrandIDKeyBatchReport.m30482a(cwt);
            c33327h.mo6107M(i, mo73394j("ok", null));
            AppMethodBeat.m2505o(131432);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.JsApiReportRealtimeAction", "report by service(%s), e = %s", c33327h.getAppId(), e);
            c33327h.mo6107M(i, mo73394j("fail:internal error", null));
            AppMethodBeat.m2505o(131432);
        }
    }
}
