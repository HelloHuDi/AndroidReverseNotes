package com.tencent.p177mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.Toast;
import com.tencent.luggage.p146d.C17821n;
import com.tencent.luggage.p146d.C37393a.C32183a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C1445f;
import com.tencent.p177mm.game.report.api.C45405b;
import com.tencent.p177mm.modelstat.C26483d;
import com.tencent.p177mm.p230g.p231a.C45327gw;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.appbrand.jsapi.appdownload.JsApiAddDownloadTaskStraight;
import com.tencent.p177mm.plugin.downloader.model.C2896d;
import com.tencent.p177mm.plugin.downloader.model.C2900e;
import com.tencent.p177mm.plugin.downloader.model.C2900e.C2901a;
import com.tencent.p177mm.plugin.downloader_app.p377b.C45833a;
import com.tencent.p177mm.plugin.webview.luggage.jsapi.C22840bc.C22841a;
import com.tencent.p177mm.plugin.webview.luggage.p1420c.C29782c;
import com.tencent.p177mm.plugin.webview.p580ui.tools.game.C35675i;
import com.tencent.p177mm.plugin.webview.p580ui.tools.game.C35675i.C4624a;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.webview.luggage.jsapi.a */
public class C14479a extends C22840bc<C17821n> {
    public final String name() {
        return JsApiAddDownloadTaskStraight.NAME;
    }

    public final int biG() {
        return 2;
    }

    /* renamed from: b */
    public final void mo9618b(C32183a c32183a) {
    }

    /* renamed from: a */
    public final void mo9617a(final Context context, String str, final C22841a c22841a) {
        AppMethodBeat.m2504i(6270);
        try {
            final JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("task_url");
            long optLong = jSONObject.optLong("task_size");
            if (C5046bo.isNullOrNil(optString)) {
                C4990ab.m7412e("MicroMsg.JsApiAddDownloadTaskStraight", "url is null");
                c22841a.mo26722d("fail", null);
                AppMethodBeat.m2505o(6270);
                return;
            }
            C45405b.eBF.mo73200a(jSONObject.optString("appid"), jSONObject.optInt("scene", 1000), 9, -1, "", null);
            if (jSONObject.optBoolean("use_downloader_widget", false)) {
                C35675i.m58527a(context, C45833a.m84829R(jSONObject), new C4624a() {
                    /* renamed from: d */
                    public final void mo9715d(String str, JSONObject jSONObject) {
                        AppMethodBeat.m2504i(6269);
                        c22841a.mo26722d(str, jSONObject);
                        AppMethodBeat.m2505o(6269);
                    }
                });
                C26483d.m42196b(10, "LuggageGameWebViewUI_addDownloadTask", hashCode());
                AppMethodBeat.m2505o(6270);
            } else if (!C5023at.isNetworkConnected(context)) {
                c22841a.mo26722d("fail_network_not_connected", null);
                C29782c.runOnUiThread(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(6264);
                        Toast.makeText(context, context.getString(C25738R.string.c5d), 0).show();
                        AppMethodBeat.m2505o(6264);
                    }
                });
                C4990ab.m7416i("MicroMsg.JsApiAddDownloadTaskStraight", " fail, network not ready");
                AppMethodBeat.m2505o(6270);
            } else if (!C1445f.m3070Mn()) {
                c22841a.mo26722d("sdcard_not_ready", null);
                C29782c.runOnUiThread(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(6265);
                        Toast.makeText(context, context.getString(C25738R.string.c5h), 0).show();
                        AppMethodBeat.m2505o(6265);
                    }
                });
                C4990ab.m7416i("MicroMsg.JsApiAddDownloadTaskStraight", " fail, sdcard not ready");
                AppMethodBeat.m2505o(6270);
            } else if (optLong > 0 && !C1445f.m3072eW(optLong)) {
                c22841a.mo26722d("has_not_enough_space", null);
                C29782c.runOnUiThread(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(6266);
                        Toast.makeText(context, context.getString(C25738R.string.c5e), 0).show();
                        AppMethodBeat.m2505o(6266);
                    }
                });
                C4990ab.m7416i("MicroMsg.JsApiAddDownloadTaskStraight", "fail, not enough space, require size = ".concat(String.valueOf(optLong)));
                AppMethodBeat.m2505o(6270);
            } else if (C5023at.isWifi(context)) {
                m22685a(jSONObject, c22841a);
                AppMethodBeat.m2505o(6270);
            } else {
                C30379h.m48446a(context, context.getString(C25738R.string.fy6), context.getString(C25738R.string.fy7), context.getString(C25738R.string.fy1), context.getString(C25738R.string.f9076or), false, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(6267);
                        C14479a.m22684a(C14479a.this, jSONObject, c22841a);
                        dialogInterface.dismiss();
                        AppMethodBeat.m2505o(6267);
                    }
                }, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(6268);
                        dialogInterface.dismiss();
                        c22841a.mo26722d("network_not_wifi", null);
                        AppMethodBeat.m2505o(6268);
                    }
                }, (int) C25738R.color.a61);
                AppMethodBeat.m2505o(6270);
            }
        } catch (JSONException e) {
            C4990ab.m7412e("MicroMsg.JsApiAddDownloadTaskStraight", "paras data error: " + e.getMessage());
            c22841a.mo26722d("fail", null);
            AppMethodBeat.m2505o(6270);
        }
    }

    /* renamed from: a */
    private void m22685a(JSONObject jSONObject, C22841a c22841a) {
        long b;
        AppMethodBeat.m2504i(6271);
        C45327gw c45327gw = new C45327gw();
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
        c45327gw.cBC.url = optString2;
        c45327gw.cBC.cvZ = optString4;
        c45327gw.cBC.extInfo = optString5;
        c45327gw.cBC.appId = optString7;
        c45327gw.cBC.scene = optInt;
        C4879a.xxA.mo10055m(c45327gw);
        C2901a c2901a = new C2901a();
        c2901a.mo7055It(optString2);
        c2901a.mo7056Iu(optString3);
        c2901a.mo7066hA(optLong);
        c2901a.mo7057Iv(optString);
        c2901a.mo7058Iw(optString4);
        c2901a.setAppId(optString7);
        c2901a.mo7062cY(optString8);
        c2901a.mo7063ga(true);
        c2901a.mo7069tN(C5046bo.getInt(optString6, 1));
        c2901a.setScene(optInt);
        C2900e c2900e = c2901a.kNl;
        if (optInt2 == 1) {
            b = C2896d.bij().mo7043b(c2900e);
        } else {
            b = C2896d.bij().mo7042a(c2900e);
        }
        C26483d.m42196b(10, "LuggageGameWebViewUI_addDownloadTask", hashCode());
        if (b <= 0) {
            c22841a.mo26722d("fail", null);
            AppMethodBeat.m2505o(6271);
            return;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("download_id", b);
            c22841a.mo26722d(null, jSONObject2);
            AppMethodBeat.m2505o(6271);
        } catch (JSONException e) {
            c22841a.mo26722d(null, null);
            AppMethodBeat.m2505o(6271);
        }
    }
}
