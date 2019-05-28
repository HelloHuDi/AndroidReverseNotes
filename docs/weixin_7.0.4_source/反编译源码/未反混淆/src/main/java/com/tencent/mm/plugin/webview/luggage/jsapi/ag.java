package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;

public class ag extends bd<d> {
    public final String name() {
        return "openUrlWithExtraWebview";
    }

    public final int biG() {
        return 0;
    }

    public final void b(final a aVar) {
        AppMethodBeat.i(6342);
        ab.i("MicroMsg.JsApiOpenUrlWithExtraWebview", "invokeInOwn");
        final String optString = aVar.bPa.bOf.optString("url");
        ab.i("MicroMsg.JsApiOpenUrlWithExtraWebview", "url: %s", optString);
        if (bo.isNullOrNil(optString)) {
            aVar.a("fail", null);
            AppMethodBeat.o(6342);
            return;
        }
        Uri parse = Uri.parse(optString);
        if (parse.getHost() == null || parse.getHost().equals("game.weixin.qq.com")) {
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(6341);
                    Bundle bundle = new Bundle();
                    bundle.putString("rawUrl", optString);
                    ((d) aVar.bOZ).bPe.xi().h(optString, bundle);
                    AppMethodBeat.o(6341);
                }
            });
            aVar.a("", null);
            AppMethodBeat.o(6342);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("rawUrl", optString);
        com.tencent.mm.bp.d.b(((d) aVar.bOZ).mContext, "webview", ".ui.tools.WebViewUI", intent);
        aVar.a("", null);
        AppMethodBeat.o(6342);
    }

    public final void a(Context context, String str, bc.a aVar) {
    }
}
