package com.tencent.mm.plugin.sns.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;

public final class d extends j<c> {
    public static final String[] fnj = new String[]{j.a(c.ccO, "CanvasInfo")};

    static {
        AppMethodBeat.i(36919);
        AppMethodBeat.o(36919);
    }

    public d(e eVar) {
        this(eVar, c.ccO, "CanvasInfo");
    }

    private d(e eVar, a aVar, String str) {
        super(eVar, aVar, str, null);
    }

    public final void a(c cVar) {
        AppMethodBeat.i(36918);
        if (cVar == null) {
            AppMethodBeat.o(36918);
            return;
        }
        cVar.field_createTime = System.currentTimeMillis();
        if (!b((c) cVar)) {
            c(cVar, new String[0]);
        }
        AppMethodBeat.o(36918);
    }
}
