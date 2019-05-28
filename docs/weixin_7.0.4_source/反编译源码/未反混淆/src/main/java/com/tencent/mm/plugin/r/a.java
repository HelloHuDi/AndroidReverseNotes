package com.tencent.mm.plugin.r;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ax.b;
import com.tencent.mm.ax.e;
import com.tencent.mm.cd.h.d;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bn;
import java.util.HashMap;

public final class a extends q implements com.tencent.mm.kernel.api.bucket.a, c {
    private static HashMap<Integer, d> eaA;
    private static a oSU;
    private com.tencent.mm.ax.d oSV = null;
    private bn oSW = null;
    private com.tencent.mm.ax.c oSX = null;
    private e oSY = new e();
    private final f oSZ = new f() {
        public final void onSceneEnd(int i, int i2, String str, m mVar) {
        }
    };

    private a() {
        super(com.tencent.mm.ax.f.class);
        AppMethodBeat.i(79106);
        AppMethodBeat.o(79106);
    }

    public static synchronized a bVs() {
        a aVar;
        synchronized (a.class) {
            AppMethodBeat.i(79107);
            if (oSU == null) {
                oSU = new a();
            }
            aVar = oSU;
            AppMethodBeat.o(79107);
        }
        return aVar;
    }

    static {
        AppMethodBeat.i(79113);
        HashMap hashMap = new HashMap();
        eaA = hashMap;
        hashMap.put(Integer.valueOf("NEWTIPS_TABLE".hashCode()), new d() {
            public final String[] Af() {
                return bn.fnj;
            }
        });
        AppMethodBeat.o(79113);
    }

    public final void onAccountInitialized(com.tencent.mm.kernel.e.c cVar) {
        AppMethodBeat.i(79108);
        super.onAccountInitialized(cVar);
        ((p) g.M(p.class)).getSysCmdMsgExtension().a("newtips", this.oSY);
        g.Rg().a(597, this.oSZ);
        bVt();
        com.tencent.mm.ax.d.b(b.fKD, b.fKC, "", b.fKK);
        ab.i("MicroMsg.NewTipsManager", "dancy register dynamic newtips, tipsId:%s, path:%s", Integer.valueOf(r0), r1);
        AppMethodBeat.o(79108);
    }

    public final void onAccountRelease() {
        AppMethodBeat.i(79109);
        super.onAccountRelease();
        ((p) g.M(p.class)).getSysCmdMsgExtension().b("newtips", this.oSY);
        g.Rg().b(597, this.oSZ);
        AppMethodBeat.o(79109);
    }

    public static com.tencent.mm.ax.d bVt() {
        AppMethodBeat.i(79110);
        g.RN().QU();
        if (bVs().oSV == null) {
            bVs().oSV = new com.tencent.mm.ax.d();
        }
        com.tencent.mm.ax.d dVar = bVs().oSV;
        AppMethodBeat.o(79110);
        return dVar;
    }

    public static bn bVu() {
        AppMethodBeat.i(79111);
        g.RN().QU();
        if (bVs().oSW == null) {
            a bVs = bVs();
            g.RQ();
            bVs.oSW = new bn(g.RP().eJN);
        }
        bn bnVar = bVs().oSW;
        AppMethodBeat.o(79111);
        return bnVar;
    }

    public static com.tencent.mm.ax.c bVv() {
        AppMethodBeat.i(79112);
        g.RN().QU();
        if (bVs().oSX == null) {
            bVs().oSX = new com.tencent.mm.ax.c();
        }
        com.tencent.mm.ax.c cVar = bVs().oSX;
        AppMethodBeat.o(79112);
        return cVar;
    }

    public final HashMap<Integer, d> collectDatabaseFactory() {
        return eaA;
    }
}
