package com.tencent.mm.plugin.downloader_app.detail.a;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.game.report.api.b;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiAddDownloadTaskStraight;
import com.tencent.mm.plugin.downloader_app.b.c;
import com.tencent.mm.plugin.webview.luggage.jsapi.bc;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import org.json.JSONException;
import org.json.JSONObject;

public class a extends bc {
    public final String name() {
        return JsApiAddDownloadTaskStraight.NAME;
    }

    public final int biG() {
        return 1;
    }

    public final void b(com.tencent.luggage.d.a.a aVar) {
    }

    public final void a(final Context context, String str, final com.tencent.mm.plugin.webview.luggage.jsapi.bc.a aVar) {
        AppMethodBeat.i(136068);
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("task_url");
            long optLong = jSONObject.optLong("task_size");
            if (bo.isNullOrNil(optString)) {
                ab.e("MicroMsg.JsApiAddDownloadTaskStraight", "url is null");
                aVar.d("fail", null);
                AppMethodBeat.o(136068);
                return;
            }
            b.eBF.a(jSONObject.optString("appid"), (int) Downloads.MIN_WAIT_FOR_NETWORK, 9, -1, "", null);
            if (!at.isNetworkConnected(context)) {
                aVar.d("fail_network_not_connected", null);
                com.tencent.mm.ce.a.q(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(136064);
                        Toast.makeText(context, context.getString(R.string.c5d), 0).show();
                        AppMethodBeat.o(136064);
                    }
                });
                ab.i("MicroMsg.JsApiAddDownloadTaskStraight", " fail, network not ready");
                AppMethodBeat.o(136068);
            } else if (!f.Mn()) {
                aVar.d("sdcard_not_ready", null);
                com.tencent.mm.ce.a.q(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(136065);
                        Toast.makeText(context, context.getString(R.string.c5h), 0).show();
                        AppMethodBeat.o(136065);
                    }
                });
                ab.i("MicroMsg.JsApiAddDownloadTaskStraight", " fail, sdcard not ready");
                AppMethodBeat.o(136068);
            } else if (optLong <= 0 || f.eW(optLong)) {
                optString = jSONObject.optString("task_name");
                String optString2 = jSONObject.optString("task_url");
                String optString3 = jSONObject.optString("alternative_url");
                long optLong2 = jSONObject.optLong("task_size");
                String optString4 = jSONObject.optString("file_md5");
                String optString5 = jSONObject.optString(IssueStorage.COLUMN_EXT_INFO);
                String optString6 = jSONObject.optString("appid");
                String optString7 = jSONObject.optString("package_name");
                int optInt = jSONObject.optInt("downloader_type", 1);
                com.tencent.mm.plugin.downloader_app.b.a aVar2 = new com.tencent.mm.plugin.downloader_app.b.a();
                aVar2.appName = optString;
                aVar2.downloadUrl = optString2;
                aVar2.kOB = optString3;
                aVar2.kOC = optLong2;
                aVar2.kOD = optString4;
                aVar2.extInfo = optString5;
                aVar2.appId = optString6;
                aVar2.packageName = optString7;
                aVar2.cBA = optInt;
                c.a(context, aVar2, new com.tencent.mm.plugin.downloader_app.a.a.b() {
                    public final void a(com.tencent.mm.plugin.downloader_app.a.a.a aVar, long j) {
                        AppMethodBeat.i(136067);
                        JSONObject jSONObject;
                        if (j < 0) {
                            aVar.d("fail", null);
                            AppMethodBeat.o(136067);
                        } else if (aVar == com.tencent.mm.plugin.downloader_app.a.a.a.OK) {
                            try {
                                jSONObject = new JSONObject();
                                jSONObject.put("download_id", j);
                                aVar.d(null, jSONObject);
                                AppMethodBeat.o(136067);
                            } catch (JSONException e) {
                                aVar.d(null, null);
                                AppMethodBeat.o(136067);
                            }
                        } else if (aVar == com.tencent.mm.plugin.downloader_app.a.a.a.FAIL) {
                            aVar.d("fail", null);
                            AppMethodBeat.o(136067);
                        } else {
                            if (aVar == com.tencent.mm.plugin.downloader_app.a.a.a.WAIT_FOR_WIFI) {
                                try {
                                    jSONObject = new JSONObject();
                                    jSONObject.put("download_id", j);
                                    aVar.d("wait_for_wifi", jSONObject);
                                    AppMethodBeat.o(136067);
                                    return;
                                } catch (JSONException e2) {
                                    aVar.d(null, null);
                                }
                            }
                            AppMethodBeat.o(136067);
                        }
                    }
                });
                AppMethodBeat.o(136068);
            } else {
                aVar.d("has_not_enough_space", null);
                com.tencent.mm.ce.a.q(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(136066);
                        Toast.makeText(context, context.getString(R.string.c5e), 0).show();
                        AppMethodBeat.o(136066);
                    }
                });
                ab.i("MicroMsg.JsApiAddDownloadTaskStraight", "fail, not enough space, require size = ".concat(String.valueOf(optLong)));
                AppMethodBeat.o(136068);
            }
        } catch (JSONException e) {
            ab.e("MicroMsg.JsApiAddDownloadTaskStraight", "paras data error: " + e.getMessage());
            aVar.d("fail", null);
            AppMethodBeat.o(136068);
        }
    }
}
