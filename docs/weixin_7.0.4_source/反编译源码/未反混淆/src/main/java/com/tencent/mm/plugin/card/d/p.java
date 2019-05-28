package com.tencent.mm.plugin.card.d;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class p {
    public static void wG(String str) {
        AppMethodBeat.i(88942);
        if (VERSION.SDK_INT >= 11) {
            n nVar = new n();
            n.wG(str);
            AppMethodBeat.o(88942);
            return;
        }
        o oVar = new o();
        o.wG(str);
        AppMethodBeat.o(88942);
    }
}
