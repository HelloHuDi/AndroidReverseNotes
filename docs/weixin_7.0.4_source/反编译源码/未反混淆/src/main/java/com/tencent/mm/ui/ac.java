package com.tencent.mm.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.tf;
import com.tencent.mm.sdk.b.a;

public final class ac {
    public static void bL(int i, String str) {
        AppMethodBeat.i(106131);
        if (a.xxA != null) {
            tf tfVar = new tf();
            tfVar.cPv.className = str;
            tfVar.cPv.cPw = i;
            a.xxA.m(tfVar);
        }
        AppMethodBeat.o(106131);
    }
}
