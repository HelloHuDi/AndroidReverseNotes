package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public final class cb {
    private String a;
    private Map<String, cc> b = new HashMap();

    public cb(String str) {
        AppMethodBeat.i(98614);
        this.a = str;
        AppMethodBeat.o(98614);
    }

    public final String a() {
        return this.a;
    }

    public final void a(cc ccVar) {
        AppMethodBeat.i(98615);
        this.b.put(ccVar.a, ccVar);
        AppMethodBeat.o(98615);
    }

    public final Map<String, cc> b() {
        return this.b;
    }
}
