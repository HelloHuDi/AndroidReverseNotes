package com.tencent.mm.plugin.appbrand.jsapi;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.tencent.luggage.g.e;
import com.tencent.luggage.g.e.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.smtt.sdk.WebView;
import org.json.JSONObject;

public final class as extends a<q> {
    public static final int CTRL_INDEX = 102;
    public static final String NAME = "makePhoneCall";

    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, final int i) {
        AppMethodBeat.i(114330);
        final q qVar = (q) cVar;
        String optString = jSONObject.optString("phoneNumber");
        if (bo.isNullOrNil(optString)) {
            qVar.M(i, j("fail", null));
            AppMethodBeat.o(114330);
            return;
        }
        Activity ad = qVar.ad(Activity.class);
        if (ad == null) {
            qVar.M(i, j("fail", null));
            AppMethodBeat.o(114330);
            return;
        }
        try {
            Intent intent = new Intent("android.intent.action.DIAL");
            intent.setData(Uri.parse(new StringBuilder(WebView.SCHEME_TEL).append(Uri.encode(optString)).toString()));
            e.ax(ad).a(intent, new a() {
                public final void b(int i, Intent intent) {
                    AppMethodBeat.i(114329);
                    qVar.M(i, as.this.j("ok", null));
                    AppMethodBeat.o(114329);
                }
            });
            AppMethodBeat.o(114330);
        } catch (Exception e) {
            ab.e("MicroMsg.JsApiMakePhoneCall", "startActivity failed");
            qVar.M(i, j("fail", null));
            AppMethodBeat.o(114330);
        }
    }
}
