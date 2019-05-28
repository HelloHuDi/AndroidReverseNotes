package com.tencent.p177mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.p146d.C37393a.C32183a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.webview.luggage.C24905d;
import com.tencent.p177mm.plugin.webview.luggage.jsapi.C22840bc.C22841a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.webview.luggage.jsapi.l */
public class C40241l extends C46419bd<C24905d> {
    public final String name() {
        return "currentMpInfo";
    }

    public final int biG() {
        return 0;
    }

    /* renamed from: a */
    public final void mo9617a(Context context, String str, C22841a c22841a) {
    }

    /* renamed from: b */
    public final void mo9618b(C32183a c32183a) {
        AppMethodBeat.m2504i(6306);
        JSONObject jSONObject = c32183a.bPa.bOf;
        String optString = jSONObject.optString("brandIcon");
        jSONObject.optString("brandName");
        C4990ab.m7417i("MicroMsg.JsApiCurrentMpInfo", "doCurrentMpInfo brandIcon:%s", optString);
        ((C24905d) c32183a.bOZ).cWP().afX(optString);
        c32183a.mo52824a("", null);
        AppMethodBeat.m2505o(6306);
    }
}
