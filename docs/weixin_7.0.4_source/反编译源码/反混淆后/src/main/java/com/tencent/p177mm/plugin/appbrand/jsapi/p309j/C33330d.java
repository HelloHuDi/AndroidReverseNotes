package com.tencent.p177mm.plugin.appbrand.jsapi.p309j;

import android.app.Activity;
import com.tencent.luggage.p147g.C0991g;
import com.tencent.luggage.p147g.C45124d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.page.C38456a;
import com.tencent.p177mm.plugin.appbrand.page.C38456a.C2403a;
import com.tencent.p177mm.plugin.appbrand.page.C38470q;
import com.tencent.p177mm.plugin.appbrand.page.C44709u;
import com.tencent.p177mm.plugin.appbrand.page.p327a.C42642c.C2405a;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.j.d */
public abstract class C33330d extends C10296a<C38492q> {
    private static C2405a hAK;
    private C44709u hTn = null;

    /* renamed from: b */
    public abstract void mo6169b(C38492q c38492q, JSONObject jSONObject, int i);

    /* renamed from: a */
    public final /* synthetic */ void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        C38492q c38492q = (C38492q) c2241c;
        if (c38492q.mo61197ad(Activity.class) == null) {
            C45124d.m82927e("MicroMsg.OpenVoice.JsApiOpenVoiceBase", "hy: no page context");
        } else if (C0991g.m2252a(c38492q.mo61197ad(Activity.class), "android.permission.RECORD_AUDIO", 121, null, null)) {
            C38470q asV = c38492q.getRuntime().asV();
            if (!(asV.getCurrentPage() == null && asV.getCurrentPage().getCurrentPageView() == null)) {
                this.hTn = asV.getCurrentPage().getCurrentPageView();
            }
            mo6169b(c38492q, jSONObject, i);
        } else {
            C45124d.m82933w("MicroMsg.OpenVoice.JsApiOpenVoiceBase", "hy: no record audio permission");
            c38492q.mo6107M(i, mo73394j("fail: no record audio permission", null));
        }
    }

    /* renamed from: dU */
    public final void mo53837dU(final boolean z) {
        try {
            if (!C5004al.isMainThread()) {
                C5004al.m7441d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(131399);
                        C33330d.this.mo53837dU(z);
                        AppMethodBeat.m2505o(131399);
                    }
                });
            } else if (this.hTn != null && this.hTn.getRuntime() != null) {
                if (hAK != null) {
                    hAK.dismiss();
                    hAK = null;
                }
                if (z) {
                    hAK = C38456a.m65057z(this.hTn.getRuntime()).mo61145a(C2403a.VOICE);
                }
            }
        } catch (Exception e) {
            C45124d.m82927e("MicroMsg.OpenVoice.JsApiOpenVoiceBase", "setSubTitle error:" + e.toString());
        }
    }
}
