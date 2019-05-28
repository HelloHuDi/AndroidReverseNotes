package com.tencent.mm.plugin.appbrand.dynamic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class d {
    private static volatile d hlw;
    Map<String, c> hlx = new ConcurrentHashMap();

    private d() {
        AppMethodBeat.i(10675);
        AppMethodBeat.o(10675);
    }

    public static d azy() {
        AppMethodBeat.i(10676);
        if (hlw == null) {
            synchronized (d.class) {
                try {
                    if (hlw == null) {
                        hlw = new d();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(10676);
                    }
                }
            }
        }
        d dVar = hlw;
        AppMethodBeat.o(10676);
        return dVar;
    }

    public final c zR(String str) {
        AppMethodBeat.i(10677);
        if (bo.isNullOrNil(str)) {
            ab.w("MicroMsg.DynamicPageViewIPCProxyManager", "get IPCProxy from manager failed, key is null or nil.");
            AppMethodBeat.o(10677);
            return null;
        }
        c cVar = (c) this.hlx.get(str);
        AppMethodBeat.o(10677);
        return cVar;
    }
}
