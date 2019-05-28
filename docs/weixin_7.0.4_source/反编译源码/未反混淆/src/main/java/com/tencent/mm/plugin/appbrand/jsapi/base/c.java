package com.tencent.mm.plugin.appbrand.jsapi.base;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.v.b;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class c<CONTEXT extends e> extends d<com.tencent.mm.plugin.appbrand.jsapi.c> {
    static /* synthetic */ void a(c cVar, e eVar, int i, JSONObject jSONObject) {
        boolean z = false;
        if (cVar.aCF()) {
            try {
                b J = eVar.aBf().J(i, false);
                if (J != null) {
                    boolean z2 = jSONObject.getBoolean("disableScroll");
                    if (J.nX("isTouching")) {
                        String str = "disableScroll";
                        if (!z2) {
                            z = true;
                        }
                        if (J.getBoolean(str, z) != z2) {
                            J.z("disableScroll-nextState", z2);
                            return;
                        }
                        return;
                    }
                    J.z("disableScroll", z2);
                }
            } catch (JSONException e) {
            }
        }
    }

    /* Access modifiers changed, original: protected */
    public boolean c(CONTEXT context, int i, View view, JSONObject jSONObject) {
        return true;
    }

    /* Access modifiers changed, original: protected */
    public boolean b(CONTEXT context, int i, View view, JSONObject jSONObject, g gVar) {
        return true;
    }

    /* Access modifiers changed, original: protected */
    public boolean aCF() {
        return false;
    }

    /* Access modifiers changed, original: protected */
    public boolean aCE() {
        return false;
    }

    public final void a(com.tencent.mm.plugin.appbrand.jsapi.c cVar, JSONObject jSONObject, int i) {
        final e c = ((f) cVar.B(f.class)).c(cVar);
        if (c == null) {
            cVar.M(i, j("fail:ComponentView is null.", null));
            return;
        }
        final com.tencent.mm.plugin.appbrand.jsapi.c cVar2 = cVar;
        final int i2 = i;
        final JSONObject jSONObject2 = jSONObject;
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(91047);
                if (c == null) {
                    ab.w("MicroMsg.BaseUpdateViewJsApi", "page view has been release.");
                    cVar2.M(i2, c.this.j("fail:page is null", null));
                    AppMethodBeat.o(91047);
                    return;
                }
                try {
                    int r = c.this.r(jSONObject2);
                    View q = c.aBf().q(r);
                    if (q == null) {
                        ab.w("MicroMsg.BaseUpdateViewJsApi", "get view by viewId(%s) return null.", Integer.valueOf(r));
                        cVar2.M(i2, c.this.j("fail:got 'null' when get view by the given viewId", null));
                        AppMethodBeat.o(91047);
                        return;
                    }
                    boolean a;
                    int i;
                    c.a(c.this, c, r, jSONObject2);
                    try {
                        a = c.aBf().a(r, d.s(jSONObject2), d.t(jSONObject2), d.u(jSONObject2), d.v(jSONObject2));
                        String str = "MicroMsg.BaseUpdateViewJsApi";
                        String str2 = "update view(parentId : %s, viewId : %d), ret : %b";
                        Object[] objArr = new Object[4];
                        ac.b py = c.aBf().py(r);
                        if (py == null) {
                            i = 0;
                        } else {
                            i = py.iuN;
                        }
                        objArr[0] = Integer.valueOf(i);
                        objArr[1] = Integer.valueOf(r);
                        objArr[2] = Integer.valueOf(q.hashCode());
                        objArr[3] = Boolean.valueOf(a);
                        ab.i(str, str2, objArr);
                    } catch (JSONException e) {
                        a = true;
                    }
                    boolean aCE = c.this.aCE();
                    if (a) {
                        if (aCE) {
                            a = c.this.b(c, r, q, jSONObject2, new g(cVar2, i2));
                        } else {
                            a = c.this.c(c, r, q, jSONObject2);
                        }
                    }
                    if (!aCE) {
                        String str3;
                        com.tencent.mm.plugin.appbrand.jsapi.c cVar = cVar2;
                        i = i2;
                        c cVar2 = c.this;
                        if (a) {
                            str3 = "ok";
                        } else {
                            str3 = "fail";
                        }
                        cVar.M(i, cVar2.j(str3, null));
                    }
                    AppMethodBeat.o(91047);
                } catch (JSONException e2) {
                    cVar2.M(i2, c.this.j("fail:view id do not exist", null));
                    AppMethodBeat.o(91047);
                }
            }
        });
    }
}
