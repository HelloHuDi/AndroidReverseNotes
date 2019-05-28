package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.d;
import com.tencent.mm.sdk.platformtools.ab;

public class j extends bd<d> {
    public final String name() {
        return "clearBounceBackground";
    }

    public final int biG() {
        return 0;
    }

    public final void b(a aVar) {
        AppMethodBeat.i(6304);
        ab.i("MicroMsg.JsApiClearBounceBackground", "invokeInOwn");
        ((d) aVar.bOZ).cWI();
        aVar.a("", null);
        AppMethodBeat.o(6304);
    }

    public final void a(Context context, String str, bc.a aVar) {
    }
}
