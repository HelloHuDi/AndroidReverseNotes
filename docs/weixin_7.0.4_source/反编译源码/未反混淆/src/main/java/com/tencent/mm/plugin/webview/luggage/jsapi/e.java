package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.d.a.a;
import com.tencent.luggage.d.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiCancelDownloadTask;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.webview.luggage.c.b;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONObject;

public class e extends bc<n> {
    public final String name() {
        return JsApiCancelDownloadTask.NAME;
    }

    public final int biG() {
        return 1;
    }

    public final void b(a aVar) {
    }

    public final void a(Context context, String str, bc.a aVar) {
        AppMethodBeat.i(6284);
        ab.i("MicroMsg.JsApiCancelDownloadTask", "invokeInMM");
        JSONObject AI = b.AI(str);
        if (AI == null) {
            aVar.d("fail", null);
            AppMethodBeat.o(6284);
            return;
        }
        long optLong = AI.optLong("download_id");
        if (optLong <= 0) {
            ab.e("MicroMsg.JsApiCancelDownloadTask", "fail, invalid downloadId = ".concat(String.valueOf(optLong)));
            aVar.d("invalid_downloadid", null);
            AppMethodBeat.o(6284);
        } else if (d.bij().hl(optLong) > 0) {
            aVar.d(null, null);
            AppMethodBeat.o(6284);
        } else {
            aVar.d("fail", null);
            AppMethodBeat.o(6284);
        }
    }
}
