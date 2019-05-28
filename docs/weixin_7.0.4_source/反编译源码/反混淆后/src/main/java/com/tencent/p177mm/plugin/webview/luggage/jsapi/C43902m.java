package com.tencent.p177mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.p146d.C37393a.C32183a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.webview.luggage.C24905d;
import com.tencent.p177mm.plugin.webview.luggage.jsapi.C22840bc.C22841a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import org.json.JSONArray;

/* renamed from: com.tencent.mm.plugin.webview.luggage.jsapi.m */
public class C43902m extends C46419bd<C24905d> {
    public final String name() {
        return "disableBounceScroll";
    }

    public final int biG() {
        return 0;
    }

    /* renamed from: b */
    public final void mo9618b(C32183a c32183a) {
        Object obj = null;
        AppMethodBeat.m2504i(6307);
        C4990ab.m7416i("MicroMsg.JsApiDisableBounceScroll", "invoke");
        JSONArray optJSONArray = c32183a.bPa.bOf.optJSONArray("place");
        if (optJSONArray == null) {
            C4990ab.m7416i("MicroMsg.JsApiDisableBounceScroll", "placeArray is null");
            c32183a.mo52824a("fail", null);
            AppMethodBeat.m2505o(6307);
            return;
        }
        Object obj2;
        int i = 0;
        while (true) {
            obj2 = obj;
            if (i >= optJSONArray.length()) {
                break;
            }
            if ("top".equalsIgnoreCase(optJSONArray.optString(i))) {
                obj = 1;
            } else {
                obj = obj2;
            }
            i++;
        }
        if (obj2 == null) {
            c32183a.mo52824a("", null);
            AppMethodBeat.m2505o(6307);
            return;
        }
        ((C24905d) c32183a.bOZ).cWJ();
        c32183a.mo52824a("", null);
        AppMethodBeat.m2505o(6307);
    }

    /* renamed from: a */
    public final void mo9617a(Context context, String str, C22841a c22841a) {
    }
}
