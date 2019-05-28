package com.tencent.mm.plugin.appbrand.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;

public final class c {
    public HashMap<String, a> hez = new HashMap();

    public c() {
        AppMethodBeat.i(129824);
        AppMethodBeat.o(129824);
    }

    public final void a(a aVar) {
        AppMethodBeat.i(129825);
        if (aVar == null || bo.isNullOrNil(aVar.czD)) {
            ab.e("MicroMsg.AppbrandMediaCdnItemManager", "item is null or local id is null, ignore this add");
            AppMethodBeat.o(129825);
            return;
        }
        ab.i("MicroMsg.AppbrandMediaCdnItemManager", "add cdn item, local id : %s, file path : %s", aVar.czD, aVar.heo);
        this.hez.put(aVar.czD, aVar);
        AppMethodBeat.o(129825);
    }

    public final a yE(String str) {
        AppMethodBeat.i(129826);
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.AppbrandMediaCdnItemManager", "get by local id error, local id is null or nil");
            AppMethodBeat.o(129826);
            return null;
        }
        a aVar = (a) this.hez.get(str);
        AppMethodBeat.o(129826);
        return aVar;
    }
}
