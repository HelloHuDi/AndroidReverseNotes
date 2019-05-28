package com.tencent.p177mm.plugin.game.luggage.p429b;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import com.tencent.luggage.p146d.C37393a.C32183a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.game.luggage.p432d.C12140e;
import com.tencent.p177mm.plugin.webview.luggage.jsapi.C22840bc.C22841a;
import com.tencent.p177mm.plugin.webview.luggage.jsapi.C46419bd;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.game.luggage.b.m */
public class C43181m extends C46419bd<C12140e> {
    public final String name() {
        return "openGameUrlWithExtraWebView";
    }

    public final int biG() {
        return 0;
    }

    /* renamed from: b */
    public final void mo9618b(final C32183a c32183a) {
        int i = 0;
        AppMethodBeat.m2504i(135883);
        C4990ab.m7416i("MicroMsg.JsApiOpenGameUrlWithExtraWebView", "invokeInOwn");
        final String optString = c32183a.bPa.bOf.optString("url");
        if (C5046bo.isNullOrNil(optString)) {
            C4990ab.m7412e("MicroMsg.JsApiOpenGameUrlWithExtraWebView", "url is null");
            c32183a.mo52824a("fail", null);
            AppMethodBeat.m2505o(135883);
            return;
        }
        C4990ab.m7417i("MicroMsg.JsApiOpenGameUrlWithExtraWebView", "url: %s", optString);
        String optString2 = c32183a.bPa.bOf.optString("statusBarColor");
        if (!C5046bo.isNullOrNil(optString2)) {
            try {
                i = Color.parseColor(optString2);
            } catch (IllegalArgumentException e) {
                C4990ab.m7412e("MicroMsg.JsApiOpenGameUrlWithExtraWebView", e.getMessage());
                c32183a.mo52824a("invalid_color", null);
                AppMethodBeat.m2505o(135883);
                return;
            }
        }
        optString2 = c32183a.bPa.bOf.optString("statusBarStyle");
        final Bundle bundle = new Bundle();
        bundle.putString("rawUrl", optString);
        bundle.putInt("customize_status_bar_color", i);
        bundle.putString("status_bar_style", optString2);
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(135882);
                ((C12140e) c32183a.bOZ).bPe.mo43477xi().mo60236h(optString, bundle);
                AppMethodBeat.m2505o(135882);
            }
        });
        c32183a.mo52824a("", null);
        AppMethodBeat.m2505o(135883);
    }

    /* renamed from: a */
    public final void mo9617a(Context context, String str, C22841a c22841a) {
    }
}
