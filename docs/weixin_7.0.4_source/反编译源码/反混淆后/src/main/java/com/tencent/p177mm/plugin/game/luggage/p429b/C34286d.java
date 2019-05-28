package com.tencent.p177mm.plugin.game.luggage.p429b;

import android.content.Context;
import com.tencent.luggage.p146d.C37393a.C32183a;
import com.tencent.luggage.p147g.C32192i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.game.luggage.p432d.C12140e;
import com.tencent.p177mm.plugin.webview.luggage.jsapi.C22840bc.C22841a;
import com.tencent.p177mm.plugin.webview.luggage.jsapi.C46419bd;
import com.tencent.p177mm.plugin.webview.p768b.C35582b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.game.luggage.b.d */
public class C34286d extends C46419bd<C12140e> {
    public final String name() {
        return "clearGameData";
    }

    public final int biG() {
        return 1;
    }

    /* renamed from: b */
    public final void mo9618b(C32183a c32183a) {
    }

    /* renamed from: a */
    public final void mo9617a(Context context, String str, C22841a c22841a) {
        AppMethodBeat.m2504i(135869);
        C4990ab.m7416i("MicroMsg.JsApiClearGameData", "invokeInMM");
        JSONObject bQ = C32192i.m52508bQ(str);
        if (bQ == null) {
            C4990ab.m7412e("MicroMsg.JsApiClearGameData", "data is null");
            c22841a.mo26722d("null_data", null);
            AppMethodBeat.m2505o(135869);
            return;
        }
        String optString = bQ.optString("preVerifyAppId");
        if (C5046bo.isNullOrNil(optString)) {
            C4990ab.m7416i("MicroMsg.JsApiClearGameData", "appId is null");
            c22841a.mo26722d("appid_null", null);
            AppMethodBeat.m2505o(135869);
            return;
        }
        JSONArray optJSONArray = bQ.optJSONArray("keys");
        boolean optBoolean = bQ.optBoolean("clearAllData", false);
        if (optJSONArray != null && optJSONArray.length() > 0) {
            C35582b.cWi().mo56313b(optString, optJSONArray);
            c22841a.mo26722d(null, null);
            AppMethodBeat.m2505o(135869);
        } else if (optBoolean) {
            C35582b.cWi().adY(optString);
            c22841a.mo26722d(null, null);
            AppMethodBeat.m2505o(135869);
        } else {
            C4990ab.m7416i("MicroMsg.JsApiClearGameData", "keys is null");
            c22841a.mo26722d("fail", null);
            AppMethodBeat.m2505o(135869);
        }
    }
}
