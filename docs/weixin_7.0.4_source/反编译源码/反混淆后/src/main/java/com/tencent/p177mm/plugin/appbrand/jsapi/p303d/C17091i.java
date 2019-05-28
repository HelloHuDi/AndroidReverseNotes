package com.tencent.p177mm.plugin.appbrand.jsapi.p303d;

import android.graphics.Rect;
import android.widget.EditText;
import com.tencent.luggage.p147g.C45124d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.p328r.C45673m;
import com.tencent.p177mm.plugin.appbrand.page.C44709u;
import com.tencent.p177mm.plugin.appbrand.widget.input.C19871c;
import com.tencent.p177mm.plugin.appbrand.widget.input.C19881i;
import com.tencent.p177mm.plugin.appbrand.widget.input.C19898j;
import com.tencent.p177mm.plugin.appbrand.widget.input.C19898j.C19900a;
import com.tencent.p177mm.plugin.appbrand.widget.input.C19898j.C199011;
import com.tencent.p177mm.plugin.appbrand.widget.input.C38600e;
import com.tencent.p177mm.plugin.appbrand.widget.input.C42743o;
import com.tencent.p177mm.plugin.appbrand.widget.input.C44719g;
import com.tencent.p177mm.plugin.appbrand.widget.input.C45718aa;
import com.tencent.p177mm.plugin.appbrand.widget.input.C45720aj;
import com.tencent.p177mm.plugin.appbrand.widget.input.p341d.C11017h;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.d.i */
public class C17091i extends C16663a<C11017h> {
    private static final int CTRL_INDEX = 112;
    private static final String NAME = "updateInput";

    /* renamed from: a */
    public void mo31165a(C44709u c44709u, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(123562);
        final C11017h c11017h = new C11017h();
        if (mo30637a(c11017h, jSONObject, c44709u, i)) {
            try {
                final int i2 = jSONObject.getInt("inputId");
                if (c11017h.jjp != null && c11017h.jjp.intValue() < 0) {
                    c11017h.jjp = Integer.valueOf(0);
                }
                if (c11017h.jjq != null && c11017h.jjq.intValue() < 0) {
                    c11017h.jjq = Integer.valueOf(0);
                }
                String optString = jSONObject.optString("data", null);
                if (optString != null) {
                    C16663a.m25666S(i2, optString);
                }
                final C44709u c44709u2 = c44709u;
                final int i3 = i;
                C45673m.runOnUiThread(new Runnable() {
                    public final void run() {
                        C19871c c19871c;
                        boolean z;
                        AppMethodBeat.m2504i(123561);
                        C19898j aQJ = C19900a.jer;
                        C44709u c44709u = c44709u2;
                        int i = i2;
                        C11017h c11017h = c11017h;
                        C45718aa a = C38600e.m65411a(c44709u, new C199011(i));
                        if (a instanceof C19871c) {
                            c19871c = (C19871c) a;
                        } else {
                            c19871c = null;
                        }
                        if (c19871c != null) {
                            if (c11017h.jjo != null) {
                                c19871c.mo35095EG(c11017h.jjo);
                            }
                            c19871c.mo35098a(c11017h);
                            EditText aQl = c19871c.aQl();
                            if (aQl != null) {
                                c44709u = (C44709u) c19871c.jdm.get();
                                if (!(c44709u == null || c44709u.aJz() == null)) {
                                    C44719g c44719g = (C44719g) c44709u.aAY();
                                    if (c44719g != null) {
                                        Rect aQm = c19871c.aQm();
                                        c44719g.mo71785c(c44709u.aJz(), aQl, aQm.width(), aQm.height(), aQm.left, aQm.top);
                                    }
                                }
                            }
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z) {
                            c44709u2.mo6107M(i3, C17091i.this.mo73394j("ok", null));
                            AppMethodBeat.m2505o(123561);
                            return;
                        }
                        a = C42743o.m75749a(c44709u2, i2);
                        if (a instanceof C19881i) {
                            C19881i c19881i = (C19881i) a;
                            C11017h c11017h2 = c11017h;
                            if (!(c19881i.jdT == null || c19881i.jdW == null)) {
                                c19881i.jdT.mo6559a(c11017h2);
                                if (c19881i.jdT.jjm || (c19881i.jdT.jjq != null && c19881i.jdT.jjq.intValue() > 0)) {
                                    c19881i.jdW.setWillNotDraw(true);
                                    c19881i.aQy();
                                    if (c19881i.jdT.jjo != null) {
                                        c19881i.jdW.mo6562B(C5046bo.nullAsNil(c19881i.jdT.jjo));
                                    }
                                    if (C45720aj.m84478g(c19881i.jdT.jjH)) {
                                        c19881i.aQq();
                                        c19881i.aQz();
                                    } else {
                                        c19881i.mo35127b(c19881i.jdW, c19881i.jdT);
                                    }
                                    c19881i.jdW.setWillNotDraw(false);
                                    c19881i.jdW.invalidate();
                                }
                            }
                            c44709u2.mo6107M(i3, C17091i.this.mo73394j("ok", null));
                            AppMethodBeat.m2505o(123561);
                            return;
                        }
                        C45124d.m82927e("MicroMsg.AppBrand.JsApiUpdateInput", String.format(Locale.US, "AppBrandInputInvokeHandler with inputID(%d) 404", new Object[]{Integer.valueOf(i2)}));
                        c44709u2.mo6107M(i3, C17091i.this.mo73394j(String.format(Locale.US, "fail found no input with %d", new Object[]{Integer.valueOf(i2)}), null));
                        AppMethodBeat.m2505o(123561);
                    }
                });
                AppMethodBeat.m2505o(123562);
                return;
            } catch (JSONException e) {
                c44709u.mo6107M(i, mo73394j("fail:invalid data", null));
                AppMethodBeat.m2505o(123562);
                return;
            }
        }
        AppMethodBeat.m2505o(123562);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean aDx() {
        return true;
    }
}
