package com.tencent.p177mm.plugin.downloader_app.detail.p378a;

import android.content.Context;
import com.tencent.luggage.p146d.C37393a.C32183a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.game.report.api.C45405b;
import com.tencent.p177mm.plugin.appbrand.jsapi.JsApiResumeDownloadTask;
import com.tencent.p177mm.plugin.downloader.model.C2895c;
import com.tencent.p177mm.plugin.downloader.p1607f.C42911a;
import com.tencent.p177mm.plugin.downloader_app.p1251a.C20334a.C20331a;
import com.tencent.p177mm.plugin.downloader_app.p1251a.C20334a.C20332b;
import com.tencent.p177mm.plugin.downloader_app.p377b.C45836c;
import com.tencent.p177mm.plugin.webview.luggage.jsapi.C22840bc;
import com.tencent.p177mm.plugin.webview.luggage.jsapi.C22840bc.C22841a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.downloader_app.detail.a.g */
public class C27719g extends C22840bc {
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
        AppMethodBeat.m2504i(136080);
        C4990ab.m7416i("MicroMsg.JsApiResumeDownloadTask", "invokeInMM");
        try {
            long optLong = new JSONObject(str).optLong("download_id");
            if (optLong <= 0) {
                C4990ab.m7412e("MicroMsg.JsApiResumeDownloadTask", "fail, invalid downloadId = ".concat(String.valueOf(optLong)));
                c22841a.mo26722d("invalid_downloadid", null);
                AppMethodBeat.m2505o(136080);
                return;
            }
            C42911a hv = C2895c.m5147hv(optLong);
            if (hv != null) {
                C45405b.eBF.mo60568a(hv.field_appId, hv.field_scene, 10, hv.field_startSize, hv.field_downloadedSize - hv.field_startSize, hv.field_totalSize, hv.field_downloadUrl, hv.field_errCode, hv.field_downloaderType, hv.field_channelId, (System.currentTimeMillis() - hv.field_startTime) / 1000, hv.field_startState, hv.field_downloadId, hv.field_extInfo, 0);
            }
            final C22841a c22841a2 = c22841a;
            C45836c.m84833a(context, hv, null, new C20332b() {
                /* renamed from: a */
                public final void mo9713a(C20331a c20331a, long j) {
                    AppMethodBeat.m2504i(136079);
                    if (c20331a == C20331a.OK) {
                        c22841a2.mo26722d(null, null);
                        AppMethodBeat.m2505o(136079);
                    } else if (c20331a == C20331a.FAIL) {
                        c22841a2.mo26722d("fail", null);
                        AppMethodBeat.m2505o(136079);
                    } else {
                        if (c20331a == C20331a.WAIT_FOR_WIFI) {
                            c22841a2.mo26722d("wait_for_wifi", null);
                        }
                        AppMethodBeat.m2505o(136079);
                    }
                }
            });
            AppMethodBeat.m2505o(136080);
        } catch (JSONException e) {
            C4990ab.m7412e("MicroMsg.JsApiResumeDownloadTask", "paras data error: " + e.getMessage());
            c22841a.mo26722d("fail", null);
            AppMethodBeat.m2505o(136080);
        }
    }
}
