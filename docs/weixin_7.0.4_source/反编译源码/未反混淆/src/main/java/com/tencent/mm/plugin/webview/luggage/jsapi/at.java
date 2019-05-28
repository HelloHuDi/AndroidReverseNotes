package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.graphics.Color;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.k.o;
import com.tencent.mm.plugin.webview.luggage.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.smtt.sdk.WebView;

public class at extends bd<d> {
    public final String name() {
        return o.NAME;
    }

    public final int biG() {
        return 0;
    }

    public final void b(a aVar) {
        int i;
        int i2 = 1;
        AppMethodBeat.i(6374);
        ab.i("MicroMsg.JsApiSetNavigationBarColor", "invoke");
        int i3 = -1;
        try {
            i3 = Color.parseColor(aVar.bPa.bOf.optString("color")) | WebView.NIGHT_MODE_COLOR;
            i = aVar.bPa.bOf.optInt("actionCode") == i2 ? i2 : 0;
        } catch (Exception e) {
            ab.e("MicroMsg.JsApiSetNavigationBarColor", e.getMessage());
            i = i2;
        }
        try {
            bo.getFloat(aVar.bPa.bOf.optString("alpha"), 1.0f);
        } catch (Exception e2) {
            ab.e("MicroMsg.JsApiSetNavigationBarColor", e2.getMessage());
        }
        if (i != 0) {
            ((d) aVar.bOZ).aBj();
        } else {
            ((d) aVar.bOZ).setStatusBarColor(i3);
        }
        aVar.a("", null);
        AppMethodBeat.o(6374);
    }

    public final void a(Context context, String str, bc.a aVar) {
    }
}
