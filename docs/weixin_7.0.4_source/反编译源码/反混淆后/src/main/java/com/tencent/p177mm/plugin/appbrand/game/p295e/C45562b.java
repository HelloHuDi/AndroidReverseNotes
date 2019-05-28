package com.tencent.p177mm.plugin.appbrand.game.p295e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C19722s;
import com.tencent.p177mm.plugin.appbrand.config.p283a.C26835a;
import com.tencent.p177mm.plugin.appbrand.config.p283a.C26835a.C26836a;
import com.tencent.p177mm.plugin.appbrand.config.p283a.C26835a.C26839b;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.game.e.b */
final class C45562b extends C10296a<C19722s> {
    public static final int CTRL_INDEX = 395;
    public static final String NAME = "setDeviceOrientation";

    /* renamed from: a */
    public final /* synthetic */ void mo5994a(C2241c c2241c, JSONObject jSONObject, final int i) {
        AppMethodBeat.m2504i(130192);
        final C19722s c19722s = (C19722s) c2241c;
        if (jSONObject == null) {
            c19722s.mo6107M(i, mo73394j("fail", null));
            AppMethodBeat.m2505o(130192);
            return;
        }
        C26839b yV = C26835a.m42719yV(jSONObject.optString("value", null));
        if (yV == null) {
            c19722s.mo6107M(i, mo73394j("fail", null));
            AppMethodBeat.m2505o(130192);
        } else if (c19722s.getRuntime() == null || c19722s.getRuntime().atM() == null) {
            c19722s.mo6107M(i, mo73394j("fail", null));
            AppMethodBeat.m2505o(130192);
        } else {
            C26835a.m42717t(c19722s.getRuntime().atM()).mo44609a(yV, new C26836a() {
                /* renamed from: a */
                public final void mo3966a(C26839b c26839b, boolean z) {
                    String str;
                    AppMethodBeat.m2504i(130191);
                    C19722s c19722s = c19722s;
                    int i = i;
                    C45562b c45562b = C45562b.this;
                    if (z) {
                        str = "ok";
                    } else {
                        str = "fail";
                    }
                    c19722s.mo6107M(i, c45562b.mo73394j(str, null));
                    AppMethodBeat.m2505o(130191);
                }
            });
            AppMethodBeat.m2505o(130192);
        }
    }

    C45562b() {
    }
}
