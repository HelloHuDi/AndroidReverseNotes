package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONObject;

public final class ba extends a<q> {
    public static final int CTRL_INDEX = 201;
    public static final String NAME = "openUrl";

    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(101951);
        q qVar = (q) cVar;
        String optString = jSONObject.optString("url");
        if (!bo.isNullOrNil(optString)) {
            Context context = qVar.getContext();
            if (context != null) {
                ((w) qVar.B(w.class)).a(context, optString, null);
                qVar.M(i, j("ok", null));
                AppMethodBeat.o(101951);
                return;
            }
        }
        qVar.M(i, j("fail", null));
        AppMethodBeat.o(101951);
    }
}
