package com.tencent.mm.pluginsdk.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ss;
import com.tencent.mm.sdk.b.a;

public final class e {
    public static ss ait(String str) {
        AppMethodBeat.i(79204);
        ss ssVar = new ss();
        ssVar.cOR.czE = 1;
        ssVar.cOR.cOS = str;
        a.xxA.m(ssVar);
        AppMethodBeat.o(79204);
        return ssVar;
    }

    public static void aiu(String str) {
        AppMethodBeat.i(79205);
        ss ssVar = new ss();
        ssVar.cOR.czE = 2;
        ssVar.cOR.cOS = str;
        a.xxA.m(ssVar);
        AppMethodBeat.o(79205);
    }
}
