package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.d;

public class p extends bd<d> {
    public final String name() {
        return "getLocalData";
    }

    public final int biG() {
        return 0;
    }

    public final void b(a aVar) {
        AppMethodBeat.i(6311);
        aVar.a("fail", null);
        AppMethodBeat.o(6311);
    }

    public final void a(Context context, String str, bc.a aVar) {
    }
}
