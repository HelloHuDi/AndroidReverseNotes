package com.tencent.mm.plugin.appbrand.jsapi.base;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class b<CONTEXT extends e> extends d<c> {
    public final void a(final c cVar, final JSONObject jSONObject, final int i) {
        if (al.isMainThread()) {
            b(cVar, jSONObject, i);
        } else {
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(91046);
                    b.this.b(cVar, jSONObject, i);
                    AppMethodBeat.o(91046);
                }
            });
        }
    }

    private void b(c cVar, JSONObject jSONObject, int i) {
        if (cVar.isRunning()) {
            e m = m(cVar);
            if (m == null) {
                ab.w("MicroMsg.BaseRemoveViewJsApi", "invoke JsApi(%s) failed, component view is null", getName());
                cVar.M(i, j("fail:ComponentView is null.", null));
                return;
            }
            try {
                boolean pv;
                String str;
                int r = r(jSONObject);
                View q = m.aBf().q(r);
                if (m.aBf().pz(r)) {
                    pv = m.aBf().pv(r);
                    if (pv) {
                        pv = b(m, r, q, jSONObject);
                    }
                } else {
                    pv = false;
                }
                if (pv) {
                    m.aBf().pA(r);
                }
                ab.i("MicroMsg.BaseRemoveViewJsApi", "remove view(parentId : %s, viewId : %s, r : %s)", Integer.valueOf(jSONObject.optInt("parentId", 0)), Integer.valueOf(r), Boolean.valueOf(pv));
                if (pv) {
                    str = "ok";
                } else {
                    str = "fail";
                }
                cVar.M(i, j(str, null));
                return;
            } catch (JSONException e) {
                ab.e("MicroMsg.BaseRemoveViewJsApi", "get viewId error. exception : %s", e);
                cVar.M(i, j("fail:view id do not exist", null));
                return;
            }
        }
        cVar.M(i, "fail:interrupted");
    }

    private static e m(c cVar) {
        return ((f) cVar.B(f.class)).c(cVar);
    }

    /* Access modifiers changed, original: protected */
    public boolean b(CONTEXT context, int i, View view, JSONObject jSONObject) {
        return true;
    }
}
