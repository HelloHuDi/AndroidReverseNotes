package com.tencent.p177mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.p146d.C37393a.C32183a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.webview.luggage.C24905d;
import com.tencent.p177mm.plugin.webview.luggage.jsapi.C22840bc.C22841a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.webview.luggage.jsapi.aq */
public class C35600aq extends C46419bd<C24905d> {
    public final String name() {
        return "setBounceBackground";
    }

    public final int biG() {
        return 0;
    }

    /* renamed from: b */
    public final void mo9618b(C32183a c32183a) {
        AppMethodBeat.m2504i(6371);
        C4990ab.m7416i("MicroMsg.JsApiSetBounceBackground", "invokeInOwn");
        String optString = c32183a.bPa.bOf.optString("backgroundColor");
        if (C5046bo.isNullOrNil(optString)) {
            c32183a.mo52824a("invalid_data", null);
            AppMethodBeat.m2505o(6371);
            return;
        }
        ((C24905d) c32183a.bOZ).aec(optString);
        c32183a.mo52824a("", null);
        AppMethodBeat.m2505o(6371);
    }

    /* renamed from: a */
    public final void mo9617a(Context context, String str, C22841a c22841a) {
    }
}
