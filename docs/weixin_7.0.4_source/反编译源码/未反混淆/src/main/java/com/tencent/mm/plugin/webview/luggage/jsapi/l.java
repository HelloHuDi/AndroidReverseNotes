package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.d;
import com.tencent.mm.plugin.webview.luggage.jsapi.bc.a;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONObject;

public class l extends bd<d> {
    public final String name() {
        return "currentMpInfo";
    }

    public final int biG() {
        return 0;
    }

    public final void a(Context context, String str, a aVar) {
    }

    public final void b(com.tencent.luggage.d.a.a aVar) {
        AppMethodBeat.i(6306);
        JSONObject jSONObject = aVar.bPa.bOf;
        String optString = jSONObject.optString("brandIcon");
        jSONObject.optString("brandName");
        ab.i("MicroMsg.JsApiCurrentMpInfo", "doCurrentMpInfo brandIcon:%s", optString);
        ((d) aVar.bOZ).cWP().afX(optString);
        aVar.a("", null);
        AppMethodBeat.o(6306);
    }
}
