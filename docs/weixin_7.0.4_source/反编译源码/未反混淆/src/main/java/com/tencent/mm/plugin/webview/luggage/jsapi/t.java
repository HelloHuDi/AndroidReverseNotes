package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.d;
import com.tencent.mm.plugin.webview.luggage.k;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONArray;

public class t extends bd<d> {
    public final String name() {
        return "hideMenuItems";
    }

    public final int biG() {
        return 0;
    }

    public final void b(a aVar) {
        AppMethodBeat.i(6315);
        ab.i("MicroMsg.JsApiHideMenuItems", "invokeInOwn");
        JSONArray optJSONArray = aVar.bPa.bOf.optJSONArray("menuList");
        if (optJSONArray == null) {
            ab.i("MicroMsg.JsApiHideMenuItems", "data is null");
            aVar.a("invalid_data", null);
            AppMethodBeat.o(6315);
            return;
        }
        k cWH = ((d) aVar.bOZ).cWH();
        if (cWH != null) {
            cWH.H(optJSONArray);
        }
        aVar.a("", null);
        AppMethodBeat.o(6315);
    }

    public final void a(Context context, String str, bc.a aVar) {
    }
}
