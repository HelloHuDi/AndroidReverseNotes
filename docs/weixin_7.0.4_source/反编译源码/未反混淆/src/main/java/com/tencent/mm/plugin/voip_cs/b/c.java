package com.tencent.mm.plugin.voip_cs.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.h.d;
import com.tencent.mm.g.a.bj;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.voip_cs.b.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;

public class c implements at {
    private static c tcF = null;
    private a tcG = new a();
    private e tcH = new e();
    private d tcI = new d();
    private com.tencent.mm.plugin.voip_cs.a.a tcJ = new com.tencent.mm.plugin.voip_cs.a.a();
    private com.tencent.mm.sdk.b.c tcK = new com.tencent.mm.sdk.b.c<bj>() {
        {
            AppMethodBeat.i(135288);
            this.xxI = bj.class.getName().hashCode();
            AppMethodBeat.o(135288);
        }

        public final /* synthetic */ boolean a(b bVar) {
            boolean z = true;
            AppMethodBeat.i(135289);
            bj bjVar = (bj) bVar;
            if (bjVar instanceof bj) {
                bj.a aVar = bjVar.cuD;
                if (!(c.cMf().tdM == 1 || c.cMf().tdM == 2)) {
                    z = false;
                }
                aVar.aFV = z;
            }
            AppMethodBeat.o(135289);
            return false;
        }
    };

    public c() {
        AppMethodBeat.i(135290);
        AppMethodBeat.o(135290);
    }

    private static c cMd() {
        AppMethodBeat.i(135291);
        c cVar = (c) q.Y(c.class);
        AppMethodBeat.o(135291);
        return cVar;
    }

    public static a cMe() {
        AppMethodBeat.i(135292);
        a aVar = cMd().tcG;
        AppMethodBeat.o(135292);
        return aVar;
    }

    public static e cMf() {
        AppMethodBeat.i(135293);
        g.RN().QU();
        if (cMd().tcH == null) {
            cMd().tcH = new e();
        }
        e eVar = cMd().tcH;
        AppMethodBeat.o(135293);
        return eVar;
    }

    public static d cMg() {
        AppMethodBeat.i(135294);
        d dVar = cMd().tcI;
        AppMethodBeat.o(135294);
        return dVar;
    }

    public final HashMap<Integer, d> Jx() {
        return null;
    }

    public final void iy(int i) {
    }

    public final void bz(boolean z) {
        AppMethodBeat.i(135295);
        ab.d("MicroMsg.SubCoreVoipCS", "now account reset!");
        com.tencent.mm.sdk.b.a.xxA.c(this.tcJ);
        com.tencent.mm.sdk.b.a.xxA.c(this.tcK);
        AppMethodBeat.o(135295);
    }

    public final void bA(boolean z) {
    }

    public final void onAccountRelease() {
        AppMethodBeat.i(135296);
        com.tencent.mm.sdk.b.a.xxA.d(this.tcJ);
        com.tencent.mm.sdk.b.a.xxA.d(this.tcK);
        AppMethodBeat.o(135296);
    }
}
