package com.tencent.p177mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.page.C44709u;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.aw */
public final class C16635aw extends C10296a<C44709u> {
    public static final int CTRL_INDEX = 0;
    public static final String NAME = "openLink";

    /* renamed from: a */
    public final /* synthetic */ void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(101950);
        C44709u c44709u = (C44709u) c2241c;
        String optString = jSONObject.optString("url");
        if (C5046bo.isNullOrNil(optString)) {
            c44709u.mo6107M(i, mo73394j("fail", null));
            AppMethodBeat.m2505o(101950);
            return;
        }
        ((C38402w) c44709u.mo5936B(C38402w.class)).mo20078a(c44709u.mContext, optString, null);
        c44709u.mo6107M(i, mo73394j("ok", null));
        AppMethodBeat.m2505o(101950);
    }
}
