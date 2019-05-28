package com.tencent.p177mm.plugin.appbrand.jsapi;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.tencent.luggage.p147g.C8870e;
import com.tencent.luggage.p147g.C8870e.C8872a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.smtt.sdk.WebView;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.as */
public final class C45573as extends C10296a<C38492q> {
    public static final int CTRL_INDEX = 102;
    public static final String NAME = "makePhoneCall";

    /* renamed from: a */
    public final /* synthetic */ void mo5994a(C2241c c2241c, JSONObject jSONObject, final int i) {
        AppMethodBeat.m2504i(114330);
        final C38492q c38492q = (C38492q) c2241c;
        String optString = jSONObject.optString("phoneNumber");
        if (C5046bo.isNullOrNil(optString)) {
            c38492q.mo6107M(i, mo73394j("fail", null));
            AppMethodBeat.m2505o(114330);
            return;
        }
        Activity ad = c38492q.mo61197ad(Activity.class);
        if (ad == null) {
            c38492q.mo6107M(i, mo73394j("fail", null));
            AppMethodBeat.m2505o(114330);
            return;
        }
        try {
            Intent intent = new Intent("android.intent.action.DIAL");
            intent.setData(Uri.parse(new StringBuilder(WebView.SCHEME_TEL).append(Uri.encode(optString)).toString()));
            C8870e.m15839ax(ad).mo20068a(intent, new C8872a() {
                /* renamed from: b */
                public final void mo15055b(int i, Intent intent) {
                    AppMethodBeat.m2504i(114329);
                    c38492q.mo6107M(i, C45573as.this.mo73394j("ok", null));
                    AppMethodBeat.m2505o(114329);
                }
            });
            AppMethodBeat.m2505o(114330);
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.JsApiMakePhoneCall", "startActivity failed");
            c38492q.mo6107M(i, mo73394j("fail", null));
            AppMethodBeat.m2505o(114330);
        }
    }
}
