package com.tencent.p177mm.plugin.game.luggage.p429b;

import android.content.Context;
import com.tencent.luggage.p146d.C37393a.C32183a;
import com.tencent.luggage.p147g.C32192i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p231a.C9497vv;
import com.tencent.p177mm.plugin.game.luggage.p432d.C12140e;
import com.tencent.p177mm.plugin.webview.luggage.jsapi.C22840bc.C22841a;
import com.tencent.p177mm.plugin.webview.luggage.jsapi.C46419bd;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.game.luggage.b.c */
public class C39205c extends C46419bd<C12140e> {
    public final int biG() {
        return 1;
    }

    /* renamed from: b */
    public final void mo9618b(C32183a c32183a) {
    }

    /* renamed from: a */
    public final void mo9617a(Context context, String str, C22841a c22841a) {
        AppMethodBeat.m2504i(135868);
        C4990ab.m7416i("MicroMsg.JsApiBatchUpdateWepkg", "invokeInMM");
        JSONObject bQ = C32192i.m52508bQ(str);
        if (bQ == null) {
            C4990ab.m7412e("MicroMsg.JsApiBatchUpdateWepkg", "data is null");
            c22841a.mo26722d("fail", null);
            AppMethodBeat.m2505o(135868);
            return;
        }
        String optString = bQ.optString("pkgIdList");
        if (!C5046bo.isNullOrNil(optString)) {
            try {
                JSONArray jSONArray = new JSONArray(optString);
                if (jSONArray.length() > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        arrayList.add(jSONArray.optString(i));
                    }
                    if (!C5046bo.m7548ek(arrayList)) {
                        C9497vv c9497vv = new C9497vv();
                        c9497vv.cSX.cuy = 8;
                        c9497vv.cSX.scene = 0;
                        c9497vv.cSX.cTc = arrayList;
                        C4879a.xxA.mo10055m(c9497vv);
                        c22841a.mo26722d(null, null);
                        AppMethodBeat.m2505o(135868);
                        return;
                    }
                }
            } catch (JSONException e) {
                C4990ab.m7412e("MicroMsg.JsApiBatchUpdateWepkg", "data is not json");
            }
        }
        c22841a.mo26722d("fail", null);
        AppMethodBeat.m2505o(135868);
    }

    public final String name() {
        return "batchUpdateWepkg";
    }
}
