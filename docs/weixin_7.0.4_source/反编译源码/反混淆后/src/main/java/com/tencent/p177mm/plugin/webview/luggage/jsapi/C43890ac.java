package com.tencent.p177mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.p146d.C17821n;
import com.tencent.luggage.p146d.C37393a.C32183a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.webview.luggage.jsapi.C22840bc.C22841a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.webview.luggage.jsapi.ac */
public class C43890ac extends C22840bc<C17821n> {
    public final String name() {
        return "log";
    }

    public final int biG() {
        return 0;
    }

    /* renamed from: a */
    public final void mo9617a(Context context, String str, C22841a c22841a) {
    }

    /* renamed from: b */
    public final void mo9618b(C32183a c32183a) {
        AppMethodBeat.m2504i(6331);
        C4990ab.m7416i("MicroMsg.JsApiLog", "jslog : " + c32183a.bPa.bOf.optString("msg"));
        AppMethodBeat.m2505o(6331);
    }
}
