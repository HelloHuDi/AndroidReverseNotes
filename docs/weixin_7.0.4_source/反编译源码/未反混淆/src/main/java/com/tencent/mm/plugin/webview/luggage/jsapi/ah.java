package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.d.a.a;
import com.tencent.luggage.d.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiPauseDownloadTask;
import com.tencent.mm.plugin.downloader.model.c;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONException;
import org.json.JSONObject;

public class ah extends bc<n> {
    public final String name() {
        return JsApiPauseDownloadTask.NAME;
    }

    public final int biG() {
        return 1;
    }

    public final void b(a aVar) {
    }

    public final void a(Context context, String str, bc.a aVar) {
        AppMethodBeat.i(6343);
        try {
            long optLong = new JSONObject(str).optLong("download_id");
            if (optLong <= 0) {
                ab.e("MicroMsg.JsApiPauseDownloadTask", "fail, invalid downloadId = ".concat(String.valueOf(optLong)));
                aVar.d("invalid_downloadid", null);
                AppMethodBeat.o(6343);
                return;
            }
            com.tencent.mm.plugin.downloader.f.a hv = c.hv(optLong);
            if (hv == null) {
                aVar.d(null, null);
                AppMethodBeat.o(6343);
                return;
            }
            if (hv.field_downloadInWifi) {
                hv.field_downloadInWifi = false;
                c.e(hv);
            }
            if (d.bij().hn(optLong)) {
                aVar.d(null, null);
                AppMethodBeat.o(6343);
                return;
            }
            aVar.d("fail", null);
            AppMethodBeat.o(6343);
        } catch (JSONException e) {
            ab.e("MicroMsg.JsApiPauseDownloadTask", "paras data error: " + e.getMessage());
            aVar.d("fail", null);
            AppMethodBeat.o(6343);
        }
    }
}
