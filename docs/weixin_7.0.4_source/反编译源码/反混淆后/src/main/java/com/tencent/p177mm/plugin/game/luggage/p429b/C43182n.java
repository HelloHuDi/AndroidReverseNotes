package com.tencent.p177mm.plugin.game.luggage.p429b;

import android.content.Context;
import com.tencent.luggage.p146d.C37393a.C32183a;
import com.tencent.luggage.p147g.C32192i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p231a.C37722gx;
import com.tencent.p177mm.plugin.game.luggage.p432d.C12140e;
import com.tencent.p177mm.plugin.webview.luggage.jsapi.C22840bc.C22841a;
import com.tencent.p177mm.plugin.webview.luggage.jsapi.C46419bd;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.game.luggage.b.n */
public class C43182n extends C46419bd<C12140e> {
    public final String name() {
        return "operateGameCenterMsg";
    }

    public final int biG() {
        return 1;
    }

    /* renamed from: b */
    public final void mo9618b(C32183a c32183a) {
    }

    /* renamed from: a */
    public final void mo9617a(Context context, String str, C22841a c22841a) {
        AppMethodBeat.m2504i(135884);
        C4990ab.m7416i("MicroMsg.JsApiOperateGameCenterMsg", "invokeInMM");
        JSONObject bQ = C32192i.m52508bQ(str);
        if (bQ == null) {
            C4990ab.m7416i("MicroMsg.JsApiOperateGameCenterMsg", "data is null");
            c22841a.mo26722d("invalid_data", null);
            AppMethodBeat.m2505o(135884);
            return;
        }
        int optInt = bQ.optInt("cmd");
        bQ = bQ.optJSONObject("param");
        C37722gx c37722gx = new C37722gx();
        c37722gx.cBD.f16120Cn = optInt;
        c37722gx.cBD.cBy = bQ.toString();
        C4879a.xxA.mo10055m(c37722gx);
        bQ = new JSONObject();
        try {
            bQ.put("result", C5046bo.nullAsNil(c37722gx.cBE.cBF));
        } catch (JSONException e) {
        }
        c22841a.mo26722d(null, bQ);
        AppMethodBeat.m2505o(135884);
    }
}
