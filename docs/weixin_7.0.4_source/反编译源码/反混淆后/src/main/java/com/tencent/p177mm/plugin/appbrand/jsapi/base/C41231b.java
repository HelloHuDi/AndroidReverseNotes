package com.tencent.p177mm.plugin.appbrand.jsapi.base;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33303e;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.base.b */
public abstract class C41231b<CONTEXT extends C33303e> extends C38268d<C2241c> {
    /* renamed from: a */
    public final void mo5994a(final C2241c c2241c, final JSONObject jSONObject, final int i) {
        if (C5004al.isMainThread()) {
            m71767b(c2241c, jSONObject, i);
        } else {
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(91046);
                    C41231b.this.m71767b(c2241c, jSONObject, i);
                    AppMethodBeat.m2505o(91046);
                }
            });
        }
    }

    /* renamed from: b */
    private void m71767b(C2241c c2241c, JSONObject jSONObject, int i) {
        if (c2241c.isRunning()) {
            C33303e m = C41231b.m71768m(c2241c);
            if (m == null) {
                C4990ab.m7421w("MicroMsg.BaseRemoveViewJsApi", "invoke JsApi(%s) failed, component view is null", getName());
                c2241c.mo6107M(i, mo73394j("fail:ComponentView is null.", null));
                return;
            }
            try {
                boolean pv;
                String str;
                int r = mo6130r(jSONObject);
                View q = m.aBf().mo73454q(r);
                if (m.aBf().mo73453pz(r)) {
                    pv = m.aBf().mo73450pv(r);
                    if (pv) {
                        pv = mo22053b(m, r, q, jSONObject);
                    }
                } else {
                    pv = false;
                }
                if (pv) {
                    m.aBf().mo73446pA(r);
                }
                C4990ab.m7417i("MicroMsg.BaseRemoveViewJsApi", "remove view(parentId : %s, viewId : %s, r : %s)", Integer.valueOf(jSONObject.optInt("parentId", 0)), Integer.valueOf(r), Boolean.valueOf(pv));
                if (pv) {
                    str = "ok";
                } else {
                    str = "fail";
                }
                c2241c.mo6107M(i, mo73394j(str, null));
                return;
            } catch (JSONException e) {
                C4990ab.m7413e("MicroMsg.BaseRemoveViewJsApi", "get viewId error. exception : %s", e);
                c2241c.mo6107M(i, mo73394j("fail:view id do not exist", null));
                return;
            }
        }
        c2241c.mo6107M(i, "fail:interrupted");
    }

    /* renamed from: m */
    private static C33303e m71768m(C2241c c2241c) {
        return ((C10333f) c2241c.mo5936B(C10333f.class)).mo21784c(c2241c);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: b */
    public boolean mo22053b(CONTEXT context, int i, View view, JSONObject jSONObject) {
        return true;
    }
}
