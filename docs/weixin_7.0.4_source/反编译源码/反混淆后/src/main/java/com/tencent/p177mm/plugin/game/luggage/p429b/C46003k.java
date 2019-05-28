package com.tencent.p177mm.plugin.game.luggage.p429b;

import android.content.Context;
import com.tencent.luggage.p146d.C37393a.C32183a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p231a.C6519lw;
import com.tencent.p177mm.plugin.game.luggage.p432d.C12140e;
import com.tencent.p177mm.plugin.webview.luggage.jsapi.C22840bc;
import com.tencent.p177mm.plugin.webview.luggage.jsapi.C22840bc.C22841a;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.game.luggage.b.k */
public class C46003k extends C22840bc<C12140e> {
    public final String name() {
        return "openGameCenter";
    }

    public final int biG() {
        return 2;
    }

    /* renamed from: b */
    public final void mo9618b(C32183a c32183a) {
    }

    /* renamed from: a */
    public final void mo9617a(Context context, String str, C22841a c22841a) {
        AppMethodBeat.m2504i(135879);
        try {
            JSONObject jSONObject = new JSONObject(str);
            C4990ab.m7417i("MicroMsg.JsApiOpenGameCenter", "jumpView = %d, jumpType = %d", Integer.valueOf(jSONObject.optInt("jumpView")), Integer.valueOf(jSONObject.optInt("jumpType")));
            jSONObject = jSONObject.optJSONObject(IssueStorage.COLUMN_EXT_INFO);
            C6519lw c6519lw = new C6519lw();
            c6519lw.cHK.cHL = r1;
            c6519lw.cHK.jumpType = r2;
            if (jSONObject != null) {
                c6519lw.cHK.extraInfo = jSONObject.toString();
            }
            c6519lw.cHK.context = context;
            C4879a.xxA.mo10055m(c6519lw);
            c22841a.mo26722d(null, null);
            AppMethodBeat.m2505o(135879);
        } catch (JSONException e) {
            C4990ab.m7412e("MicroMsg.JsApiOpenGameCenter", "json parse exception");
            c22841a.mo26722d("fail", null);
            AppMethodBeat.m2505o(135879);
        }
    }
}
