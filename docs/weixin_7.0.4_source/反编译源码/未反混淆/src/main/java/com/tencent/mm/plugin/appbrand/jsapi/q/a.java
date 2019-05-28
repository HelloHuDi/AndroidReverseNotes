package com.tencent.mm.plugin.appbrand.jsapi.q;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.HashMap;

public final class a extends p {
    private static final int CTRL_INDEX = 153;
    private static final String NAME = "onNetworkStatusChange";
    private static a hXw;

    public static synchronized void k(c cVar) {
        synchronized (a.class) {
            AppMethodBeat.i(86976);
            HashMap hashMap = new HashMap();
            com.tencent.mm.plugin.appbrand.jsapi.q.d.a cK = d.cK(ah.getContext());
            hashMap.put("isConnected", Boolean.valueOf(cK != com.tencent.mm.plugin.appbrand.jsapi.q.d.a.None));
            hashMap.put("networkType", cK.value);
            if (hXw == null) {
                hXw = new a();
            }
            hXw.i(cVar).t(hashMap).aCj();
            AppMethodBeat.o(86976);
        }
    }
}
