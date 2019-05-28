package com.tencent.mm.plugin.downloader_app.detail.a;

import android.content.Context;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.jsapi.bc;
import com.tencent.mm.pluginsdk.model.app.aj;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONException;
import org.json.JSONObject;

public class c extends bc {
    public final String name() {
        return "launchApplication";
    }

    public final int biG() {
        return 2;
    }

    public final void b(a aVar) {
    }

    public final void a(Context context, String str, final bc.a aVar) {
        JSONObject jSONObject;
        AppMethodBeat.i(136071);
        ab.i("MicroMsg.JsApiLaunchApplication", "invokeInMM");
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e) {
            ab.e("MicroMsg.JsApiLaunchApplication", "paras data error: " + e.getMessage());
            jSONObject = null;
        }
        if (jSONObject == null) {
            ab.e("MicroMsg.JsApiLaunchApplication", "data is null");
            aVar.d("fail", null);
            AppMethodBeat.o(136071);
            return;
        }
        String optString = jSONObject.optString("appID");
        if (bo.isNullOrNil(optString)) {
            ab.e("MicroMsg.JsApiLaunchApplication", "appid is null or nil");
            aVar.d("fail", null);
            AppMethodBeat.o(136071);
            return;
        }
        com.tencent.mm.plugin.downloader.h.a.a(context, optString, new aj() {
            public final void dR(boolean z) {
                AppMethodBeat.i(136070);
                aVar.d(null, null);
                AppMethodBeat.o(136070);
            }
        });
        AppMethodBeat.o(136071);
    }
}
