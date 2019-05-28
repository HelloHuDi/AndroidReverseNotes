package com.tencent.mm.plugin.appbrand.m.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.g;
import com.tencent.mm.aa.i;
import com.tencent.mm.plugin.appbrand.m.a.b;
import com.tencent.mm.plugin.appbrand.m.a.c;
import com.tencent.mm.sdk.platformtools.ab;

public final class d extends b {
    public static a iqf;

    public interface a {
        void M(int i, int i2, int i3);
    }

    public final int aIT() {
        return 3;
    }

    public final void a(i iVar, c cVar) {
        AppMethodBeat.i(102195);
        if (iqf == null) {
            ab.d("MicroMsg.NodeReportIDKey", "sDelegate null");
            AppMethodBeat.o(102195);
            return;
        }
        try {
            iqf.M(iVar.getInt("id"), iVar.getInt("key"), iVar.optInt("val", 1));
            AppMethodBeat.o(102195);
        } catch (g e) {
            ab.e("MicroMsg.NodeReportIDKey", "execute exception : %s", e);
            cVar.aIU();
            AppMethodBeat.o(102195);
        }
    }
}
