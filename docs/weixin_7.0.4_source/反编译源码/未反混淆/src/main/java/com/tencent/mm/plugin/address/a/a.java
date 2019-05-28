package com.tencent.mm.plugin.address.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bw;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.address.model.j;
import com.tencent.mm.plugin.address.model.k;
import com.tencent.mm.plugin.address.model.l;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;

public final class a implements at {
    private l gIB = null;
    private com.tencent.mm.plugin.address.b.a.a gIC = null;
    private j gID = new j();
    private k gIE = new k();

    public a() {
        AppMethodBeat.i(16713);
        AppMethodBeat.o(16713);
    }

    public static a arQ() {
        AppMethodBeat.i(16714);
        aw.ZE();
        a aVar = (a) bw.oJ("plugin.address");
        if (aVar == null) {
            ab.w("MicroMsg.SubCoreAddress", "not found in MMCore, new one");
            aVar = new a();
            aw.ZE().a("plugin.address", aVar);
        }
        AppMethodBeat.o(16714);
        return aVar;
    }

    public static com.tencent.mm.plugin.address.b.a.a arR() {
        AppMethodBeat.i(16715);
        g.RN().QU();
        if (arQ().gIC == null) {
            arQ().gIC = new com.tencent.mm.plugin.address.b.a.a();
        }
        com.tencent.mm.plugin.address.b.a.a aVar = arQ().gIC;
        AppMethodBeat.o(16715);
        return aVar;
    }

    public static l arS() {
        AppMethodBeat.i(16716);
        g.RN().QU();
        if (arQ().gIB == null) {
            arQ().gIB = new l();
        }
        l lVar = arQ().gIB;
        AppMethodBeat.o(16716);
        return lVar;
    }

    public final HashMap<Integer, d> Jx() {
        return null;
    }

    public final void iy(int i) {
    }

    public final void bA(boolean z) {
    }

    public final void bz(boolean z) {
        AppMethodBeat.i(16717);
        com.tencent.mm.sdk.b.a.xxA.c(this.gID);
        com.tencent.mm.sdk.b.a.xxA.c(this.gIE);
        l arS = arS();
        aw.ZK();
        arS.path = c.getAccPath() + "addrmgr";
        AppMethodBeat.o(16717);
    }

    public final void onAccountRelease() {
        AppMethodBeat.i(16718);
        com.tencent.mm.sdk.b.a.xxA.d(this.gID);
        com.tencent.mm.sdk.b.a.xxA.d(this.gIE);
        AppMethodBeat.o(16718);
    }
}
