package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import com.google.android.gms.actions.SearchIntents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.protocal.protobuf.bzx;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONObject;

public final class av extends a<q> {
    public static final int CTRL_INDEX = 247;
    public static final String NAME = "openDeliveryList";

    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(101949);
        q qVar = (q) cVar;
        String optString = jSONObject.optString(SearchIntents.EXTRA_QUERY);
        if (!bo.isNullOrNil(optString)) {
            String concat = "https://mp.weixin.qq.com/bizmall/expressentry".concat(String.valueOf(optString));
            bzx bzx = new bzx();
            bzx.wYT = true;
            bzx.wYS = true;
            Context context = qVar.getContext();
            if (context != null) {
                ((w) qVar.B(w.class)).a(context, concat, bzx);
                qVar.M(i, j("ok", null));
                AppMethodBeat.o(101949);
                return;
            }
        }
        qVar.M(i, j("fail", null));
        AppMethodBeat.o(101949);
    }
}
