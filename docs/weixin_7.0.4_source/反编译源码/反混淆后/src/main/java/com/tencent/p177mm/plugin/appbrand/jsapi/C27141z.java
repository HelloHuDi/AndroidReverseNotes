package com.tencent.p177mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C10048a;
import com.tencent.p177mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.p177mm.plugin.appbrand.report.model.AdReportCgiHelper;
import com.tencent.p177mm.plugin.appbrand.report.model.AdReportCgiHelper.C19699a;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.z */
public final class C27141z extends C10296a {
    public static final int CTRL_INDEX = 435;
    public static final String NAME = "adDataReport";

    /* renamed from: a */
    public final void mo5994a(final C2241c c2241c, JSONObject jSONObject, final int i) {
        String str;
        AppMethodBeat.m2504i(130372);
        AppBrandStatObject wK = C10048a.m17637wK(c2241c.getAppId());
        if (wK != null) {
            str = wK.scene + "," + wK.cst + "," + wK.cOq + "," + wK.cOr + "," + jSONObject.optString("adInfo");
        } else {
            str = jSONObject.optString("adInfo");
        }
        AdReportCgiHelper.m54725a(15175, str + "," + C5046bo.m7552gN(C4996ah.getContext()), new C19699a() {
            public final void onDone() {
                AppMethodBeat.m2504i(130371);
                c2241c.mo6107M(i, C27141z.this.mo73394j("ok", null));
                AppMethodBeat.m2505o(130371);
            }
        });
        AppMethodBeat.m2505o(130372);
    }
}
