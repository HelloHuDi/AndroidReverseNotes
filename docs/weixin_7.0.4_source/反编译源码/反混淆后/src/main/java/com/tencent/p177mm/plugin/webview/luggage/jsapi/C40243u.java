package com.tencent.p177mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.p146d.C37393a.C32183a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.webview.luggage.C22857k;
import com.tencent.p177mm.plugin.webview.luggage.C24905d;
import com.tencent.p177mm.plugin.webview.luggage.jsapi.C22840bc.C22841a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.webview.luggage.jsapi.u */
public class C40243u extends C46419bd<C24905d> {
    public final String name() {
        return "hideOptionMenu";
    }

    public final int biG() {
        return 0;
    }

    /* renamed from: b */
    public final void mo9618b(C32183a c32183a) {
        AppMethodBeat.m2504i(6316);
        C4990ab.m7416i("MicroMsg.JsApiHideOptionMenu", "invoke");
        C22857k cWH = ((C24905d) c32183a.bOZ).cWH();
        if (cWH == null) {
            C4990ab.m7412e("MicroMsg.JsApiHideOptionMenu", "actionBar is null");
            c32183a.mo52824a("fail", null);
            AppMethodBeat.m2505o(6316);
            return;
        }
        cWH.cXc();
        c32183a.mo52824a("", null);
        AppMethodBeat.m2505o(6316);
    }

    /* renamed from: a */
    public final void mo9617a(Context context, String str, C22841a c22841a) {
    }
}
