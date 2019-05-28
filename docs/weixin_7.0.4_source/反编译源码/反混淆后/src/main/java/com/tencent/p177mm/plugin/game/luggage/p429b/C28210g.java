package com.tencent.p177mm.plugin.game.luggage.p429b;

import android.content.Context;
import com.tencent.luggage.p146d.C37393a.C32183a;
import com.tencent.luggage.p147g.C32192i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.game.luggage.p432d.C12140e;
import com.tencent.p177mm.plugin.webview.luggage.jsapi.C22840bc.C22841a;
import com.tencent.p177mm.plugin.webview.luggage.jsapi.C46419bd;
import com.tencent.p177mm.plugin.webview.p768b.C35580a;
import com.tencent.p177mm.plugin.webview.p768b.C35582b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.game.luggage.b.g */
public class C28210g extends C46419bd<C12140e> {
    public final String name() {
        return "getGameData";
    }

    public final int biG() {
        return 1;
    }

    /* renamed from: b */
    public final void mo9618b(C32183a c32183a) {
    }

    /* renamed from: a */
    public final void mo9617a(Context context, String str, C22841a c22841a) {
        AppMethodBeat.m2504i(135872);
        C4990ab.m7416i("MicroMsg.JsApiGetGameData", "invokeInMM");
        JSONObject bQ = C32192i.m52508bQ(str);
        if (bQ == null) {
            C4990ab.m7412e("MicroMsg.JsApiGetGameData", "data is null");
            c22841a.mo26722d("null_data", null);
            AppMethodBeat.m2505o(135872);
            return;
        }
        String optString = bQ.optString("preVerifyAppId");
        if (C5046bo.isNullOrNil(optString)) {
            C4990ab.m7416i("MicroMsg.JsApiGetGameData", "appId is null");
            c22841a.mo26722d("appid_null", null);
            AppMethodBeat.m2505o(135872);
            return;
        }
        String optString2 = bQ.optString("key");
        if (C5046bo.isNullOrNil(optString2)) {
            C4990ab.m7416i("MicroMsg.JsApiGetGameData", "key is null");
            c22841a.mo26722d("null_key", null);
            AppMethodBeat.m2505o(135872);
            return;
        }
        C35580a gV = C35582b.cWi().mo56315gV(optString, optString2);
        if (C5046bo.isNullOrNil(gV.field_value)) {
            c22841a.mo26722d(null, null);
            AppMethodBeat.m2505o(135872);
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("value", gV.field_value);
            jSONObject.put("weight", gV.field_weight);
            jSONObject.put("expireTime", gV.field_expireTime - (System.currentTimeMillis() / 1000));
        } catch (JSONException e) {
        }
        c22841a.mo26722d(null, jSONObject);
        AppMethodBeat.m2505o(135872);
    }
}
