package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.d;
import com.tencent.mm.plugin.webview.luggage.k;
import com.tencent.mm.sdk.platformtools.ab;

public class u extends bd<d> {
    public final String name() {
        return "hideOptionMenu";
    }

    public final int biG() {
        return 0;
    }

    public final void b(a aVar) {
        AppMethodBeat.i(6316);
        ab.i("MicroMsg.JsApiHideOptionMenu", "invoke");
        k cWH = ((d) aVar.bOZ).cWH();
        if (cWH == null) {
            ab.e("MicroMsg.JsApiHideOptionMenu", "actionBar is null");
            aVar.a("fail", null);
            AppMethodBeat.o(6316);
            return;
        }
        cWH.cXc();
        aVar.a("", null);
        AppMethodBeat.o(6316);
    }

    public final void a(Context context, String str, bc.a aVar) {
    }
}
