package com.tencent.mm.plugin.downloader_app.detail.a;

import android.content.Context;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.api.b;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiResumeDownloadTask;
import com.tencent.mm.plugin.downloader.model.c;
import com.tencent.mm.plugin.webview.luggage.jsapi.bc;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONException;
import org.json.JSONObject;

public class g extends bc {
    public final String name() {
        return JsApiResumeDownloadTask.NAME;
    }

    public final int biG() {
        return 2;
    }

    public final void b(a aVar) {
    }

    public final void a(Context context, String str, bc.a aVar) {
        AppMethodBeat.i(136080);
        ab.i("MicroMsg.JsApiResumeDownloadTask", "invokeInMM");
        try {
            long optLong = new JSONObject(str).optLong("download_id");
            if (optLong <= 0) {
                ab.e("MicroMsg.JsApiResumeDownloadTask", "fail, invalid downloadId = ".concat(String.valueOf(optLong)));
                aVar.d("invalid_downloadid", null);
                AppMethodBeat.o(136080);
                return;
            }
            com.tencent.mm.plugin.downloader.f.a hv = c.hv(optLong);
            if (hv != null) {
                b.eBF.a(hv.field_appId, hv.field_scene, 10, hv.field_startSize, hv.field_downloadedSize - hv.field_startSize, hv.field_totalSize, hv.field_downloadUrl, hv.field_errCode, hv.field_downloaderType, hv.field_channelId, (System.currentTimeMillis() - hv.field_startTime) / 1000, hv.field_startState, hv.field_downloadId, hv.field_extInfo, 0);
            }
            final bc.a aVar2 = aVar;
            com.tencent.mm.plugin.downloader_app.b.c.a(context, hv, null, new com.tencent.mm.plugin.downloader_app.a.a.b() {
                public final void a(com.tencent.mm.plugin.downloader_app.a.a.a aVar, long j) {
                    AppMethodBeat.i(136079);
                    if (aVar == com.tencent.mm.plugin.downloader_app.a.a.a.OK) {
                        aVar2.d(null, null);
                        AppMethodBeat.o(136079);
                    } else if (aVar == com.tencent.mm.plugin.downloader_app.a.a.a.FAIL) {
                        aVar2.d("fail", null);
                        AppMethodBeat.o(136079);
                    } else {
                        if (aVar == com.tencent.mm.plugin.downloader_app.a.a.a.WAIT_FOR_WIFI) {
                            aVar2.d("wait_for_wifi", null);
                        }
                        AppMethodBeat.o(136079);
                    }
                }
            });
            AppMethodBeat.o(136080);
        } catch (JSONException e) {
            ab.e("MicroMsg.JsApiResumeDownloadTask", "paras data error: " + e.getMessage());
            aVar.d("fail", null);
            AppMethodBeat.o(136080);
        }
    }
}
