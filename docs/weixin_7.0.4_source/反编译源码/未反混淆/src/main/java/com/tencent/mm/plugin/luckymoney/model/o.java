package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;

public final class o extends j<n> {
    public static final String[] fnj = new String[]{j.a(n.ccO, "LuckyMoneyEnvelopeResource")};
    private e bSd;

    static {
        AppMethodBeat.i(42335);
        AppMethodBeat.o(42335);
    }

    public o(e eVar) {
        super(eVar, n.ccO, "LuckyMoneyEnvelopeResource", null);
        this.bSd = eVar;
    }
}
