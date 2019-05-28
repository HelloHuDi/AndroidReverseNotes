package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.luggage.sdk.a.a.a;
import com.tencent.luggage.sdk.a.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import org.json.JSONObject;

public final class bf extends a<b> {
    public static final int CTRL_INDEX = 430;
    public static final String NAME = "pageNotFoundCallback";

    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(101953);
        b bVar = (b) cVar;
        if (jSONObject == null) {
            ab.e("MicroMsg.JsApiPageNotFoundCallback", "data is null, do nothing");
            bVar.M(i, j("fail", null));
            AppMethodBeat.o(101953);
            return;
        }
        ab.i("MicroMsg.JsApiPageNotFoundCallback", "pageNotFoundCallback data:%s", jSONObject);
        boolean optBoolean = jSONObject.optBoolean("hasHandler", false);
        int optInt = jSONObject.optInt("webviewId", -1);
        final a xV = bVar.xV();
        if (optBoolean) {
            if (xV != null) {
                al.af(xV.bQS);
                if (xV.hashCode() != optInt) {
                    ab.e("MicroMsg.JsApiPageNotFoundCallback", "appBrandPageView.getComponentId():%d, webviewId:%d, err", Integer.valueOf(xV.hashCode()), Integer.valueOf(optInt));
                }
            } else {
                ab.e("MicroMsg.JsApiPageNotFoundCallback", "appBrandPageView is null");
            }
            ab.i("MicroMsg.JsApiPageNotFoundCallback", "already handler, ignore");
            bVar.M(i, j("ok", null));
            AppMethodBeat.o(101953);
            return;
        }
        if (xV != null && xV.hashCode() == optInt) {
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(101952);
                    al.af(xV.bQS);
                    xV.xQ();
                    AppMethodBeat.o(101952);
                }
            });
        }
        ab.e("MicroMsg.JsApiPageNotFoundCallback", "currentPageView is null, return");
        bVar.M(i, j("ok", null));
        AppMethodBeat.o(101953);
    }
}
