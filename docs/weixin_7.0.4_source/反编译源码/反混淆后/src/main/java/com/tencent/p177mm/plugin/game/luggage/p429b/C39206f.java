package com.tencent.p177mm.plugin.game.luggage.p429b;

import android.content.Context;
import com.tencent.luggage.p146d.C37393a.C32183a;
import com.tencent.luggage.p147g.C32192i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p231a.C9367gu;
import com.tencent.p177mm.plugin.game.luggage.p432d.C12140e;
import com.tencent.p177mm.plugin.webview.luggage.jsapi.C22840bc;
import com.tencent.p177mm.plugin.webview.luggage.jsapi.C22840bc.C22841a;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.game.luggage.b.f */
public class C39206f extends C22840bc<C12140e> {
    public final String name() {
        return "getGameCommInfo";
    }

    public final int biG() {
        return 1;
    }

    /* renamed from: b */
    public final void mo9618b(C32183a c32183a) {
    }

    /* renamed from: a */
    public final void mo9617a(Context context, String str, C22841a c22841a) {
        AppMethodBeat.m2504i(135871);
        C4990ab.m7416i("MicroMsg.JsApiGetGameCommInfo", "invoke");
        JSONObject bQ = C32192i.m52508bQ(str);
        if (bQ == null) {
            C4990ab.m7412e("MicroMsg.JsApiGetGameCommInfo", "data is null");
            c22841a.mo26722d("invalid_data", null);
            AppMethodBeat.m2505o(135871);
            return;
        }
        int optInt = bQ.optInt("cmd", 0);
        String optString = bQ.optString("param");
        if (optInt == 10002) {
            bQ = new JSONObject();
            try {
                bQ.put("webpageCount", 1);
            } catch (JSONException e) {
            }
            c22841a.mo26722d(null, bQ);
            AppMethodBeat.m2505o(135871);
            return;
        }
        C9367gu c9367gu = new C9367gu();
        c9367gu.cBw.f2862Cn = optInt;
        c9367gu.cBw.cBy = optString;
        c9367gu.cBw.context = context;
        C4879a.xxA.mo10055m(c9367gu);
        try {
            c22841a.mo26722d(null, new JSONObject(c9367gu.cBx.result));
            AppMethodBeat.m2505o(135871);
        } catch (JSONException e2) {
            c22841a.mo26722d(null, null);
            AppMethodBeat.m2505o(135871);
        }
    }
}
