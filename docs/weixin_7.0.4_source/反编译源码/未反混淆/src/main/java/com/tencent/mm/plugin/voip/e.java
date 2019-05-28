package com.tencent.mm.plugin.voip;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.uh;
import com.tencent.mm.r.a;

public final class e {
    public static boolean bI(Context context) {
        AppMethodBeat.i(139167);
        boolean bI = a.bI(context);
        AppMethodBeat.o(139167);
        return bI;
    }

    public static boolean bJ(Context context) {
        AppMethodBeat.i(139168);
        boolean bJ = a.bJ(context);
        AppMethodBeat.o(139168);
        return bJ;
    }

    public static boolean cIm() {
        AppMethodBeat.i(70365);
        uh uhVar = new uh();
        com.tencent.mm.sdk.b.a.xxA.m(uhVar);
        boolean z = uhVar.cQt.cQw;
        AppMethodBeat.o(70365);
        return z;
    }
}
