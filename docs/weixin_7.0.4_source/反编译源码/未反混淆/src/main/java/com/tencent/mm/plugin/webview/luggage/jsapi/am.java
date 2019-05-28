package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.d;
import com.tencent.mm.sdk.platformtools.ab;

public class am extends bd<d> {
    public final String name() {
        return "recordVideo";
    }

    public final int biG() {
        return 0;
    }

    public final void b(a aVar) {
        AppMethodBeat.i(6359);
        ab.i("MicroMsg.JsApiRecordVideo", "invoke");
        i.a(aVar, 1);
        AppMethodBeat.o(6359);
    }

    public final void a(Context context, String str, bc.a aVar) {
    }
}
