package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.webview.luggage.d;
import com.tencent.mm.plugin.webview.ui.tools.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public class au extends bd<d> {
    public final String name() {
        return "setPageTitle";
    }

    public final int biG() {
        return 0;
    }

    public final void b(a aVar) {
        AppMethodBeat.i(6375);
        ab.i("MicroMsg.JsApiSetPageTitle", "invokeInOwn");
        String optString = aVar.bPa.bOf.optString("title");
        if (bo.isNullOrNil(aVar.bPa.bOf.optString("color"))) {
            ((d) aVar.bOZ).cl(optString, 0);
        } else {
            ((d) aVar.bOZ).cl(optString, g.bx(aVar.bPa.bOf.optString("color"), ((d) aVar.bOZ).mContext.getResources().getColor(R.color.du)));
        }
        aVar.a("", null);
        AppMethodBeat.o(6375);
    }

    public final void a(Context context, String str, bc.a aVar) {
    }
}
