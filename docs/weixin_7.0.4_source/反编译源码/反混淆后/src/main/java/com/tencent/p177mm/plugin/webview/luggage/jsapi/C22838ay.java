package com.tencent.p177mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.p146d.C37393a.C32183a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.webview.luggage.C22857k;
import com.tencent.p177mm.plugin.webview.luggage.C24905d;
import com.tencent.p177mm.plugin.webview.luggage.jsapi.C22840bc.C22841a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import org.json.JSONArray;

/* renamed from: com.tencent.mm.plugin.webview.luggage.jsapi.ay */
public class C22838ay extends C46419bd<C24905d> {
    public final String name() {
        return "showMenuItems";
    }

    public final int biG() {
        return 0;
    }

    /* renamed from: b */
    public final void mo9618b(C32183a c32183a) {
        AppMethodBeat.m2504i(6384);
        C4990ab.m7416i("MicroMsg.JsApiShowMenuItems", "invokeInOwn");
        JSONArray optJSONArray = c32183a.bPa.bOf.optJSONArray("menuList");
        if (optJSONArray == null) {
            C4990ab.m7416i("MicroMsg.JsApiShowMenuItems", "data is null");
            c32183a.mo52824a("invalid_data", null);
            AppMethodBeat.m2505o(6384);
            return;
        }
        C22857k cWH = ((C24905d) c32183a.bOZ).cWH();
        if (cWH != null) {
            cWH.mo38437I(optJSONArray);
        }
        c32183a.mo52824a("", null);
        AppMethodBeat.m2505o(6384);
    }

    /* renamed from: a */
    public final void mo9617a(Context context, String str, C22841a c22841a) {
    }
}
