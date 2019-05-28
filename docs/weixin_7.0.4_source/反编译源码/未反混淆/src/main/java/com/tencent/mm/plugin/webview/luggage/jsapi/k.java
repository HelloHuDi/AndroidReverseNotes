package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.d;
import com.tencent.mm.sdk.platformtools.ab;

public class k extends bd<d> {
    public final String name() {
        return "closeWindow";
    }

    public final int biG() {
        return 0;
    }

    public final void b(a aVar) {
        AppMethodBeat.i(6305);
        ab.i("MicroMsg.JsApiCloseWindow", "invokeInOwn");
        ((d) aVar.bOZ).finish();
        aVar.a("", null);
        AppMethodBeat.o(6305);
    }

    public final void a(Context context, String str, bc.a aVar) {
    }
}
