package com.tencent.p177mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.luggage.p146d.C37393a.C32183a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.webview.luggage.C24905d;
import com.tencent.p177mm.plugin.webview.luggage.jsapi.C22840bc.C22841a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.webview.luggage.jsapi.ag */
public class C22834ag extends C46419bd<C24905d> {
    public final String name() {
        return "openUrlWithExtraWebview";
    }

    public final int biG() {
        return 0;
    }

    /* renamed from: b */
    public final void mo9618b(final C32183a c32183a) {
        AppMethodBeat.m2504i(6342);
        C4990ab.m7416i("MicroMsg.JsApiOpenUrlWithExtraWebview", "invokeInOwn");
        final String optString = c32183a.bPa.bOf.optString("url");
        C4990ab.m7417i("MicroMsg.JsApiOpenUrlWithExtraWebview", "url: %s", optString);
        if (C5046bo.isNullOrNil(optString)) {
            c32183a.mo52824a("fail", null);
            AppMethodBeat.m2505o(6342);
            return;
        }
        Uri parse = Uri.parse(optString);
        if (parse.getHost() == null || parse.getHost().equals("game.weixin.qq.com")) {
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(6341);
                    Bundle bundle = new Bundle();
                    bundle.putString("rawUrl", optString);
                    ((C24905d) c32183a.bOZ).bPe.mo43477xi().mo60236h(optString, bundle);
                    AppMethodBeat.m2505o(6341);
                }
            });
            c32183a.mo52824a("", null);
            AppMethodBeat.m2505o(6342);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("rawUrl", optString);
        C25985d.m41467b(((C24905d) c32183a.bOZ).mContext, "webview", ".ui.tools.WebViewUI", intent);
        c32183a.mo52824a("", null);
        AppMethodBeat.m2505o(6342);
    }

    /* renamed from: a */
    public final void mo9617a(Context context, String str, C22841a c22841a) {
    }
}
