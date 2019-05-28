package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.d;
import com.tencent.mm.sdk.platformtools.ab;

public class f extends bd<d> {
    public final String name() {
        return "checkJsApi";
    }

    public final int biG() {
        return 0;
    }

    public final void b(a aVar) {
        AppMethodBeat.i(6285);
        ab.i("MicroMsg.JsApiCheckJsApi", "invoke");
        aVar.a("fail", null);
        AppMethodBeat.o(6285);
    }

    public final void a(Context context, String str, bc.a aVar) {
    }
}
