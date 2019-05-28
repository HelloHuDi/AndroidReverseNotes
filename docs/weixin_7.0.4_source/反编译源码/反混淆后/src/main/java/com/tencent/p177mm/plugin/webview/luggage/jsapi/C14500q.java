package com.tencent.p177mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.p146d.C17821n;
import com.tencent.luggage.p146d.C37393a.C32183a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.p314q.C16674d;
import com.tencent.p177mm.plugin.webview.luggage.jsapi.C22840bc.C22841a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.webview.luggage.jsapi.q */
public class C14500q extends C22840bc<C17821n> {
    public final String name() {
        return C16674d.NAME;
    }

    public final int biG() {
        return 0;
    }

    /* renamed from: b */
    public final void mo9618b(C32183a c32183a) {
        AppMethodBeat.m2504i(6312);
        C4990ab.m7416i("MicroMsg.JsApiGetNetworkType", "invoke");
        if (C5023at.isConnected(((C17821n) c32183a.bOZ).mContext)) {
            C4990ab.m7416i("MicroMsg.JsApiGetNetworkType", "getNetworkType, type = ".concat(String.valueOf(C5023at.getNetType(((C17821n) c32183a.bOZ).mContext))));
            HashMap hashMap = new HashMap();
            if (C5023at.isWifi(((C17821n) c32183a.bOZ).mContext)) {
                C4990ab.m7416i("MicroMsg.JsApiGetNetworkType", "getNetworkType, wifi");
                c32183a.mo52824a("network_type:wifi", null);
                AppMethodBeat.m2505o(6312);
                return;
            }
            if (C5023at.is2G(((C17821n) c32183a.bOZ).mContext)) {
                C4990ab.m7416i("MicroMsg.JsApiGetNetworkType", "getNetworkType, 2g");
                hashMap.put("subtype", "2g");
            } else if (C5023at.is3G(((C17821n) c32183a.bOZ).mContext)) {
                C4990ab.m7416i("MicroMsg.JsApiGetNetworkType", "getNetworkType, 3g");
                hashMap.put("subtype", "3g");
            } else if (C5023at.is4G(((C17821n) c32183a.bOZ).mContext)) {
                C4990ab.m7416i("MicroMsg.JsApiGetNetworkType", "getNetworkType, 4g");
                hashMap.put("subtype", "4g");
            }
            c32183a.mo52825c("network_type:wwan", hashMap);
            AppMethodBeat.m2505o(6312);
            return;
        }
        C4990ab.m7416i("MicroMsg.JsApiGetNetworkType", "getNetworkType, not connected");
        c32183a.mo52824a("network_type:fail", null);
        AppMethodBeat.m2505o(6312);
    }

    /* renamed from: a */
    public final void mo9617a(Context context, String str, C22841a c22841a) {
    }
}
