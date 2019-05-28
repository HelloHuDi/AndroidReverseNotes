package com.tencent.mm.plugin.address.e;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d {
    public static void wG(String str) {
        AppMethodBeat.i(17013);
        if (VERSION.SDK_INT >= 11) {
            b bVar = new b();
            b.wG(str);
            AppMethodBeat.o(17013);
            return;
        }
        c cVar = new c();
        c.wG(str);
        AppMethodBeat.o(17013);
    }
}
