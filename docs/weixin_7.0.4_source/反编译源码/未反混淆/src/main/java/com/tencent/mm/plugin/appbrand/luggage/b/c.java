package com.tencent.mm.plugin.appbrand.luggage.b;

import com.tencent.luggage.sdk.customize.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.a.d;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.appcache.ax;
import com.tencent.mm.pluginsdk.g.a.a.i;
import com.tencent.mm.pluginsdk.g.a.c.q.a;
import com.tencent.mm.pluginsdk.g.a.c.s;
import com.tencent.mm.sdk.platformtools.bo;

public final class c implements b {
    public final <T> T E(Class<T> cls) {
        AppMethodBeat.i(132096);
        Object E = f.E(cls);
        AppMethodBeat.o(132096);
        return E;
    }

    public final ax xF() {
        AppMethodBeat.i(132097);
        ax xF = ((d) g.K(d.class)).xF();
        AppMethodBeat.o(132097);
        return xF;
    }

    public final com.tencent.mm.plugin.appbrand.appstorage.b xG() {
        AppMethodBeat.i(132098);
        com.tencent.mm.plugin.appbrand.appstorage.b xG = f.xG();
        AppMethodBeat.o(132098);
        return xG;
    }

    public final com.tencent.mm.plugin.appbrand.config.c xH() {
        AppMethodBeat.i(132099);
        com.tencent.mm.plugin.appbrand.config.c xH = f.xH();
        AppMethodBeat.o(132099);
        return xH;
    }

    public final void xI() {
        int i;
        AppMethodBeat.i(132100);
        com.tencent.mm.pluginsdk.g.a.a.b dif = com.tencent.mm.pluginsdk.g.a.a.b.c.veg;
        com.tencent.mm.pluginsdk.g.a.a.b.c.veg;
        s ajg = a.vfA.ajg(i.gN(38, 1));
        if (ajg == null) {
            i = 0;
        } else {
            i = bo.getInt(ajg.field_fileVersion, 0);
        }
        dif.f(38, 1, i, false);
        AppMethodBeat.o(132100);
    }
}
