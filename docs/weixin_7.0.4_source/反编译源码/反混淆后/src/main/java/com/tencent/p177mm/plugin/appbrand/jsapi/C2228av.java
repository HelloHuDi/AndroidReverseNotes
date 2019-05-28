package com.tencent.p177mm.plugin.appbrand.jsapi;

import android.content.Context;
import com.google.android.gms.actions.SearchIntents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.protocal.protobuf.bzx;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.av */
public final class C2228av extends C10296a<C38492q> {
    public static final int CTRL_INDEX = 247;
    public static final String NAME = "openDeliveryList";

    /* renamed from: a */
    public final /* synthetic */ void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(101949);
        C38492q c38492q = (C38492q) c2241c;
        String optString = jSONObject.optString(SearchIntents.EXTRA_QUERY);
        if (!C5046bo.isNullOrNil(optString)) {
            String concat = "https://mp.weixin.qq.com/bizmall/expressentry".concat(String.valueOf(optString));
            bzx bzx = new bzx();
            bzx.wYT = true;
            bzx.wYS = true;
            Context context = c38492q.getContext();
            if (context != null) {
                ((C38402w) c38492q.mo5936B(C38402w.class)).mo20078a(context, concat, bzx);
                c38492q.mo6107M(i, mo73394j("ok", null));
                AppMethodBeat.m2505o(101949);
                return;
            }
        }
        c38492q.mo6107M(i, mo73394j("fail", null));
        AppMethodBeat.m2505o(101949);
    }
}
