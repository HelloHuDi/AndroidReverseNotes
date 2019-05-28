package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONObject;

public final class aw extends a<u> {
    public static final int CTRL_INDEX = 0;
    public static final String NAME = "openLink";

    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(101950);
        u uVar = (u) cVar;
        String optString = jSONObject.optString("url");
        if (bo.isNullOrNil(optString)) {
            uVar.M(i, j("fail", null));
            AppMethodBeat.o(101950);
            return;
        }
        ((w) uVar.B(w.class)).a(uVar.mContext, optString, null);
        uVar.M(i, j("ok", null));
        AppMethodBeat.o(101950);
    }
}
