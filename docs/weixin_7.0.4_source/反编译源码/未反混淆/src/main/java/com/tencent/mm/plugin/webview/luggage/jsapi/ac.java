package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.d.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.jsapi.bc.a;
import com.tencent.mm.sdk.platformtools.ab;

public class ac extends bc<n> {
    public final String name() {
        return "log";
    }

    public final int biG() {
        return 0;
    }

    public final void a(Context context, String str, a aVar) {
    }

    public final void b(com.tencent.luggage.d.a.a aVar) {
        AppMethodBeat.i(6331);
        ab.i("MicroMsg.JsApiLog", "jslog : " + aVar.bPa.bOf.optString("msg"));
        AppMethodBeat.o(6331);
    }
}
