package com.tencent.p177mm.plugin.appbrand.jsapi.p900l;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.plugin.appbrand.C19722s;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.p900l.C10443b.C10444a;
import com.tencent.p177mm.plugin.appbrand.jsapi.p900l.C42531a.C425323;
import com.tencent.p177mm.pluginsdk.wallet.C35899h;
import com.tencent.p177mm.pluginsdk.wallet.C40493g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.l.c */
public final class C16668c extends C10296a<C19722s> {
    public static final int CTRL_INDEX = 86;
    public static final String NAME = "bindPaymentCard";

    /* renamed from: a */
    public final /* synthetic */ void mo5994a(C2241c c2241c, JSONObject jSONObject, final int i) {
        AppMethodBeat.m2504i(131412);
        final C19722s c19722s = (C19722s) c2241c;
        if (jSONObject == null) {
            c19722s.mo6107M(i, mo73394j("fail", null));
            AppMethodBeat.m2505o(131412);
            return;
        }
        MMActivity mMActivity = (MMActivity) c19722s.mo61197ad(MMActivity.class);
        if (mMActivity == null) {
            c19722s.mo6107M(i, mo73394j("fail", null));
            AppMethodBeat.m2505o(131412);
            return;
        }
        try {
            jSONObject.put("appId", c19722s.getAppId());
            C42531a c42531a = C42531a.hTJ;
            C425323 c425323 = new C425323(new C10444a() {
                /* renamed from: a */
                public final void mo21960a(int i, String str, Map<String, Object> map) {
                    AppMethodBeat.m2504i(131411);
                    switch (i) {
                        case 1:
                            c19722s.mo6107M(i, C16668c.this.mo73394j("ok", null));
                            AppMethodBeat.m2505o(131411);
                            return;
                        default:
                            c19722s.mo6107M(i, C16668c.this.mo73394j("fail", null));
                            AppMethodBeat.m2505o(131411);
                            return;
                    }
                }
            });
            C40493g c40493g = new C40493g(jSONObject);
            c40493g.cIg = 4;
            C35899h.m58865b(mMActivity, c40493g, c42531a.hashCode() & CdnLogic.kBizGeneric, c425323);
            AppMethodBeat.m2505o(131412);
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.JsApiBindPaymentCard", e.getMessage());
            c19722s.mo6107M(i, mo73394j("fail", null));
            AppMethodBeat.m2505o(131412);
        }
    }
}
