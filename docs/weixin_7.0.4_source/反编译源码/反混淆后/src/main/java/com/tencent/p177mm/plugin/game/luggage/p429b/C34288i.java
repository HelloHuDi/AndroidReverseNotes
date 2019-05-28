package com.tencent.p177mm.plugin.game.luggage.p429b;

import android.content.Context;
import com.tencent.luggage.p146d.C37393a.C32183a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.game.luggage.C28211b;
import com.tencent.p177mm.plugin.game.luggage.p432d.C12140e;
import com.tencent.p177mm.plugin.webview.luggage.jsapi.C22840bc.C22841a;
import com.tencent.p177mm.plugin.webview.luggage.jsapi.C46419bd;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.xweb.C24526c;
import com.tencent.xweb.C44576b;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.game.luggage.b.i */
public class C34288i extends C46419bd<C12140e> {
    public final String name() {
        return "getWePkgAuthResult";
    }

    public final int biG() {
        return 0;
    }

    /* renamed from: b */
    public final void mo9618b(C32183a c32183a) {
        AppMethodBeat.m2504i(135876);
        C4990ab.m7416i("MicroMsg.JsApiGetWePkgAuthResult", "invoke");
        if (((C12140e) c32183a.bOZ).cWK()) {
            C4990ab.m7416i("MicroMsg.JsApiGetWePkgAuthResult", "gettingA8Key");
            c32183a.mo52824a("auth_result_not_return", null);
            AppMethodBeat.m2505o(135876);
            return;
        }
        int i;
        String str = ((C12140e) c32183a.bOZ).mTH;
        boolean z = ((C12140e) c32183a.bOZ).mTI;
        if (C5046bo.isNullOrNil(str) && C28211b.bDp()) {
            str = C28211b.mTH;
            if (C28211b.mHeaders == null) {
                z = false;
            } else {
                String str2 = "." + C5046bo.anB(C28211b.mTH);
                String anB = C5046bo.anB(C28211b.mTH);
                C24526c.m38159jx(C4996ah.getContext());
                C44576b dTR = C44576b.dTR();
                for (String str3 : C28211b.mHeaders.keySet()) {
                    dTR.setCookie(anB, str3 + "=" + ((String) C28211b.mHeaders.get(str3)));
                }
                dTR.setCookie(anB, "httponly");
                dTR.setCookie(str2, "httponly");
                C24526c.dTT();
                C24526c.sync();
                C4990ab.m7417i("MicroMsg.LuggageGameUinKeyHolder", "setCookie, cookies:%s", dTR.getCookie(anB));
                z = true;
            }
            i = 1;
        } else {
            i = 0;
        }
        if (C5046bo.isNullOrNil(str)) {
            c32183a.mo52824a("full_url_empty", null);
            AppMethodBeat.m2505o(135876);
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
        c32183a.mo52825c("", hashMap);
        AppMethodBeat.m2505o(135876);
    }

    /* renamed from: a */
    public final void mo9617a(Context context, String str, C22841a c22841a) {
    }
}
