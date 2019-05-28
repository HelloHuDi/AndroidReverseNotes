package com.tencent.p177mm.plugin.appbrand.jsapi;

import com.tencent.luggage.sdk.p819a.p820a.C37402a;
import com.tencent.luggage.sdk.p819a.p820a.C45126b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.bf */
public final class C26933bf extends C10296a<C45126b> {
    public static final int CTRL_INDEX = 430;
    public static final String NAME = "pageNotFoundCallback";

    /* renamed from: a */
    public final /* synthetic */ void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(101953);
        C45126b c45126b = (C45126b) c2241c;
        if (jSONObject == null) {
            C4990ab.m7412e("MicroMsg.JsApiPageNotFoundCallback", "data is null, do nothing");
            c45126b.mo6107M(i, mo73394j("fail", null));
            AppMethodBeat.m2505o(101953);
            return;
        }
        C4990ab.m7417i("MicroMsg.JsApiPageNotFoundCallback", "pageNotFoundCallback data:%s", jSONObject);
        boolean optBoolean = jSONObject.optBoolean("hasHandler", false);
        int optInt = jSONObject.optInt("webviewId", -1);
        final C37402a xV = c45126b.mo34955xV();
        if (optBoolean) {
            if (xV != null) {
                C5004al.m7439af(xV.bQS);
                if (xV.hashCode() != optInt) {
                    C4990ab.m7413e("MicroMsg.JsApiPageNotFoundCallback", "appBrandPageView.getComponentId():%d, webviewId:%d, err", Integer.valueOf(xV.hashCode()), Integer.valueOf(optInt));
                }
            } else {
                C4990ab.m7412e("MicroMsg.JsApiPageNotFoundCallback", "appBrandPageView is null");
            }
            C4990ab.m7416i("MicroMsg.JsApiPageNotFoundCallback", "already handler, ignore");
            c45126b.mo6107M(i, mo73394j("ok", null));
            AppMethodBeat.m2505o(101953);
            return;
        }
        if (xV != null && xV.hashCode() == optInt) {
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(101952);
                    C5004al.m7439af(xV.bQS);
                    xV.mo60250xQ();
                    AppMethodBeat.m2505o(101952);
                }
            });
        }
        C4990ab.m7412e("MicroMsg.JsApiPageNotFoundCallback", "currentPageView is null, return");
        c45126b.mo6107M(i, mo73394j("ok", null));
        AppMethodBeat.m2505o(101953);
    }
}
