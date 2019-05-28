package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.a;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.model.AdReportCgiHelper;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONObject;

public final class z extends a {
    public static final int CTRL_INDEX = 435;
    public static final String NAME = "adDataReport";

    public final void a(final c cVar, JSONObject jSONObject, final int i) {
        String str;
        AppMethodBeat.i(130372);
        AppBrandStatObject wK = a.wK(cVar.getAppId());
        if (wK != null) {
            str = wK.scene + "," + wK.cst + "," + wK.cOq + "," + wK.cOr + "," + jSONObject.optString("adInfo");
        } else {
            str = jSONObject.optString("adInfo");
        }
        AdReportCgiHelper.a(15175, str + "," + bo.gN(ah.getContext()), new AdReportCgiHelper.a() {
            public final void onDone() {
                AppMethodBeat.i(130371);
                cVar.M(i, z.this.j("ok", null));
                AppMethodBeat.o(130371);
            }
        });
        AppMethodBeat.o(130372);
    }
}
