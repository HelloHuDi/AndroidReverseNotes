package com.tencent.mm.plugin.appbrand.jsapi.j;

import android.app.Activity;
import com.tencent.luggage.g.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.page.a.c;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.platformtools.al;
import org.json.JSONObject;

public abstract class d extends a<q> {
    private static c.a hAK;
    private u hTn = null;

    public abstract void b(q qVar, JSONObject jSONObject, int i);

    public final /* synthetic */ void a(com.tencent.mm.plugin.appbrand.jsapi.c cVar, JSONObject jSONObject, int i) {
        q qVar = (q) cVar;
        if (qVar.ad(Activity.class) == null) {
            com.tencent.luggage.g.d.e("MicroMsg.OpenVoice.JsApiOpenVoiceBase", "hy: no page context");
        } else if (g.a(qVar.ad(Activity.class), "android.permission.RECORD_AUDIO", 121, null, null)) {
            com.tencent.mm.plugin.appbrand.page.q asV = qVar.getRuntime().asV();
            if (!(asV.getCurrentPage() == null && asV.getCurrentPage().getCurrentPageView() == null)) {
                this.hTn = asV.getCurrentPage().getCurrentPageView();
            }
            b(qVar, jSONObject, i);
        } else {
            com.tencent.luggage.g.d.w("MicroMsg.OpenVoice.JsApiOpenVoiceBase", "hy: no record audio permission");
            qVar.M(i, j("fail: no record audio permission", null));
        }
    }

    public final void dU(final boolean z) {
        try {
            if (!al.isMainThread()) {
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(131399);
                        d.this.dU(z);
                        AppMethodBeat.o(131399);
                    }
                });
            } else if (this.hTn != null && this.hTn.getRuntime() != null) {
                if (hAK != null) {
                    hAK.dismiss();
                    hAK = null;
                }
                if (z) {
                    hAK = com.tencent.mm.plugin.appbrand.page.a.z(this.hTn.getRuntime()).a(com.tencent.mm.plugin.appbrand.page.a.a.VOICE);
                }
            }
        } catch (Exception e) {
            com.tencent.luggage.g.d.e("MicroMsg.OpenVoice.JsApiOpenVoiceBase", "setSubTitle error:" + e.toString());
        }
    }
}
