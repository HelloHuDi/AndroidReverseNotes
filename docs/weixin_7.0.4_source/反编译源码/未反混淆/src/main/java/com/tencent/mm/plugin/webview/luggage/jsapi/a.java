package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.Toast;
import com.tencent.luggage.d.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.g.a.gw;
import com.tencent.mm.game.report.api.b;
import com.tencent.mm.modelstat.d;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiAddDownloadTaskStraight;
import com.tencent.mm.plugin.downloader.model.e;
import com.tencent.mm.plugin.webview.luggage.c.c;
import com.tencent.mm.plugin.webview.ui.tools.game.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import org.json.JSONException;
import org.json.JSONObject;

public class a extends bc<n> {
    public final String name() {
        return JsApiAddDownloadTaskStraight.NAME;
    }

    public final int biG() {
        return 2;
    }

    public final void b(com.tencent.luggage.d.a.a aVar) {
    }

    public final void a(final Context context, String str, final com.tencent.mm.plugin.webview.luggage.jsapi.bc.a aVar) {
        AppMethodBeat.i(6270);
        try {
            final JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("task_url");
            long optLong = jSONObject.optLong("task_size");
            if (bo.isNullOrNil(optString)) {
                ab.e("MicroMsg.JsApiAddDownloadTaskStraight", "url is null");
                aVar.d("fail", null);
                AppMethodBeat.o(6270);
                return;
            }
            b.eBF.a(jSONObject.optString("appid"), jSONObject.optInt("scene", 1000), 9, -1, "", null);
            if (jSONObject.optBoolean("use_downloader_widget", false)) {
                i.a(context, com.tencent.mm.plugin.downloader_app.b.a.R(jSONObject), new com.tencent.mm.plugin.webview.ui.tools.game.i.a() {
                    public final void d(String str, JSONObject jSONObject) {
                        AppMethodBeat.i(6269);
                        aVar.d(str, jSONObject);
                        AppMethodBeat.o(6269);
                    }
                });
                d.b(10, "LuggageGameWebViewUI_addDownloadTask", hashCode());
                AppMethodBeat.o(6270);
            } else if (!at.isNetworkConnected(context)) {
                aVar.d("fail_network_not_connected", null);
                c.runOnUiThread(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(6264);
                        Toast.makeText(context, context.getString(R.string.c5d), 0).show();
                        AppMethodBeat.o(6264);
                    }
                });
                ab.i("MicroMsg.JsApiAddDownloadTaskStraight", " fail, network not ready");
                AppMethodBeat.o(6270);
            } else if (!f.Mn()) {
                aVar.d("sdcard_not_ready", null);
                c.runOnUiThread(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(6265);
                        Toast.makeText(context, context.getString(R.string.c5h), 0).show();
                        AppMethodBeat.o(6265);
                    }
                });
                ab.i("MicroMsg.JsApiAddDownloadTaskStraight", " fail, sdcard not ready");
                AppMethodBeat.o(6270);
            } else if (optLong > 0 && !f.eW(optLong)) {
                aVar.d("has_not_enough_space", null);
                c.runOnUiThread(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(6266);
                        Toast.makeText(context, context.getString(R.string.c5e), 0).show();
                        AppMethodBeat.o(6266);
                    }
                });
                ab.i("MicroMsg.JsApiAddDownloadTaskStraight", "fail, not enough space, require size = ".concat(String.valueOf(optLong)));
                AppMethodBeat.o(6270);
            } else if (at.isWifi(context)) {
                a(jSONObject, aVar);
                AppMethodBeat.o(6270);
            } else {
                h.a(context, context.getString(R.string.fy6), context.getString(R.string.fy7), context.getString(R.string.fy1), context.getString(R.string.or), false, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(6267);
                        a.a(a.this, jSONObject, aVar);
                        dialogInterface.dismiss();
                        AppMethodBeat.o(6267);
                    }
                }, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(6268);
                        dialogInterface.dismiss();
                        aVar.d("network_not_wifi", null);
                        AppMethodBeat.o(6268);
                    }
                }, (int) R.color.a61);
                AppMethodBeat.o(6270);
            }
        } catch (JSONException e) {
            ab.e("MicroMsg.JsApiAddDownloadTaskStraight", "paras data error: " + e.getMessage());
            aVar.d("fail", null);
            AppMethodBeat.o(6270);
        }
    }

    private void a(JSONObject jSONObject, com.tencent.mm.plugin.webview.luggage.jsapi.bc.a aVar) {
        long b;
        AppMethodBeat.i(6271);
        gw gwVar = new gw();
        String optString = jSONObject.optString("task_name");
        String optString2 = jSONObject.optString("task_url");
        String optString3 = jSONObject.optString("alternative_url");
        long optLong = jSONObject.optLong("task_size");
        String optString4 = jSONObject.optString("file_md5");
        String optString5 = jSONObject.optString(IssueStorage.COLUMN_EXT_INFO);
        String optString6 = jSONObject.optString("fileType");
        String optString7 = jSONObject.optString("appid");
        String optString8 = jSONObject.optString("package_name");
        int optInt = jSONObject.optInt("scene", 1000);
        int optInt2 = jSONObject.optInt("downloader_type", 1);
        gwVar.cBC.url = optString2;
        gwVar.cBC.cvZ = optString4;
        gwVar.cBC.extInfo = optString5;
        gwVar.cBC.appId = optString7;
        gwVar.cBC.scene = optInt;
        com.tencent.mm.sdk.b.a.xxA.m(gwVar);
        com.tencent.mm.plugin.downloader.model.e.a aVar2 = new com.tencent.mm.plugin.downloader.model.e.a();
        aVar2.It(optString2);
        aVar2.Iu(optString3);
        aVar2.hA(optLong);
        aVar2.Iv(optString);
        aVar2.Iw(optString4);
        aVar2.setAppId(optString7);
        aVar2.cY(optString8);
        aVar2.ga(true);
        aVar2.tN(bo.getInt(optString6, 1));
        aVar2.setScene(optInt);
        e eVar = aVar2.kNl;
        if (optInt2 == 1) {
            b = com.tencent.mm.plugin.downloader.model.d.bij().b(eVar);
        } else {
            b = com.tencent.mm.plugin.downloader.model.d.bij().a(eVar);
        }
        d.b(10, "LuggageGameWebViewUI_addDownloadTask", hashCode());
        if (b <= 0) {
            aVar.d("fail", null);
            AppMethodBeat.o(6271);
            return;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("download_id", b);
            aVar.d(null, jSONObject2);
            AppMethodBeat.o(6271);
        } catch (JSONException e) {
            aVar.d(null, null);
            AppMethodBeat.o(6271);
        }
    }
}
