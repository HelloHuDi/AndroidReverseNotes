package com.tencent.mm.z.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.z.b.e;
import java.util.HashMap;
import java.util.Map;

public final class g {
    private final Map<String, e> eIx = new HashMap();

    public g() {
        AppMethodBeat.i(115319);
        AppMethodBeat.o(115319);
    }

    public final void a(e eVar) {
        AppMethodBeat.i(115320);
        this.eIx.put(eVar.getName(), eVar);
        AppMethodBeat.o(115320);
    }

    public final e lq(String str) {
        AppMethodBeat.i(115321);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(115321);
            return null;
        }
        e eVar = (e) this.eIx.get(str);
        AppMethodBeat.o(115321);
        return eVar;
    }
}
