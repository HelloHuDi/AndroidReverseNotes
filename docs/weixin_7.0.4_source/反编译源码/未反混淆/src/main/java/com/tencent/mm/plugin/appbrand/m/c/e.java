package com.tencent.mm.plugin.appbrand.m.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.g;
import com.tencent.mm.aa.i;
import com.tencent.mm.plugin.appbrand.m.a.b;
import com.tencent.mm.plugin.appbrand.m.a.c;
import com.tencent.mm.sdk.platformtools.ab;

public final class e extends b {
    public static a iqg;

    public interface a {
        void X(int i, String str);
    }

    public final void a(i iVar, c cVar) {
        AppMethodBeat.i(102196);
        if (iqg == null) {
            ab.d("MicroMsg.NodeReportKV", "sDelegate null");
            AppMethodBeat.o(102196);
            return;
        }
        try {
            iqg.X(iVar.getInt("id"), iVar.optString("val"));
            AppMethodBeat.o(102196);
        } catch (g e) {
            ab.e("MicroMsg.NodeReportKV", "execute exception : %s", e);
            cVar.aIU();
            AppMethodBeat.o(102196);
        }
    }

    public final int aIT() {
        return 8;
    }
}
