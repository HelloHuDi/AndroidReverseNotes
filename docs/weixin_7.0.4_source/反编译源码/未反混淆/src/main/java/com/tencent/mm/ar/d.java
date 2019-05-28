package com.tencent.mm.ar;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ao;
import com.tencent.mm.model.at;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bw;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.subapp.a;
import com.tencent.mm.pluginsdk.i;
import com.tencent.mm.pluginsdk.ui.applet.h;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;

public class d implements at {
    private static HashMap<Integer, com.tencent.mm.cd.h.d> eaA;
    private b fCQ;
    private c fCR;

    private static d agL() {
        d dVar;
        AppMethodBeat.i(16488);
        aw.ZE();
        a aVar = (a) bw.oJ("plugin.subapp");
        d dVar2 = aVar == null ? null : (d) aVar.abh(d.class.getName());
        if (dVar2 == null) {
            dVar2 = new d();
            aVar.b(d.class.getName(), dVar2);
            dVar = dVar2;
        } else {
            dVar = dVar2;
        }
        AppMethodBeat.o(16488);
        return dVar;
    }

    public static b agM() {
        AppMethodBeat.i(16489);
        g.RN().QU();
        if (agL().fCQ == null) {
            d agL = agL();
            aw.ZK();
            agL.fCQ = new b(c.Ru());
        }
        b bVar = agL().fCQ;
        AppMethodBeat.o(16489);
        return bVar;
    }

    public final void onAccountRelease() {
    }

    static {
        AppMethodBeat.i(16491);
        HashMap hashMap = new HashMap();
        eaA = hashMap;
        hashMap.put(Integer.valueOf("GETCONTACTINFO_TABLE".hashCode()), new com.tencent.mm.cd.h.d() {
            public final String[] Af() {
                return b.fnj;
            }
        });
        AppMethodBeat.o(16491);
    }

    public final HashMap<Integer, com.tencent.mm.cd.h.d> Jx() {
        return eaA;
    }

    public final void iy(int i) {
    }

    public final void bz(boolean z) {
        AppMethodBeat.i(16490);
        if (this.fCR == null) {
            this.fCR = new c();
        }
        ao.a.flu = this.fCR;
        ab.i("SubCoreGetContact", "summergetcontac onAccountPostReset setGetContact[%s]", this.fCR);
        g.a(com.tencent.mm.pluginsdk.g.class, new com.tencent.mm.pluginsdk.ui.applet.c());
        g.a(i.class, new h());
        AppMethodBeat.o(16490);
    }

    public final void bA(boolean z) {
    }
}
