package com.tencent.p177mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.luggage.p146d.C17821n;
import com.tencent.luggage.p146d.C37393a.C32183a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.game.report.api.C45405b;
import com.tencent.p177mm.modelstat.C26483d;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.appbrand.jsapi.JsApiResumeDownloadTask;
import com.tencent.p177mm.plugin.downloader.model.C2895c;
import com.tencent.p177mm.plugin.downloader.model.C2896d;
import com.tencent.p177mm.plugin.downloader.p1607f.C42911a;
import com.tencent.p177mm.plugin.webview.luggage.jsapi.C22840bc.C22841a;
import com.tencent.p177mm.plugin.webview.p580ui.tools.game.C35675i;
import com.tencent.p177mm.plugin.webview.p580ui.tools.game.C35675i.C4624a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.webview.luggage.jsapi.ao */
public class C29799ao extends C22840bc<C17821n> {
    public final String name() {
        return JsApiResumeDownloadTask.NAME;
    }

    public final int biG() {
        return 2;
    }

    /* renamed from: b */
    public final void mo9618b(C32183a c32183a) {
    }

    /* renamed from: a */
    public final void mo9617a(Context context, String str, C22841a c22841a) {
        AppMethodBeat.m2504i(6364);
        C4990ab.m7416i("MicroMsg.JsApiResumeDownloadTask", "invokeInMM");
        try {
            JSONObject jSONObject = new JSONObject(str);
            long optLong = jSONObject.optLong("download_id");
            if (optLong <= 0) {
                C4990ab.m7412e("MicroMsg.JsApiResumeDownloadTask", "fail, invalid downloadId = ".concat(String.valueOf(optLong)));
                c22841a.mo26722d("invalid_downloadid", null);
                AppMethodBeat.m2505o(6364);
                return;
            }
            C42911a hv = C2895c.m5147hv(optLong);
            if (hv != null) {
                C45405b.eBF.mo60568a(hv.field_appId, hv.field_scene, 10, hv.field_startSize, hv.field_downloadedSize - hv.field_startSize, hv.field_totalSize, hv.field_downloadUrl, hv.field_errCode, hv.field_downloaderType, hv.field_channelId, (System.currentTimeMillis() - hv.field_startTime) / 1000, hv.field_startState, hv.field_downloadId, hv.field_extInfo, 0);
            }
            boolean optBoolean = jSONObject.optBoolean("use_downloader_widget", false);
            boolean optBoolean2 = jSONObject.optBoolean("download_in_wifi", false);
            final C22841a c22841a2;
            if (optBoolean) {
                c22841a2 = c22841a;
                C35675i.m58526a(context, optLong, optBoolean2, new C4624a() {
                    /* renamed from: d */
                    public final void mo9715d(String str, JSONObject jSONObject) {
                        AppMethodBeat.m2504i(6363);
                        c22841a2.mo26722d(str, jSONObject);
                        AppMethodBeat.m2505o(6363);
                    }
                });
                C26483d.m42196b(10, "LuggageGameWebViewUI_resumeDownloadTask", hashCode());
                AppMethodBeat.m2505o(6364);
            } else if (C5023at.isWifi(context)) {
                m47243a(optLong, c22841a);
                AppMethodBeat.m2505o(6364);
            } else {
                String string = context.getString(C25738R.string.fy6);
                String string2 = context.getString(C25738R.string.fy7);
                String string3 = context.getString(C25738R.string.fy1);
                String string4 = context.getString(C25738R.string.f9076or);
                final JSONObject jSONObject2 = jSONObject;
                final long j = optLong;
                final C22841a c22841a3 = c22841a;
                C144911 c144911 = new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(6361);
                        C29799ao.m47244a(C29799ao.this, j, c22841a3);
                        dialogInterface.dismiss();
                        AppMethodBeat.m2505o(6361);
                    }
                };
                c22841a2 = c22841a;
                C30379h.m48446a(context, string, string2, string3, string4, false, (OnClickListener) c144911, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(6362);
                        dialogInterface.dismiss();
                        c22841a2.mo26722d("fail_network_not_wifi", null);
                        AppMethodBeat.m2505o(6362);
                    }
                }, (int) C25738R.color.a61);
                AppMethodBeat.m2505o(6364);
            }
        } catch (JSONException e) {
            C4990ab.m7412e("MicroMsg.JsApiResumeDownloadTask", "paras data error: " + e.getMessage());
            c22841a.mo26722d("fail", null);
            AppMethodBeat.m2505o(6364);
        }
    }

    /* renamed from: a */
    private void m47243a(long j, C22841a c22841a) {
        AppMethodBeat.m2504i(6365);
        C42911a hv = C2895c.m5147hv(j);
        if (hv != null && hv.field_fromDownloadApp) {
            hv.field_fromDownloadApp = false;
            hv.field_showNotification = true;
            C2895c.m5146e(hv);
        }
        if (C2896d.bij().mo7050ho(j)) {
            c22841a.mo26722d(null, null);
        } else {
            c22841a.mo26722d("fail", null);
        }
        C26483d.m42196b(10, "LuggageGameWebViewUI_resumeDownloadTask", hashCode());
        AppMethodBeat.m2505o(6365);
    }
}
