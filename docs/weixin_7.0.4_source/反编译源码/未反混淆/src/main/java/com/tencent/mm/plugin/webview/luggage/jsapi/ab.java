package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.JsApiLaunchMiniProgram;
import com.tencent.mm.plugin.appbrand.service.e;
import com.tencent.mm.plugin.webview.luggage.c.c;
import com.tencent.mm.plugin.webview.luggage.d;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONObject;

public class ab extends bd<d> {
    public final String name() {
        return JsApiLaunchMiniProgram.NAME;
    }

    public final int biG() {
        return 2;
    }

    public final void b(a aVar) {
    }

    public final void a(Context context, String str, bc.a aVar) {
        int i = 1;
        AppMethodBeat.i(6330);
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.JsApiLaunchMiniProgram", "invoke");
        JSONObject AI = c.AI(str);
        if (AI == null) {
            com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.JsApiLaunchMiniProgram", "data is null");
            aVar.d("fail_null_data", null);
            AppMethodBeat.o(6330);
            return;
        }
        String optString = AI.optString("targetAppId");
        String optString2 = AI.optString("currentUrl");
        String optString3 = AI.optString("preVerifyAppId");
        if (bo.isNullOrNil(optString3)) {
            optString3 = AI.optString("referrerAppId");
        }
        if (bo.isNullOrNil(optString)) {
            aVar.d("invalid_targetAppId", null);
            AppMethodBeat.o(6330);
        } else if (bo.isNullOrNil(optString3)) {
            aVar.d("invalid_referrerAppId", null);
            AppMethodBeat.o(6330);
        } else {
            String nullAsNil = bo.nullAsNil(AI.optString("envVersion"));
            int i2 = -1;
            switch (nullAsNil.hashCode()) {
                case 110628630:
                    if (nullAsNil.equals("trial")) {
                        i2 = 1;
                        break;
                    }
                    break;
                case 1559690845:
                    if (nullAsNil.equals("develop")) {
                        i2 = 0;
                        break;
                    }
                    break;
            }
            switch (i2) {
                case 0:
                    break;
                case 1:
                    i = 2;
                    break;
                default:
                    i = 0;
                    break;
            }
            ((e) g.K(e.class)).b(context, optString2, optString3, optString, i, AI.optString("path"), 0);
            aVar.d(null, null);
            AppMethodBeat.o(6330);
        }
    }
}
