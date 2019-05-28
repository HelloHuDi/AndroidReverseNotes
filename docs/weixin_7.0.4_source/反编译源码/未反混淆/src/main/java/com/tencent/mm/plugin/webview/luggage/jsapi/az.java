package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.d;
import com.tencent.mm.plugin.webview.luggage.k;
import com.tencent.mm.sdk.platformtools.ab;

public class az extends bd<d> {
    public final String name() {
        return "showOptionMenu";
    }

    public final int biG() {
        return 0;
    }

    public final void b(a aVar) {
        AppMethodBeat.i(6385);
        ab.i("MicroMsg.JsApiShowOptionMenu", "invoke");
        k cWH = ((d) aVar.bOZ).cWH();
        if (cWH == null) {
            ab.i("MicroMsg.JsApiShowOptionMenu", "actionBar is null");
            AppMethodBeat.o(6385);
            return;
        }
        cWH.cXd();
        aVar.a("", null);
        AppMethodBeat.o(6385);
    }

    public final void a(Context context, String str, bc.a aVar) {
    }
}
