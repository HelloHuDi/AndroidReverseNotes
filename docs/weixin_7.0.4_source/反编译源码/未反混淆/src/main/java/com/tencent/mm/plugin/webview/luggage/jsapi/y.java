package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.luggage.jsapi.bc.a;

public class y extends bc {
    public final int biG() {
        return 0;
    }

    public final void a(Context context, String str, a aVar) {
    }

    public final String name() {
        return "kvReport";
    }

    public final void b(com.tencent.luggage.d.a.a aVar) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(6322);
        int optInt = aVar.bPa.bOf.optInt("id");
        if (optInt <= 0) {
            aVar.a("fail", null);
        }
        String optString = aVar.bPa.bOf.optString("value");
        if (aVar.bPa.bOf.optInt("is_important") > 0) {
            z = true;
        } else {
            z = false;
        }
        if (aVar.bPa.bOf.optInt("is_report_now") <= 0) {
            z2 = false;
        }
        h.pYm.a(optInt, optString, z2, z);
        aVar.a("", null);
        AppMethodBeat.o(6322);
    }
}
