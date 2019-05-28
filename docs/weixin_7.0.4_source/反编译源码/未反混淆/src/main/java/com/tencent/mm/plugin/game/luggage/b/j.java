package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader_app.a.a.c;
import com.tencent.mm.plugin.downloader_app.a.d;
import com.tencent.mm.plugin.game.luggage.d.e;
import com.tencent.mm.plugin.webview.luggage.jsapi.bc;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONObject;

public class j extends bc<e> {
    public final int biG() {
        return 2;
    }

    public final String name() {
        return "jumpDownloaderWidget";
    }

    public final void b(a aVar) {
    }

    public final void a(Context context, String str, final bc.a aVar) {
        JSONObject jSONObject;
        String optString;
        AppMethodBeat.i(135878);
        try {
            jSONObject = new JSONObject(str);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.JsApiJumpDownloaderWidget", e, "", new Object[0]);
            jSONObject = null;
        }
        String str2 = "";
        if (jSONObject != null) {
            optString = jSONObject.optString("appId");
        } else {
            optString = str2;
        }
        Intent intent = new Intent();
        intent.putExtra("appId", optString);
        intent.putExtra("view_task", true);
        ((d) g.K(d.class)).a(context, intent, new c() {
            public final void biB() {
                AppMethodBeat.i(135877);
                aVar.d(null, null);
                AppMethodBeat.o(135877);
            }
        });
        AppMethodBeat.o(135878);
    }
}
