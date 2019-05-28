package com.tencent.mm.z.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.z.b.b;
import java.util.HashMap;
import java.util.Map;

public final class d {
    final Map<String, b> eIp = new HashMap();

    public d() {
        AppMethodBeat.i(115306);
        AppMethodBeat.o(115306);
    }

    public final void a(b bVar) {
        AppMethodBeat.i(115307);
        this.eIp.put(bVar.name, bVar);
        AppMethodBeat.o(115307);
    }
}
