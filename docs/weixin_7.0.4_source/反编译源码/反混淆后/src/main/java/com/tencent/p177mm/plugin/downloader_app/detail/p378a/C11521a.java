package com.tencent.p177mm.plugin.downloader_app.detail.p378a;

import android.content.Context;
import android.widget.Toast;
import com.tencent.luggage.p146d.C37393a.C32183a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C1445f;
import com.tencent.p177mm.game.report.api.C45405b;
import com.tencent.p177mm.p1378ce.C26006a;
import com.tencent.p177mm.plugin.appbrand.jsapi.appdownload.JsApiAddDownloadTaskStraight;
import com.tencent.p177mm.plugin.downloader_app.p1251a.C20334a.C20331a;
import com.tencent.p177mm.plugin.downloader_app.p1251a.C20334a.C20332b;
import com.tencent.p177mm.plugin.downloader_app.p377b.C45833a;
import com.tencent.p177mm.plugin.downloader_app.p377b.C45836c;
import com.tencent.p177mm.plugin.webview.luggage.jsapi.C22840bc;
import com.tencent.p177mm.plugin.webview.luggage.jsapi.C22840bc.C22841a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.downloader_app.detail.a.a */
public class C11521a extends C22840bc {
    public final String name() {
        return JsApiAddDownloadTaskStraight.NAME;
    }

    public final int biG() {
        return 1;
    }

    /* renamed from: b */
    public final void mo9618b(C32183a c32183a) {
    }

    /* renamed from: a */
    public final void mo9617a(final Context context, String str, final C22841a c22841a) {
        AppMethodBeat.m2504i(136068);
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("task_url");
            long optLong = jSONObject.optLong("task_size");
            if (C5046bo.isNullOrNil(optString)) {
                C4990ab.m7412e("MicroMsg.JsApiAddDownloadTaskStraight", "url is null");
                c22841a.mo26722d("fail", null);
                AppMethodBeat.m2505o(136068);
                return;
            }
            C45405b.eBF.mo73200a(jSONObject.optString("appid"), (int) Downloads.MIN_WAIT_FOR_NETWORK, 9, -1, "", null);
            if (!C5023at.isNetworkConnected(context)) {
                c22841a.mo26722d("fail_network_not_connected", null);
                C26006a.m41506q(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(136064);
                        Toast.makeText(context, context.getString(C25738R.string.c5d), 0).show();
                        AppMethodBeat.m2505o(136064);
                    }
                });
                C4990ab.m7416i("MicroMsg.JsApiAddDownloadTaskStraight", " fail, network not ready");
                AppMethodBeat.m2505o(136068);
            } else if (!C1445f.m3070Mn()) {
                c22841a.mo26722d("sdcard_not_ready", null);
                C26006a.m41506q(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(136065);
                        Toast.makeText(context, context.getString(C25738R.string.c5h), 0).show();
                        AppMethodBeat.m2505o(136065);
                    }
                });
                C4990ab.m7416i("MicroMsg.JsApiAddDownloadTaskStraight", " fail, sdcard not ready");
                AppMethodBeat.m2505o(136068);
            } else if (optLong <= 0 || C1445f.m3072eW(optLong)) {
                optString = jSONObject.optString("task_name");
                String optString2 = jSONObject.optString("task_url");
                String optString3 = jSONObject.optString("alternative_url");
                long optLong2 = jSONObject.optLong("task_size");
                String optString4 = jSONObject.optString("file_md5");
                String optString5 = jSONObject.optString(IssueStorage.COLUMN_EXT_INFO);
                String optString6 = jSONObject.optString("appid");
                String optString7 = jSONObject.optString("package_name");
                int optInt = jSONObject.optInt("downloader_type", 1);
                C45833a c45833a = new C45833a();
                c45833a.appName = optString;
                c45833a.downloadUrl = optString2;
                c45833a.kOB = optString3;
                c45833a.kOC = optLong2;
                c45833a.kOD = optString4;
                c45833a.extInfo = optString5;
                c45833a.appId = optString6;
                c45833a.packageName = optString7;
                c45833a.cBA = optInt;
                C45836c.m84834a(context, c45833a, new C20332b() {
                    /* renamed from: a */
                    public final void mo9713a(C20331a c20331a, long j) {
                        AppMethodBeat.m2504i(136067);
                        JSONObject jSONObject;
                        if (j < 0) {
                            c22841a.mo26722d("fail", null);
                            AppMethodBeat.m2505o(136067);
                        } else if (c20331a == C20331a.OK) {
                            try {
                                jSONObject = new JSONObject();
                                jSONObject.put("download_id", j);
                                c22841a.mo26722d(null, jSONObject);
                                AppMethodBeat.m2505o(136067);
                            } catch (JSONException e) {
                                c22841a.mo26722d(null, null);
                                AppMethodBeat.m2505o(136067);
                            }
                        } else if (c20331a == C20331a.FAIL) {
                            c22841a.mo26722d("fail", null);
                            AppMethodBeat.m2505o(136067);
                        } else {
                            if (c20331a == C20331a.WAIT_FOR_WIFI) {
                                try {
                                    jSONObject = new JSONObject();
                                    jSONObject.put("download_id", j);
                                    c22841a.mo26722d("wait_for_wifi", jSONObject);
                                    AppMethodBeat.m2505o(136067);
                                    return;
                                } catch (JSONException e2) {
                                    c22841a.mo26722d(null, null);
                                }
                            }
                            AppMethodBeat.m2505o(136067);
                        }
                    }
                });
                AppMethodBeat.m2505o(136068);
            } else {
                c22841a.mo26722d("has_not_enough_space", null);
                C26006a.m41506q(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(136066);
                        Toast.makeText(context, context.getString(C25738R.string.c5e), 0).show();
                        AppMethodBeat.m2505o(136066);
                    }
                });
                C4990ab.m7416i("MicroMsg.JsApiAddDownloadTaskStraight", "fail, not enough space, require size = ".concat(String.valueOf(optLong)));
                AppMethodBeat.m2505o(136068);
            }
        } catch (JSONException e) {
            C4990ab.m7412e("MicroMsg.JsApiAddDownloadTaskStraight", "paras data error: " + e.getMessage());
            c22841a.mo26722d("fail", null);
            AppMethodBeat.m2505o(136068);
        }
    }
}
