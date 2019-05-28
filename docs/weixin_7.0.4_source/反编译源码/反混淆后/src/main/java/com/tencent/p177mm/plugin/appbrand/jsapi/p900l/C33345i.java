package com.tencent.p177mm.plugin.appbrand.jsapi.p900l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.plugin.appbrand.C19722s;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.p900l.C10443b.C10445b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.l.i */
public final class C33345i extends C10296a<C19722s> {
    public static final int CTRL_INDEX = 85;
    public static final String NAME = "verifyPaymentPassword";

    /* renamed from: a */
    public final /* synthetic */ void mo5994a(C2241c c2241c, JSONObject jSONObject, final int i) {
        AppMethodBeat.m2504i(131424);
        final C19722s c19722s = (C19722s) c2241c;
        if (jSONObject == null) {
            c19722s.mo6107M(i, mo73394j("fail", null));
            AppMethodBeat.m2505o(131424);
            return;
        }
        MMActivity mMActivity = (MMActivity) c19722s.mo61197ad(MMActivity.class);
        if (mMActivity == null) {
            c19722s.mo6107M(i, mo73394j("fail", null));
            AppMethodBeat.m2505o(131424);
            return;
        }
        try {
            jSONObject.put("appId", c19722s.getAppId());
            C42531a.hTJ.mo67991a(mMActivity, jSONObject, new C10445b() {
                /* renamed from: h */
                public final void mo21961h(boolean z, String str) {
                    AppMethodBeat.m2504i(131423);
                    if (z) {
                        HashMap hashMap = new HashMap(1);
                        hashMap.put("token", str);
                        c19722s.mo6107M(i, C33345i.this.mo73394j("ok", hashMap));
                        AppMethodBeat.m2505o(131423);
                        return;
                    }
                    c19722s.mo6107M(i, C33345i.this.mo73394j("fail", null));
                    AppMethodBeat.m2505o(131423);
                }
            });
            AppMethodBeat.m2505o(131424);
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.JsApiVerifyPaymentPassword", e.getMessage());
            c19722s.mo6107M(i, mo73394j("fail", null));
            AppMethodBeat.m2505o(131424);
        }
    }
}
