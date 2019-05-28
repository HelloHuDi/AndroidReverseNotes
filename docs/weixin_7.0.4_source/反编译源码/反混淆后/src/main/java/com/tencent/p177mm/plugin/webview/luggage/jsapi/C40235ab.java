package com.tencent.p177mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.p146d.C37393a.C32183a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.appbrand.jsapi.miniprogram_navigator.JsApiLaunchMiniProgram;
import com.tencent.p177mm.plugin.appbrand.service.C45691e;
import com.tencent.p177mm.plugin.webview.luggage.C24905d;
import com.tencent.p177mm.plugin.webview.luggage.jsapi.C22840bc.C22841a;
import com.tencent.p177mm.plugin.webview.luggage.p1420c.C29782c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.webview.luggage.jsapi.ab */
public class C40235ab extends C46419bd<C24905d> {
    public final String name() {
        return JsApiLaunchMiniProgram.NAME;
    }

    public final int biG() {
        return 2;
    }

    /* renamed from: b */
    public final void mo9618b(C32183a c32183a) {
    }

    /* renamed from: a */
    public final void mo9617a(Context context, String str, C22841a c22841a) {
        int i = 1;
        AppMethodBeat.m2504i(6330);
        C4990ab.m7416i("MicroMsg.JsApiLaunchMiniProgram", "invoke");
        JSONObject AI = C29782c.m47225AI(str);
        if (AI == null) {
            C4990ab.m7412e("MicroMsg.JsApiLaunchMiniProgram", "data is null");
            c22841a.mo26722d("fail_null_data", null);
            AppMethodBeat.m2505o(6330);
            return;
        }
        String optString = AI.optString("targetAppId");
        String optString2 = AI.optString("currentUrl");
        String optString3 = AI.optString("preVerifyAppId");
        if (C5046bo.isNullOrNil(optString3)) {
            optString3 = AI.optString("referrerAppId");
        }
        if (C5046bo.isNullOrNil(optString)) {
            c22841a.mo26722d("invalid_targetAppId", null);
            AppMethodBeat.m2505o(6330);
        } else if (C5046bo.isNullOrNil(optString3)) {
            c22841a.mo26722d("invalid_referrerAppId", null);
            AppMethodBeat.m2505o(6330);
        } else {
            String nullAsNil = C5046bo.nullAsNil(AI.optString("envVersion"));
            int i2 = -1;
            switch (nullAsNil.hashCode()) {
                case 110628630:
                    if (nullAsNil.equals("trial")) {
                        i2 = 1;
                        break;
                    }
                    break;
                case 1559690845:
                    if (nullAsNil.equals("develop")) {
                        i2 = 0;
                        break;
                    }
                    break;
            }
            switch (i2) {
                case 0:
                    break;
                case 1:
                    i = 2;
                    break;
                default:
                    i = 0;
                    break;
            }
            ((C45691e) C1720g.m3528K(C45691e.class)).mo68051b(context, optString2, optString3, optString, i, AI.optString("path"), 0);
            c22841a.mo26722d(null, null);
            AppMethodBeat.m2505o(6330);
        }
    }
}
