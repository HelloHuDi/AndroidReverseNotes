package com.tencent.p177mm.plugin.appbrand.jsapi.base;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C37922v.C32800b;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33303e;
import com.tencent.p177mm.plugin.appbrand.page.C45663ac.C33466b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.base.c */
public abstract class C45578c<CONTEXT extends C33303e> extends C38268d<C2241c> {
    /* renamed from: a */
    static /* synthetic */ void m84090a(C45578c c45578c, C33303e c33303e, int i, JSONObject jSONObject) {
        boolean z = false;
        if (c45578c.aCF()) {
            try {
                C32800b J = c33303e.aBf().mo73439J(i, false);
                if (J != null) {
                    boolean z2 = jSONObject.getBoolean("disableScroll");
                    if (J.mo53357nX("isTouching")) {
                        String str = "disableScroll";
                        if (!z2) {
                            z = true;
                        }
                        if (J.getBoolean(str, z) != z2) {
                            J.mo53359z("disableScroll-nextState", z2);
                            return;
                        }
                        return;
                    }
                    J.mo53359z("disableScroll", z2);
                }
            } catch (JSONException e) {
            }
        }
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: c */
    public boolean mo6167c(CONTEXT context, int i, View view, JSONObject jSONObject) {
        return true;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: b */
    public boolean mo6138b(CONTEXT context, int i, View view, JSONObject jSONObject, C26932g c26932g) {
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

    /* renamed from: a */
    public final void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        final C33303e c = ((C10333f) c2241c.mo5936B(C10333f.class)).mo21784c(c2241c);
        if (c == null) {
            c2241c.mo6107M(i, mo73394j("fail:ComponentView is null.", null));
            return;
        }
        final C2241c c2241c2 = c2241c;
        final int i2 = i;
        final JSONObject jSONObject2 = jSONObject;
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(91047);
                if (c == null) {
                    C4990ab.m7420w("MicroMsg.BaseUpdateViewJsApi", "page view has been release.");
                    c2241c2.mo6107M(i2, C45578c.this.mo73394j("fail:page is null", null));
                    AppMethodBeat.m2505o(91047);
                    return;
                }
                try {
                    int r = C45578c.this.mo6130r(jSONObject2);
                    View q = c.aBf().mo73454q(r);
                    if (q == null) {
                        C4990ab.m7421w("MicroMsg.BaseUpdateViewJsApi", "get view by viewId(%s) return null.", Integer.valueOf(r));
                        c2241c2.mo6107M(i2, C45578c.this.mo73394j("fail:got 'null' when get view by the given viewId", null));
                        AppMethodBeat.m2505o(91047);
                        return;
                    }
                    boolean a;
                    int i;
                    C45578c.m84090a(C45578c.this, c, r, jSONObject2);
                    try {
                        a = c.aBf().mo73442a(r, C38268d.m64760s(jSONObject2), C38268d.m64761t(jSONObject2), C38268d.m64762u(jSONObject2), C38268d.m64763v(jSONObject2));
                        String str = "MicroMsg.BaseUpdateViewJsApi";
                        String str2 = "update view(parentId : %s, viewId : %d), ret : %b";
                        Object[] objArr = new Object[4];
                        C33466b py = c.aBf().mo73452py(r);
                        if (py == null) {
                            i = 0;
                        } else {
                            i = py.iuN;
                        }
                        objArr[0] = Integer.valueOf(i);
                        objArr[1] = Integer.valueOf(r);
                        objArr[2] = Integer.valueOf(q.hashCode());
                        objArr[3] = Boolean.valueOf(a);
                        C4990ab.m7417i(str, str2, objArr);
                    } catch (JSONException e) {
                        a = true;
                    }
                    boolean aCE = C45578c.this.aCE();
                    if (a) {
                        if (aCE) {
                            a = C45578c.this.mo6138b(c, r, q, jSONObject2, new C26932g(c2241c2, i2));
                        } else {
                            a = C45578c.this.mo6167c(c, r, q, jSONObject2);
                        }
                    }
                    if (!aCE) {
                        String str3;
                        C2241c c2241c = c2241c2;
                        i = i2;
                        C45578c c45578c = C45578c.this;
                        if (a) {
                            str3 = "ok";
                        } else {
                            str3 = "fail";
                        }
                        c2241c.mo6107M(i, c45578c.mo73394j(str3, null));
                    }
                    AppMethodBeat.m2505o(91047);
                } catch (JSONException e2) {
                    c2241c2.mo6107M(i2, C45578c.this.mo73394j("fail:view id do not exist", null));
                    AppMethodBeat.m2505o(91047);
                }
            }
        });
    }
}
