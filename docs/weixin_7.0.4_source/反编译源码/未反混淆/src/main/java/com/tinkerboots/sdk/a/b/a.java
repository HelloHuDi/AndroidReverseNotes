package com.tinkerboots.sdk.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.BitUtils;

public class a {
    public final com.tinkerboots.sdk.a.c.a AUa;

    static class a {
        com.tinkerboots.sdk.a.c.a AUa;

        a() {
        }
    }

    private a(com.tinkerboots.sdk.a.c.a aVar) {
        this.AUa = aVar;
    }

    public static a dWl() {
        AppMethodBeat.i(BitUtils.BIT_TURN_ZERO_3);
        a aVar = new a();
        aVar.AUa = new com.tinkerboots.sdk.a.c.a();
        if (aVar.AUa == null) {
            RuntimeException runtimeException = new RuntimeException("You need init conditions property");
            AppMethodBeat.o(BitUtils.BIT_TURN_ZERO_3);
            throw runtimeException;
        }
        a aVar2 = new a(aVar.AUa);
        AppMethodBeat.o(BitUtils.BIT_TURN_ZERO_3);
        return aVar2;
    }

    public final com.tinkerboots.sdk.a.c.a iP(String str, String str2) {
        AppMethodBeat.i(65532);
        com.tinkerboots.sdk.a.c.a iQ = this.AUa.iQ(str, str2);
        AppMethodBeat.o(65532);
        return iQ;
    }
}
