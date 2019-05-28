package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.Map;

public final class ao extends an {
    /* Access modifiers changed, original: protected|final */
    public final Map<String, Object> a(d dVar) {
        AppMethodBeat.i(130434);
        Map a = super.a(dVar);
        a.put("clientVersion", Integer.valueOf(com.tencent.mm.protocal.d.vxo));
        a.put("x5Version", Integer.valueOf(com.tencent.xweb.x5.sdk.d.getTbsVersion(ah.getContext())));
        AppMethodBeat.o(130434);
        return a;
    }
}
