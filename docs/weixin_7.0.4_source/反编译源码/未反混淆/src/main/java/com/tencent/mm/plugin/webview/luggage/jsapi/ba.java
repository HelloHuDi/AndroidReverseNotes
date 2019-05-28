package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.d;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;

public class ba extends bd<d> {
    public final String name() {
        return "showSmileyPanel";
    }

    public final int biG() {
        return 0;
    }

    public final void b(a aVar) {
        AppMethodBeat.i(6386);
        ab.i("MicroMsg.JsApiShowSmileyPanel", "invokeInOwn");
        int cWF = ((d) aVar.bOZ).cWF();
        if (cWF > 0) {
            HashMap hashMap = new HashMap();
            hashMap.put("height", Integer.valueOf(com.tencent.mm.bz.a.ao(((d) aVar.bOZ).mContext, cWF)));
            aVar.c("", hashMap);
            AppMethodBeat.o(6386);
            return;
        }
        aVar.a("fail", null);
        AppMethodBeat.o(6386);
    }

    public final void a(Context context, String str, bc.a aVar) {
    }
}
