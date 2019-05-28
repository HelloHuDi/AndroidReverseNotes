package com.tencent.mm.plugin.appbrand.jsapi.p;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ah;
import com.tencent.mm.plugin.appbrand.s.t.a;
import java.util.HashMap;

final class g extends ah {
    static final int CTRL_INDEX = 473;
    static final String NAME = "onDeviceOrientationChange";

    g() {
    }

    /* Access modifiers changed, original: final */
    public final void a(a aVar) {
        AppMethodBeat.i(126385);
        String replace = aVar.name().replace("_", "");
        HashMap hashMap = new HashMap(2);
        hashMap.put("errMsg", "ok");
        hashMap.put("value", replace);
        t(hashMap).aCj();
        AppMethodBeat.o(126385);
    }
}
