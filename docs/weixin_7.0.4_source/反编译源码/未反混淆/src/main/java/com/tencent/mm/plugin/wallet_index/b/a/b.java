package com.tencent.mm.plugin.wallet_index.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public final class b {
    public Map<String, c> tQQ = new HashMap();

    b() {
        AppMethodBeat.i(48169);
        AppMethodBeat.o(48169);
    }

    b(String str, c cVar) {
        AppMethodBeat.i(48170);
        this.tQQ.clear();
        this.tQQ.put(str, cVar);
        AppMethodBeat.o(48170);
    }
}
