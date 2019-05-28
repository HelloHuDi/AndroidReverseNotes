package com.tencent.mm.plugin.wear.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;

public final class q {
    public HashMap<Integer, a> tYL = new HashMap();

    public q() {
        AppMethodBeat.i(26426);
        AppMethodBeat.o(26426);
    }

    public final void a(a aVar) {
        AppMethodBeat.i(26427);
        for (Integer intValue : aVar.cUA()) {
            ab.d("MicroMsg.Wear.WearHttpServerLogic", "add funId %d %s", Integer.valueOf(intValue.intValue()), aVar);
            this.tYL.put(Integer.valueOf(r0), aVar);
        }
        AppMethodBeat.o(26427);
    }

    public final a HL(int i) {
        AppMethodBeat.i(26428);
        a aVar = (a) this.tYL.get(Integer.valueOf(i));
        AppMethodBeat.o(26428);
        return aVar;
    }
}
