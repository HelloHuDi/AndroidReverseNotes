package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.luggage.d.a.a;
import com.tencent.luggage.d.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.game.report.api.b;
import com.tencent.mm.modelstat.d;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiResumeDownloadTask;
import com.tencent.mm.plugin.downloader.model.c;
import com.tencent.mm.plugin.webview.ui.tools.game.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.ui.base.h;
import org.json.JSONException;
import org.json.JSONObject;

public class ao extends bc<n> {
    public final String name() {
        return JsApiResumeDownloadTask.NAME;
    }

    public final int biG() {
        return 2;
    }

    public final void b(a aVar) {
    }

    public final void a(Context context, String str, bc.a aVar) {
        AppMethodBeat.i(6364);
        ab.i("MicroMsg.JsApiResumeDownloadTask", "invokeInMM");
        try {
            JSONObject jSONObject = new JSONObject(str);
            long optLong = jSONObject.optLong("download_id");
            if (optLong <= 0) {
                ab.e("MicroMsg.JsApiResumeDownloadTask", "fail, invalid downloadId = ".concat(String.valueOf(optLong)));
                aVar.d("invalid_downloadid", null);
                AppMethodBeat.o(6364);
                return;
            }
            com.tencent.mm.plugin.downloader.f.a hv = c.hv(optLong);
            if (hv != null) {
                b.eBF.a(hv.field_appId, hv.field_scene, 10, hv.field_startSize, hv.field_downloadedSize - hv.field_startSize, hv.field_totalSize, hv.field_downloadUrl, hv.field_errCode, hv.field_downloaderType, hv.field_channelId, (System.currentTimeMillis() - hv.field_startTime) / 1000, hv.field_startState, hv.field_downloadId, hv.field_extInfo, 0);
            }
            boolean optBoolean = jSONObject.optBoolean("use_downloader_widget", false);
            boolean optBoolean2 = jSONObject.optBoolean("download_in_wifi", false);
            final bc.a aVar2;
            if (optBoolean) {
                aVar2 = aVar;
                i.a(context, optLong, optBoolean2, new i.a() {
                    public final void d(String str, JSONObject jSONObject) {
                        AppMethodBeat.i(6363);
                        aVar2.d(str, jSONObject);
                        AppMethodBeat.o(6363);
                    }
                });
                d.b(10, "LuggageGameWebViewUI_resumeDownloadTask", hashCode());
                AppMethodBeat.o(6364);
            } else if (at.isWifi(context)) {
                a(optLong, aVar);
                AppMethodBeat.o(6364);
            } else {
                String string = context.getString(R.string.fy6);
                String string2 = context.getString(R.string.fy7);
                String string3 = context.getString(R.string.fy1);
                String string4 = context.getString(R.string.or);
                final JSONObject jSONObject2 = jSONObject;
                final long j = optLong;
                final bc.a aVar3 = aVar;
                AnonymousClass1 anonymousClass1 = new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(6361);
                        ao.a(ao.this, j, aVar3);
                        dialogInterface.dismiss();
                        AppMethodBeat.o(6361);
                    }
                };
                aVar2 = aVar;
                h.a(context, string, string2, string3, string4, false, (OnClickListener) anonymousClass1, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(6362);
                        dialogInterface.dismiss();
                        aVar2.d("fail_network_not_wifi", null);
                        AppMethodBeat.o(6362);
                    }
                }, (int) R.color.a61);
                AppMethodBeat.o(6364);
            }
        } catch (JSONException e) {
            ab.e("MicroMsg.JsApiResumeDownloadTask", "paras data error: " + e.getMessage());
            aVar.d("fail", null);
            AppMethodBeat.o(6364);
        }
    }

    private void a(long j, bc.a aVar) {
        AppMethodBeat.i(6365);
        com.tencent.mm.plugin.downloader.f.a hv = c.hv(j);
        if (hv != null && hv.field_fromDownloadApp) {
            hv.field_fromDownloadApp = false;
            hv.field_showNotification = true;
            c.e(hv);
        }
        if (com.tencent.mm.plugin.downloader.model.d.bij().ho(j)) {
            aVar.d(null, null);
        } else {
            aVar.d("fail", null);
        }
        d.b(10, "LuggageGameWebViewUI_resumeDownloadTask", hashCode());
        AppMethodBeat.o(6365);
    }
}
