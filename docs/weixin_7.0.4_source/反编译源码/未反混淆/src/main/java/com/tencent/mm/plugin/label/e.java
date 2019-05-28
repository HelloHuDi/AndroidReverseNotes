package com.tencent.mm.plugin.label;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.b;
import com.tencent.mm.cd.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bw;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.label.a.a;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.ai;
import java.util.HashMap;

public class e implements at {
    private static HashMap<Integer, d> eaA;
    private ai nHt;
    private d nHu = new d();

    public e() {
        AppMethodBeat.i(22514);
        AppMethodBeat.o(22514);
    }

    static {
        AppMethodBeat.i(22519);
        HashMap hashMap = new HashMap();
        eaA = hashMap;
        hashMap.put(Integer.valueOf("CONTACT_LABEL_TABLE".hashCode()), new d() {
            public final String[] Af() {
                return ai.fnj;
            }
        });
        eaA.put(Integer.valueOf("CONTACT_LABEL_CACHE_TABLE".hashCode()), new d() {
            public final String[] Af() {
                return ah.fnj;
            }
        });
        AppMethodBeat.o(22519);
    }

    private static e bIY() {
        AppMethodBeat.i(22515);
        aw.ZE();
        e eVar = (e) bw.oJ("plugin.label");
        if (eVar == null) {
            synchronized (e.class) {
                if (eVar == null) {
                    try {
                        eVar = new e();
                        aw.ZE().a("plugin.label", eVar);
                    } catch (Throwable th) {
                        while (true) {
                            AppMethodBeat.o(22515);
                        }
                    }
                }
            }
        }
        AppMethodBeat.o(22515);
        return eVar;
    }

    public final HashMap<Integer, d> Jx() {
        return eaA;
    }

    public final void iy(int i) {
    }

    public final void bz(boolean z) {
        AppMethodBeat.i(22516);
        b bVar = new b();
        a.nHv = bVar;
        b.fHH = bVar;
        com.tencent.mm.sdk.b.a.xxA.c(this.nHu);
        AppMethodBeat.o(22516);
    }

    public final void bA(boolean z) {
    }

    public final void onAccountRelease() {
        AppMethodBeat.i(22517);
        a.nHv = null;
        com.tencent.mm.sdk.b.a.xxA.d(this.nHu);
        AppMethodBeat.o(22517);
    }

    public static ai bIZ() {
        AppMethodBeat.i(22518);
        g.RN().QU();
        if (bIY().nHt == null) {
            e bIY = bIY();
            aw.ZK();
            bIY.nHt = new ai(c.Ru());
        }
        ai aiVar = bIY().nHt;
        AppMethodBeat.o(22518);
        return aiVar;
    }
}
