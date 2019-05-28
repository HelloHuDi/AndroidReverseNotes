package com.tencent.mm.plugin.appbrand.jsapi.base;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.v.b;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class a<CONTEXT extends e> extends d<c> {

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.base.a$2 */
    class AnonymousClass2 implements f.c {
        final /* synthetic */ b hAt;
        final /* synthetic */ e hCK;
        final /* synthetic */ int hCN;

        AnonymousClass2(e eVar, int i, b bVar) {
            this.hCK = eVar;
            this.hCN = i;
            this.hAt = bVar;
        }

        public final void onDestroy() {
            AppMethodBeat.i(91045);
            this.hCK.b((f.c) this);
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(91044);
                    AnonymousClass2.this.hCK.aBf().pv(AnonymousClass2.this.hCN);
                    AppMethodBeat.o(91044);
                }
            });
            this.hCK.aBf().pA(this.hCN);
            this.hAt.recycle();
            System.gc();
            AppMethodBeat.o(91045);
        }
    }

    /* Access modifiers changed, original: protected */
    public View a(CONTEXT context, JSONObject jSONObject, int i) {
        return a(context, jSONObject);
    }

    /* Access modifiers changed, original: protected */
    public View a(CONTEXT context, JSONObject jSONObject) {
        throw new IllegalStateException("inflateView must be inflated");
    }

    /* Access modifiers changed, original: protected */
    public void a(CONTEXT context, int i, View view, JSONObject jSONObject) {
    }

    /* Access modifiers changed, original: protected */
    public void a(CONTEXT context, int i, View view, JSONObject jSONObject, g gVar) {
    }

    /* Access modifiers changed, original: protected */
    public boolean aCE() {
        return false;
    }

    /* Access modifiers changed, original: protected */
    public boolean aCF() {
        return false;
    }

    /* Access modifiers changed, original: protected */
    public boolean aCG() {
        return false;
    }

    public void a(c cVar, final JSONObject jSONObject, int i) {
        final e c = ((f) cVar.B(f.class)).c(cVar);
        if (c == null) {
            ab.w("MicroMsg.BaseInsertViewJsApi", "invoke JsApi(%s) failed, component view is null", getName());
            cVar.M(i, j("fail:ComponentView is null.", null));
            return;
        }
        final g gVar = new g(cVar, i);
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(91043);
                if (c.isRunning()) {
                    try {
                        int r = a.this.r(jSONObject);
                        View a = a.this.a(c, jSONObject, r);
                        if (a == null) {
                            ab.w("MicroMsg.BaseInsertViewJsApi", "inflate view return null.");
                            gVar.AR(a.this.j("inflate view failed", null));
                            AppMethodBeat.o(91043);
                            return;
                        } else if (c.aBf().pz(r)) {
                            ab.w("MicroMsg.BaseInsertViewJsApi", "insert view(%d) failed, it has been inserted before.", Integer.valueOf(r));
                            gVar.AR(a.this.j("fail:the view has already exist", null));
                            AppMethodBeat.o(91043);
                            return;
                        } else {
                            boolean a2;
                            int optInt = jSONObject.optInt("parentId", 0);
                            try {
                                float[] s = d.s(jSONObject);
                                int t = d.t(jSONObject);
                                Boolean u = d.u(jSONObject);
                                Boolean v = d.v(jSONObject);
                                ac aBf = c.aBf();
                                boolean z = u != null && u.booleanValue();
                                boolean z2 = v != null && v.booleanValue();
                                a2 = aBf.a(a, r, optInt, s, t, z, z2);
                            } catch (JSONException e) {
                                ab.e("MicroMsg.BaseInsertViewJsApi", "parse position error. Exception :%s", e);
                                a2 = false;
                            }
                            boolean aCE = a.this.aCE();
                            if (a2) {
                                a.a(a.this, c, r, a, jSONObject);
                                if (aCE) {
                                    a.this.a(c, r, a, jSONObject, gVar);
                                } else {
                                    a.this.a(c, r, a, jSONObject);
                                }
                            }
                            a aVar = a.this;
                            e eVar = c;
                            b J = eVar.aBf().J(r, true);
                            if (((f.c) J.get("baseViewDestroyListener", null)) == null) {
                                AnonymousClass2 anonymousClass2 = new AnonymousClass2(eVar, r, J);
                                J.j("baseViewDestroyListener", anonymousClass2);
                                eVar.a((f.c) anonymousClass2);
                            }
                            ab.i("MicroMsg.BaseInsertViewJsApi", "insert view(parentId : %s, viewId : %s, view : %s, r : %s)", Integer.valueOf(optInt), Integer.valueOf(r), Integer.valueOf(a.hashCode()), Boolean.valueOf(a2));
                            if (!aCE) {
                                String str;
                                g gVar = gVar;
                                a aVar2 = a.this;
                                if (a2) {
                                    str = "ok";
                                } else {
                                    str = "fail:insert view fail";
                                }
                                gVar.AR(aVar2.j(str, null));
                            }
                            AppMethodBeat.o(91043);
                            return;
                        }
                    } catch (JSONException e2) {
                        gVar.AR(a.this.j("fail:invalid view id", null));
                        AppMethodBeat.o(91043);
                        return;
                    }
                }
                AppMethodBeat.o(91043);
            }
        });
    }
}
