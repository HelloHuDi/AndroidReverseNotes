package com.tencent.p177mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.graphics.Color;
import com.tencent.luggage.p146d.C37393a.C32183a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.p310k.C27011o;
import com.tencent.p177mm.plugin.webview.luggage.C24905d;
import com.tencent.p177mm.plugin.webview.luggage.jsapi.C22840bc.C22841a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.smtt.sdk.WebView;

/* renamed from: com.tencent.mm.plugin.webview.luggage.jsapi.at */
public class C40239at extends C46419bd<C24905d> {
    public final String name() {
        return C27011o.NAME;
    }

    public final int biG() {
        return 0;
    }

    /* renamed from: b */
    public final void mo9618b(C32183a c32183a) {
        int i;
        int i2 = 1;
        AppMethodBeat.m2504i(6374);
        C4990ab.m7416i("MicroMsg.JsApiSetNavigationBarColor", "invoke");
        int i3 = -1;
        try {
            i3 = Color.parseColor(c32183a.bPa.bOf.optString("color")) | WebView.NIGHT_MODE_COLOR;
            i = c32183a.bPa.bOf.optInt("actionCode") == i2 ? i2 : 0;
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.JsApiSetNavigationBarColor", e.getMessage());
            i = i2;
        }
        try {
            C5046bo.getFloat(c32183a.bPa.bOf.optString("alpha"), 1.0f);
        } catch (Exception e2) {
            C4990ab.m7412e("MicroMsg.JsApiSetNavigationBarColor", e2.getMessage());
        }
        if (i != 0) {
            ((C24905d) c32183a.bOZ).aBj();
        } else {
            ((C24905d) c32183a.bOZ).setStatusBarColor(i3);
        }
        c32183a.mo52824a("", null);
        AppMethodBeat.m2505o(6374);
    }

    /* renamed from: a */
    public final void mo9617a(Context context, String str, C22841a c22841a) {
    }
}
