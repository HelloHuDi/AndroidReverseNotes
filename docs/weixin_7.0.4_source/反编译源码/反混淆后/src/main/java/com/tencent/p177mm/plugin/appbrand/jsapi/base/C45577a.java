package com.tencent.p177mm.plugin.appbrand.jsapi.base;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C37922v.C32800b;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33303e;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45596f.C10380c;
import com.tencent.p177mm.plugin.appbrand.page.C45663ac;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.base.a */
public abstract class C45577a<CONTEXT extends C33303e> extends C38268d<C2241c> {

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.base.a$2 */
    class C382672 implements C10380c {
        final /* synthetic */ C32800b hAt;
        final /* synthetic */ C33303e hCK;
        final /* synthetic */ int hCN;

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.base.a$2$1 */
        class C193231 implements Runnable {
            C193231() {
            }

            public final void run() {
                AppMethodBeat.m2504i(91044);
                C382672.this.hCK.aBf().mo73450pv(C382672.this.hCN);
                AppMethodBeat.m2505o(91044);
            }
        }

        C382672(C33303e c33303e, int i, C32800b c32800b) {
            this.hCK = c33303e;
            this.hCN = i;
            this.hAt = c32800b;
        }

        public final void onDestroy() {
            AppMethodBeat.m2504i(91045);
            this.hCK.mo53833b((C10380c) this);
            C5004al.m7441d(new C193231());
            this.hCK.aBf().mo73446pA(this.hCN);
            this.hAt.recycle();
            System.gc();
            AppMethodBeat.m2505o(91045);
        }
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: a */
    public View mo34491a(CONTEXT context, JSONObject jSONObject, int i) {
        return mo6126a(context, jSONObject);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: a */
    public View mo6126a(CONTEXT context, JSONObject jSONObject) {
        throw new IllegalStateException("inflateView must be inflated");
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: a */
    public void mo6140a(CONTEXT context, int i, View view, JSONObject jSONObject) {
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: a */
    public void mo6127a(CONTEXT context, int i, View view, JSONObject jSONObject, C26932g c26932g) {
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

    /* renamed from: a */
    public void mo5994a(C2241c c2241c, final JSONObject jSONObject, int i) {
        final C33303e c = ((C10333f) c2241c.mo5936B(C10333f.class)).mo21784c(c2241c);
        if (c == null) {
            C4990ab.m7421w("MicroMsg.BaseInsertViewJsApi", "invoke JsApi(%s) failed, component view is null", getName());
            c2241c.mo6107M(i, mo73394j("fail:ComponentView is null.", null));
            return;
        }
        final C26932g c26932g = new C26932g(c2241c, i);
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(91043);
                if (c.isRunning()) {
                    try {
                        int r = C45577a.this.mo6130r(jSONObject);
                        View a = C45577a.this.mo34491a(c, jSONObject, r);
                        if (a == null) {
                            C4990ab.m7420w("MicroMsg.BaseInsertViewJsApi", "inflate view return null.");
                            c26932g.mo44674AR(C45577a.this.mo73394j("inflate view failed", null));
                            AppMethodBeat.m2505o(91043);
                            return;
                        } else if (c.aBf().mo73453pz(r)) {
                            C4990ab.m7421w("MicroMsg.BaseInsertViewJsApi", "insert view(%d) failed, it has been inserted before.", Integer.valueOf(r));
                            c26932g.mo44674AR(C45577a.this.mo73394j("fail:the view has already exist", null));
                            AppMethodBeat.m2505o(91043);
                            return;
                        } else {
                            boolean a2;
                            int optInt = jSONObject.optInt("parentId", 0);
                            try {
                                float[] s = C38268d.m64760s(jSONObject);
                                int t = C38268d.m64761t(jSONObject);
                                Boolean u = C38268d.m64762u(jSONObject);
                                Boolean v = C38268d.m64763v(jSONObject);
                                C45663ac aBf = c.aBf();
                                boolean z = u != null && u.booleanValue();
                                boolean z2 = v != null && v.booleanValue();
                                a2 = aBf.mo73443a(a, r, optInt, s, t, z, z2);
                            } catch (JSONException e) {
                                C4990ab.m7413e("MicroMsg.BaseInsertViewJsApi", "parse position error. Exception :%s", e);
                                a2 = false;
                            }
                            boolean aCE = C45577a.this.aCE();
                            if (a2) {
                                C45577a.m84084a(C45577a.this, c, r, a, jSONObject);
                                if (aCE) {
                                    C45577a.this.mo6127a(c, r, a, jSONObject, c26932g);
                                } else {
                                    C45577a.this.mo6140a(c, r, a, jSONObject);
                                }
                            }
                            C45577a c45577a = C45577a.this;
                            C33303e c33303e = c;
                            C32800b J = c33303e.aBf().mo73439J(r, true);
                            if (((C10380c) J.get("baseViewDestroyListener", null)) == null) {
                                C382672 c382672 = new C382672(c33303e, r, J);
                                J.mo53356j("baseViewDestroyListener", c382672);
                                c33303e.mo53828a((C10380c) c382672);
                            }
                            C4990ab.m7417i("MicroMsg.BaseInsertViewJsApi", "insert view(parentId : %s, viewId : %s, view : %s, r : %s)", Integer.valueOf(optInt), Integer.valueOf(r), Integer.valueOf(a.hashCode()), Boolean.valueOf(a2));
                            if (!aCE) {
                                String str;
                                C26932g c26932g = c26932g;
                                C45577a c45577a2 = C45577a.this;
                                if (a2) {
                                    str = "ok";
                                } else {
                                    str = "fail:insert view fail";
                                }
                                c26932g.mo44674AR(c45577a2.mo73394j(str, null));
                            }
                            AppMethodBeat.m2505o(91043);
                            return;
                        }
                    } catch (JSONException e2) {
                        c26932g.mo44674AR(C45577a.this.mo73394j("fail:invalid view id", null));
                        AppMethodBeat.m2505o(91043);
                        return;
                    }
                }
                AppMethodBeat.m2505o(91043);
            }
        });
    }
}
