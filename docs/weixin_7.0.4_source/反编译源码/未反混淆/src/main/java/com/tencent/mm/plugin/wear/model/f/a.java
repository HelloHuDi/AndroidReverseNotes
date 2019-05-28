package com.tencent.mm.plugin.wear.model.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wear.model.e.r;

public final class a extends c {
    public final String getName() {
        return "RequestLogTask";
    }

    /* Access modifiers changed, original: protected|final */
    public final void send() {
        AppMethodBeat.i(26442);
        com.tencent.mm.plugin.wear.model.a.cUn();
        r.b(20009, null, false);
        com.tencent.mm.plugin.wear.model.a.cUn();
        r.b(20017, null, false);
        AppMethodBeat.o(26442);
    }
}
