package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.d;
import com.tencent.mm.plugin.webview.luggage.k;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONArray;

public class ay extends bd<d> {
    public final String name() {
        return "showMenuItems";
    }

    public final int biG() {
        return 0;
    }

    public final void b(a aVar) {
        AppMethodBeat.i(6384);
        ab.i("MicroMsg.JsApiShowMenuItems", "invokeInOwn");
        JSONArray optJSONArray = aVar.bPa.bOf.optJSONArray("menuList");
        if (optJSONArray == null) {
            ab.i("MicroMsg.JsApiShowMenuItems", "data is null");
            aVar.a("invalid_data", null);
            AppMethodBeat.o(6384);
            return;
        }
        k cWH = ((d) aVar.bOZ).cWH();
        if (cWH != null) {
            cWH.I(optJSONArray);
        }
        aVar.a("", null);
        AppMethodBeat.o(6384);
    }

    public final void a(Context context, String str, bc.a aVar) {
    }
}
