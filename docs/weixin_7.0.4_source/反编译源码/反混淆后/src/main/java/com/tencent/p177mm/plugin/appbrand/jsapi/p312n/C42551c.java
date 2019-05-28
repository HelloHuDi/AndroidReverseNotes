package com.tencent.p177mm.plugin.appbrand.jsapi.p312n;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Color;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.p328r.C42668g;
import com.tencent.p177mm.plugin.appbrand.page.C27220ah;
import com.tencent.p177mm.plugin.appbrand.page.C44709u;
import com.tencent.p177mm.plugin.appbrand.widget.p337b.C6789b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.n.c */
public final class C42551c extends C10296a<C38492q> {
    private static final int CTRL_INDEX = 104;
    private static final String NAME = "showModal";

    /* renamed from: a */
    public final /* synthetic */ void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(74793);
        final C38492q c38492q = (C38492q) c2241c;
        final C44709u currentPageView = c38492q.getCurrentPageView();
        if (currentPageView == null) {
            C4990ab.m7420w("MicroMsg.JsApiShowModal", "invoke JsApi JsApiShowModal failed, current page view is null.");
            c38492q.mo6107M(i, mo73394j("fail", null));
            AppMethodBeat.m2505o(74793);
            return;
        }
        final String optString = jSONObject.optString("title");
        final String optString2 = jSONObject.optString("confirmText", c38492q.getContext().getString(C25738R.string.cuu));
        final String optString3 = jSONObject.optString("cancelText", c38492q.getContext().getString(C25738R.string.cut));
        final Boolean valueOf = Boolean.valueOf(jSONObject.optBoolean("showCancel", true));
        final int by = C42668g.m75559by(jSONObject.optString("confirmColor", ""), C4996ah.getContext().getResources().getColor(C25738R.color.f11795hi));
        final int by2 = C42668g.m75559by(jSONObject.optString("cancelColor", ""), Color.parseColor("#000000"));
        final String optString4 = jSONObject.optString(C8741b.CONTENT);
        final int i2 = i;
        C5004al.m7441d(new Runnable() {

            /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.n.c$1$3 */
            class C104953 implements OnCancelListener {
                C104953() {
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.m2504i(74791);
                    HashMap hashMap = new HashMap();
                    hashMap.put("confirm", Boolean.FALSE);
                    hashMap.put("cancel", Boolean.TRUE);
                    c38492q.mo6107M(i2, C42551c.this.mo73394j("ok", hashMap));
                    AppMethodBeat.m2505o(74791);
                }
            }

            /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.n.c$1$1 */
            class C383581 implements OnClickListener {
                C383581() {
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(74789);
                    HashMap hashMap = new HashMap();
                    hashMap.put("confirm", Boolean.TRUE);
                    hashMap.put("cancel", Boolean.FALSE);
                    c38492q.mo6107M(i2, C42551c.this.mo73394j("ok", hashMap));
                    AppMethodBeat.m2505o(74789);
                }
            }

            /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.n.c$1$2 */
            class C425502 implements OnClickListener {
                C425502() {
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(74790);
                    HashMap hashMap = new HashMap();
                    hashMap.put("confirm", Boolean.FALSE);
                    hashMap.put("cancel", Boolean.TRUE);
                    dialogInterface.dismiss();
                    c38492q.mo6107M(i2, C42551c.this.mo73394j("ok", hashMap));
                    AppMethodBeat.m2505o(74790);
                }
            }

            public final void run() {
                AppMethodBeat.m2504i(74792);
                if (c38492q.isRunning()) {
                    currentPageView.aAX().mo21649a(C27220ah.MODAL);
                    C6789b c6789b = new C6789b(c38492q.getContext());
                    if (!C5046bo.isNullOrNil(optString)) {
                        c6789b.setTitle((CharSequence) optString);
                    }
                    c6789b.setMessage(optString4);
                    c6789b.mo11489a(optString2, true, new C383581());
                    if (valueOf.booleanValue()) {
                        c6789b.mo11491b(optString3, false, new C425502());
                    }
                    c6789b.setOnCancelListener(new C104953());
                    c6789b.mo11485PT(by);
                    if (valueOf.booleanValue()) {
                        c6789b.mo11486PU(by2);
                    }
                    c38492q.getRuntime().gNG.mo6468b(c6789b);
                    AppMethodBeat.m2505o(74792);
                    return;
                }
                AppMethodBeat.m2505o(74792);
            }
        });
        AppMethodBeat.m2505o(74793);
    }
}
