package com.tencent.p177mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.p146d.C17821n;
import com.tencent.luggage.p146d.C37393a.C32183a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.appdownload.JsApiCancelDownloadTask;
import com.tencent.p177mm.plugin.downloader.model.C2896d;
import com.tencent.p177mm.plugin.webview.luggage.jsapi.C22840bc.C22841a;
import com.tencent.p177mm.plugin.webview.luggage.p1420c.C43886b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.webview.luggage.jsapi.e */
public class C43899e extends C22840bc<C17821n> {
    public final String name() {
        return JsApiCancelDownloadTask.NAME;
    }

    public final int biG() {
        return 1;
    }

    /* renamed from: b */
    public final void mo9618b(C32183a c32183a) {
    }

    /* renamed from: a */
    public final void mo9617a(Context context, String str, C22841a c22841a) {
        AppMethodBeat.m2504i(6284);
        C4990ab.m7416i("MicroMsg.JsApiCancelDownloadTask", "invokeInMM");
        JSONObject AI = C43886b.m78710AI(str);
        if (AI == null) {
            c22841a.mo26722d("fail", null);
            AppMethodBeat.m2505o(6284);
            return;
        }
        long optLong = AI.optLong("download_id");
        if (optLong <= 0) {
            C4990ab.m7412e("MicroMsg.JsApiCancelDownloadTask", "fail, invalid downloadId = ".concat(String.valueOf(optLong)));
            c22841a.mo26722d("invalid_downloadid", null);
            AppMethodBeat.m2505o(6284);
        } else if (C2896d.bij().mo7047hl(optLong) > 0) {
            c22841a.mo26722d(null, null);
            AppMethodBeat.m2505o(6284);
        } else {
            c22841a.mo26722d("fail", null);
            AppMethodBeat.m2505o(6284);
        }
    }
}
