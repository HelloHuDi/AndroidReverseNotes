package com.tencent.mm.plugin.honey_pay.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;

public final class b extends j<a> {
    public static final String[] fnj = new String[]{j.a(a.ccO, "HoneyPayMsgRecord")};
    private static final String[] gmr = new String[]{"*", "rowid"};
    private e bSd;

    static {
        AppMethodBeat.i(41751);
        AppMethodBeat.o(41751);
    }

    public b(e eVar) {
        super(eVar, a.ccO, "HoneyPayMsgRecord", null);
        this.bSd = eVar;
    }
}
