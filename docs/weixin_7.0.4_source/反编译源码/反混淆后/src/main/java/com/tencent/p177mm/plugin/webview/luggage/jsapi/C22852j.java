package com.tencent.p177mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.p146d.C37393a.C32183a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.webview.luggage.C24905d;
import com.tencent.p177mm.plugin.webview.luggage.jsapi.C22840bc.C22841a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.webview.luggage.jsapi.j */
public class C22852j extends C46419bd<C24905d> {
    public final String name() {
        return "clearBounceBackground";
    }

    public final int biG() {
        return 0;
    }

    /* renamed from: b */
    public final void mo9618b(C32183a c32183a) {
        AppMethodBeat.m2504i(6304);
        C4990ab.m7416i("MicroMsg.JsApiClearBounceBackground", "invokeInOwn");
        ((C24905d) c32183a.bOZ).cWI();
        c32183a.mo52824a("", null);
        AppMethodBeat.m2505o(6304);
    }

    /* renamed from: a */
    public final void mo9617a(Context context, String str, C22841a c22841a) {
    }
}
