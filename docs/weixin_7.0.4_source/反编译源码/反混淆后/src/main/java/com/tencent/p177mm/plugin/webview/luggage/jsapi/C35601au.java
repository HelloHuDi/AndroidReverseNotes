package com.tencent.p177mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.p146d.C37393a.C32183a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.plugin.webview.luggage.C24905d;
import com.tencent.p177mm.plugin.webview.luggage.jsapi.C22840bc.C22841a;
import com.tencent.p177mm.plugin.webview.p580ui.tools.C29916g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.webview.luggage.jsapi.au */
public class C35601au extends C46419bd<C24905d> {
    public final String name() {
        return "setPageTitle";
    }

    public final int biG() {
        return 0;
    }

    /* renamed from: b */
    public final void mo9618b(C32183a c32183a) {
        AppMethodBeat.m2504i(6375);
        C4990ab.m7416i("MicroMsg.JsApiSetPageTitle", "invokeInOwn");
        String optString = c32183a.bPa.bOf.optString("title");
        if (C5046bo.isNullOrNil(c32183a.bPa.bOf.optString("color"))) {
            ((C24905d) c32183a.bOZ).mo41795cl(optString, 0);
        } else {
            ((C24905d) c32183a.bOZ).mo41795cl(optString, C29916g.m47394bx(c32183a.bPa.bOf.optString("color"), ((C24905d) c32183a.bOZ).mContext.getResources().getColor(C25738R.color.f11696du)));
        }
        c32183a.mo52824a("", null);
        AppMethodBeat.m2505o(6375);
    }

    /* renamed from: a */
    public final void mo9617a(Context context, String str, C22841a c22841a) {
    }
}
