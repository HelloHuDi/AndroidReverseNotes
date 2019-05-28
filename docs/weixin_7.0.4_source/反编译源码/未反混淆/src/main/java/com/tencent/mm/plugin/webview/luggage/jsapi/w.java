package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.d.a.a;
import com.tencent.luggage.d.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiInstallDownloadTask;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONException;
import org.json.JSONObject;

public class w extends bc<n> {
    public final String name() {
        return JsApiInstallDownloadTask.NAME;
    }

    public final int biG() {
        return 1;
    }

    public final void b(a aVar) {
    }

    public final void a(Context context, String str, final bc.a aVar) {
        AppMethodBeat.i(6319);
        ab.i("MicroMsg.JsApiInstallDownloadTask", "invokeInOwn");
        try {
            long optLong = new JSONObject(str).optLong("download_id");
            if (optLong <= 0) {
                ab.i("MicroMsg.JsApiInstallDownloadTask", "data is null");
                aVar.d("fail_invalid_data", null);
                AppMethodBeat.o(6319);
                return;
            }
            FileDownloadTaskInfo hm = d.bij().hm(optLong);
            if (hm.status == -1) {
                ab.e("MicroMsg.JsApiInstallDownloadTask", "installDownloadTask fail, apilevel not supported");
                aVar.d("fail", null);
                AppMethodBeat.o(6319);
            } else if (hm.status != 3) {
                ab.e("MicroMsg.JsApiInstallDownloadTask", "installDownloadTask fail, invalid status = " + hm.status);
                aVar.d("fail", null);
                AppMethodBeat.o(6319);
            } else {
                com.tencent.mm.plugin.downloader.h.a.a(hm.id, false, new com.tencent.mm.pluginsdk.permission.a() {
                    public final void dT(boolean z) {
                        AppMethodBeat.i(6318);
                        if (z) {
                            aVar.d(null, null);
                            AppMethodBeat.o(6318);
                            return;
                        }
                        aVar.d("fail", null);
                        AppMethodBeat.o(6318);
                    }
                });
                AppMethodBeat.o(6319);
            }
        } catch (JSONException e) {
            ab.e("MicroMsg.JsApiInstallDownloadTask", "paras data error: " + e.getMessage());
            aVar.d("fail", null);
            AppMethodBeat.o(6319);
        }
    }
}
