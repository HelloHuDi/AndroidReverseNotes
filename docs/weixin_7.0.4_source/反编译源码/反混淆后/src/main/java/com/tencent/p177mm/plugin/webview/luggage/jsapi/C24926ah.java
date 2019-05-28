package com.tencent.p177mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.p146d.C17821n;
import com.tencent.luggage.p146d.C37393a.C32183a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.appdownload.JsApiPauseDownloadTask;
import com.tencent.p177mm.plugin.downloader.model.C2895c;
import com.tencent.p177mm.plugin.downloader.model.C2896d;
import com.tencent.p177mm.plugin.downloader.p1607f.C42911a;
import com.tencent.p177mm.plugin.webview.luggage.jsapi.C22840bc.C22841a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.webview.luggage.jsapi.ah */
public class C24926ah extends C22840bc<C17821n> {
    public final String name() {
        return JsApiPauseDownloadTask.NAME;
    }

    public final int biG() {
        return 1;
    }

    /* renamed from: b */
    public final void mo9618b(C32183a c32183a) {
    }

    /* renamed from: a */
    public final void mo9617a(Context context, String str, C22841a c22841a) {
        AppMethodBeat.m2504i(6343);
        try {
            long optLong = new JSONObject(str).optLong("download_id");
            if (optLong <= 0) {
                C4990ab.m7412e("MicroMsg.JsApiPauseDownloadTask", "fail, invalid downloadId = ".concat(String.valueOf(optLong)));
                c22841a.mo26722d("invalid_downloadid", null);
                AppMethodBeat.m2505o(6343);
                return;
            }
            C42911a hv = C2895c.m5147hv(optLong);
            if (hv == null) {
                c22841a.mo26722d(null, null);
                AppMethodBeat.m2505o(6343);
                return;
            }
            if (hv.field_downloadInWifi) {
                hv.field_downloadInWifi = false;
                C2895c.m5146e(hv);
            }
            if (C2896d.bij().mo7049hn(optLong)) {
                c22841a.mo26722d(null, null);
                AppMethodBeat.m2505o(6343);
                return;
            }
            c22841a.mo26722d("fail", null);
            AppMethodBeat.m2505o(6343);
        } catch (JSONException e) {
            C4990ab.m7412e("MicroMsg.JsApiPauseDownloadTask", "paras data error: " + e.getMessage());
            c22841a.mo26722d("fail", null);
            AppMethodBeat.m2505o(6343);
        }
    }
}
