package com.tencent.p177mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.p146d.C37393a.C32183a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.plugin.webview.luggage.C24905d;
import com.tencent.p177mm.plugin.webview.luggage.jsapi.C22840bc.C22841a;
import com.tencent.p177mm.plugin.webview.luggage.p1420c.C29782c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4995ag;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.webview.luggage.jsapi.r */
public class C29806r extends C46419bd<C24905d> {
    public final String name() {
        return "getOpenDeviceId";
    }

    public final int biG() {
        return 1;
    }

    /* renamed from: b */
    public final void mo9618b(C32183a c32183a) {
    }

    /* renamed from: a */
    public final void mo9617a(Context context, String str, C22841a c22841a) {
        AppMethodBeat.m2504i(6313);
        C4990ab.m7416i("MicroMsg.JsApiGetOpenDeviceId", "invokeInMM");
        JSONObject AI = C29782c.m47225AI(str);
        if (AI == null) {
            C4990ab.m7412e("MicroMsg.JsApiGetOpenDeviceId", "data is null");
            c22841a.mo26722d("fail", null);
            AppMethodBeat.m2505o(6313);
            return;
        }
        String optString = AI.optString("preVerifyAppId");
        String LK = C1427q.m3026LK();
        String LM = C1427q.m3028LM();
        if (C5046bo.isNullOrNil(LK) || C5046bo.isNullOrNil(LM) || C5046bo.isNullOrNil(optString)) {
            c22841a.mo26722d("fail", null);
            AppMethodBeat.m2505o(6313);
            return;
        }
        LK = C4995ag.m7428ck(C4995ag.m7428ck(optString + LK));
        optString = C4995ag.m7428ck(C4995ag.m7428ck(optString + LM));
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("deviceid", LK);
            jSONObject.put("newDeviceId", optString);
        } catch (JSONException e) {
        }
        c22841a.mo26722d(null, jSONObject);
        AppMethodBeat.m2505o(6313);
    }
}
