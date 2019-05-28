package com.tencent.p177mm.plugin.downloader_app.detail.p378a;

import android.content.Context;
import com.tencent.luggage.p146d.C37393a.C32183a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.downloader.p943h.C33913a;
import com.tencent.p177mm.plugin.webview.luggage.jsapi.C22840bc;
import com.tencent.p177mm.plugin.webview.luggage.jsapi.C22840bc.C22841a;
import com.tencent.p177mm.pluginsdk.model.app.C14875aj;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.downloader_app.detail.a.c */
public class C33937c extends C22840bc {
    public final String name() {
        return "launchApplication";
    }

    public final int biG() {
        return 2;
    }

    /* renamed from: b */
    public final void mo9618b(C32183a c32183a) {
    }

    /* renamed from: a */
    public final void mo9617a(Context context, String str, final C22841a c22841a) {
        JSONObject jSONObject;
        AppMethodBeat.m2504i(136071);
        C4990ab.m7416i("MicroMsg.JsApiLaunchApplication", "invokeInMM");
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e) {
            C4990ab.m7412e("MicroMsg.JsApiLaunchApplication", "paras data error: " + e.getMessage());
            jSONObject = null;
        }
        if (jSONObject == null) {
            C4990ab.m7412e("MicroMsg.JsApiLaunchApplication", "data is null");
            c22841a.mo26722d("fail", null);
            AppMethodBeat.m2505o(136071);
            return;
        }
        String optString = jSONObject.optString("appID");
        if (C5046bo.isNullOrNil(optString)) {
            C4990ab.m7412e("MicroMsg.JsApiLaunchApplication", "appid is null or nil");
            c22841a.mo26722d("fail", null);
            AppMethodBeat.m2505o(136071);
            return;
        }
        C33913a.m55500a(context, optString, new C14875aj() {
            /* renamed from: dR */
            public final void mo6036dR(boolean z) {
                AppMethodBeat.m2504i(136070);
                c22841a.mo26722d(null, null);
                AppMethodBeat.m2505o(136070);
            }
        });
        AppMethodBeat.m2505o(136071);
    }
}
