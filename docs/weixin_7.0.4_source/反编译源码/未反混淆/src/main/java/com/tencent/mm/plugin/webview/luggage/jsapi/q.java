package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.d.a.a;
import com.tencent.luggage.d.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.q.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.at;
import java.util.HashMap;

public class q extends bc<n> {
    public final String name() {
        return d.NAME;
    }

    public final int biG() {
        return 0;
    }

    public final void b(a aVar) {
        AppMethodBeat.i(6312);
        ab.i("MicroMsg.JsApiGetNetworkType", "invoke");
        if (at.isConnected(((n) aVar.bOZ).mContext)) {
            ab.i("MicroMsg.JsApiGetNetworkType", "getNetworkType, type = ".concat(String.valueOf(at.getNetType(((n) aVar.bOZ).mContext))));
            HashMap hashMap = new HashMap();
            if (at.isWifi(((n) aVar.bOZ).mContext)) {
                ab.i("MicroMsg.JsApiGetNetworkType", "getNetworkType, wifi");
                aVar.a("network_type:wifi", null);
                AppMethodBeat.o(6312);
                return;
            }
            if (at.is2G(((n) aVar.bOZ).mContext)) {
                ab.i("MicroMsg.JsApiGetNetworkType", "getNetworkType, 2g");
                hashMap.put("subtype", "2g");
            } else if (at.is3G(((n) aVar.bOZ).mContext)) {
                ab.i("MicroMsg.JsApiGetNetworkType", "getNetworkType, 3g");
                hashMap.put("subtype", "3g");
            } else if (at.is4G(((n) aVar.bOZ).mContext)) {
                ab.i("MicroMsg.JsApiGetNetworkType", "getNetworkType, 4g");
                hashMap.put("subtype", "4g");
            }
            aVar.c("network_type:wwan", hashMap);
            AppMethodBeat.o(6312);
            return;
        }
        ab.i("MicroMsg.JsApiGetNetworkType", "getNetworkType, not connected");
        aVar.a("network_type:fail", null);
        AppMethodBeat.o(6312);
    }

    public final void a(Context context, String str, bc.a aVar) {
    }
}
