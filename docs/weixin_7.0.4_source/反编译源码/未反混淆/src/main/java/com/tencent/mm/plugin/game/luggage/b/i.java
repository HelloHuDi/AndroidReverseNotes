package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.luggage.b;
import com.tencent.mm.plugin.game.luggage.d.e;
import com.tencent.mm.plugin.webview.luggage.jsapi.bc;
import com.tencent.mm.plugin.webview.luggage.jsapi.bd;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.xweb.c;
import java.util.HashMap;

public class i extends bd<e> {
    public final String name() {
        return "getWePkgAuthResult";
    }

    public final int biG() {
        return 0;
    }

    public final void b(a aVar) {
        AppMethodBeat.i(135876);
        ab.i("MicroMsg.JsApiGetWePkgAuthResult", "invoke");
        if (((e) aVar.bOZ).cWK()) {
            ab.i("MicroMsg.JsApiGetWePkgAuthResult", "gettingA8Key");
            aVar.a("auth_result_not_return", null);
            AppMethodBeat.o(135876);
            return;
        }
        int i;
        String str = ((e) aVar.bOZ).mTH;
        boolean z = ((e) aVar.bOZ).mTI;
        if (bo.isNullOrNil(str) && b.bDp()) {
            str = b.mTH;
            if (b.mHeaders == null) {
                z = false;
            } else {
                String str2 = "." + bo.anB(b.mTH);
                String anB = bo.anB(b.mTH);
                c.jx(ah.getContext());
                com.tencent.xweb.b dTR = com.tencent.xweb.b.dTR();
                for (String str3 : b.mHeaders.keySet()) {
                    dTR.setCookie(anB, str3 + "=" + ((String) b.mHeaders.get(str3)));
                }
                dTR.setCookie(anB, "httponly");
                dTR.setCookie(str2, "httponly");
                c.dTT();
                c.sync();
                ab.i("MicroMsg.LuggageGameUinKeyHolder", "setCookie, cookies:%s", dTR.getCookie(anB));
                z = true;
            }
            i = 1;
        } else {
            i = 0;
        }
        if (bo.isNullOrNil(str)) {
            aVar.a("full_url_empty", null);
            AppMethodBeat.o(135876);
            return;
        }
        HashMap hashMap = new HashMap();
        if (z) {
            hashMap.put("set_cookie", Integer.valueOf(1));
        } else {
            hashMap.put("set_cookie", Integer.valueOf(0));
        }
        if (i != 0) {
            hashMap.put("used_cache_uinkey", Integer.valueOf(1));
        }
        hashMap.put("full_url", str);
        aVar.c("", hashMap);
        AppMethodBeat.o(135876);
    }

    public final void a(Context context, String str, bc.a aVar) {
    }
}
