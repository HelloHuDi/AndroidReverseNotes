package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public class aq extends bd<d> {
    public final String name() {
        return "setBounceBackground";
    }

    public final int biG() {
        return 0;
    }

    public final void b(a aVar) {
        AppMethodBeat.i(6371);
        ab.i("MicroMsg.JsApiSetBounceBackground", "invokeInOwn");
        String optString = aVar.bPa.bOf.optString("backgroundColor");
        if (bo.isNullOrNil(optString)) {
            aVar.a("invalid_data", null);
            AppMethodBeat.o(6371);
            return;
        }
        ((d) aVar.bOZ).aec(optString);
        aVar.a("", null);
        AppMethodBeat.o(6371);
    }

    public final void a(Context context, String str, bc.a aVar) {
    }
}
