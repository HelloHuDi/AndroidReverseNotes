package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;

public final class k extends j<com.tencent.mm.af.j> {
    public static final String[] fnj = new String[]{j.a(com.tencent.mm.af.j.ccO, "AppMessage")};

    static {
        AppMethodBeat.i(79328);
        AppMethodBeat.o(79328);
    }

    public k(e eVar) {
        super(eVar, com.tencent.mm.af.j.ccO, "AppMessage", null);
    }

    public final com.tencent.mm.af.j ma(long j) {
        AppMethodBeat.i(79327);
        c jVar = new com.tencent.mm.af.j();
        jVar.field_msgId = j;
        if (super.b(jVar, new String[0])) {
            AppMethodBeat.o(79327);
            return jVar;
        }
        AppMethodBeat.o(79327);
        return null;
    }
}
