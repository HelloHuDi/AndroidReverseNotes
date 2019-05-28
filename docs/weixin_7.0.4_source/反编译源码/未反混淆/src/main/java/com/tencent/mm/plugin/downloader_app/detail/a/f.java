package com.tencent.mm.plugin.downloader_app.detail.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.luggage.jsapi.bc;
import com.tencent.mm.plugin.webview.luggage.jsapi.bc.a;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONObject;

public class f extends bc {
    public final int biG() {
        return 0;
    }

    public final String name() {
        return "reportDownloaderAppKvState";
    }

    public final void a(Context context, String str, a aVar) {
    }

    public final void b(com.tencent.luggage.d.a.a aVar) {
        AppMethodBeat.i(136078);
        JSONObject jSONObject = aVar.bPa.bOf;
        if (jSONObject == null) {
            aVar.a("invalid_data", null);
            AppMethodBeat.o(136078);
            return;
        }
        int optInt = jSONObject.optInt("logId");
        String optString = jSONObject.optString("values");
        if (optInt <= 0 || bo.isNullOrNil(optString)) {
            aVar.a("invalid_data", null);
            AppMethodBeat.o(136078);
            return;
        }
        if (optInt == 16099) {
            optString = com.tencent.mm.plugin.downloader_app.c.a.azq() + "," + optString;
        }
        h.pYm.X(optInt, optString);
        aVar.a("", null);
        AppMethodBeat.o(136078);
    }
}
