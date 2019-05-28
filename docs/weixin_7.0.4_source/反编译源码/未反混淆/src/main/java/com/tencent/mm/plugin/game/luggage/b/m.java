package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.luggage.d.e;
import com.tencent.mm.plugin.webview.luggage.jsapi.bc;
import com.tencent.mm.plugin.webview.luggage.jsapi.bd;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;

public class m extends bd<e> {
    public final String name() {
        return "openGameUrlWithExtraWebView";
    }

    public final int biG() {
        return 0;
    }

    public final void b(final a aVar) {
        int i = 0;
        AppMethodBeat.i(135883);
        ab.i("MicroMsg.JsApiOpenGameUrlWithExtraWebView", "invokeInOwn");
        final String optString = aVar.bPa.bOf.optString("url");
        if (bo.isNullOrNil(optString)) {
            ab.e("MicroMsg.JsApiOpenGameUrlWithExtraWebView", "url is null");
            aVar.a("fail", null);
            AppMethodBeat.o(135883);
            return;
        }
        ab.i("MicroMsg.JsApiOpenGameUrlWithExtraWebView", "url: %s", optString);
        String optString2 = aVar.bPa.bOf.optString("statusBarColor");
        if (!bo.isNullOrNil(optString2)) {
            try {
                i = Color.parseColor(optString2);
            } catch (IllegalArgumentException e) {
                ab.e("MicroMsg.JsApiOpenGameUrlWithExtraWebView", e.getMessage());
                aVar.a("invalid_color", null);
                AppMethodBeat.o(135883);
                return;
            }
        }
        optString2 = aVar.bPa.bOf.optString("statusBarStyle");
        final Bundle bundle = new Bundle();
        bundle.putString("rawUrl", optString);
        bundle.putInt("customize_status_bar_color", i);
        bundle.putString("status_bar_style", optString2);
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(135882);
                ((e) aVar.bOZ).bPe.xi().h(optString, bundle);
                AppMethodBeat.o(135882);
            }
        });
        aVar.a("", null);
        AppMethodBeat.o(135883);
    }

    public final void a(Context context, String str, bc.a aVar) {
    }
}
