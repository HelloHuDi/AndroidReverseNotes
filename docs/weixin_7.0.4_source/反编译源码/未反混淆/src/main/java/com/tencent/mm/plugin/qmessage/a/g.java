package com.tencent.mm.plugin.qmessage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e;
import com.tencent.mm.cd.h.d;
import com.tencent.mm.model.at;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.bw;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.qmessage.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.bi;
import java.util.HashMap;

public final class g implements at {
    private static HashMap<Integer, d> eaA;
    private e psR;
    private f psS = new f();
    private a psT = new a();
    private b psU = new b();

    public g() {
        AppMethodBeat.i(24087);
        AppMethodBeat.o(24087);
    }

    private static g cbZ() {
        AppMethodBeat.i(24088);
        aw.ZE();
        g gVar = (g) bw.oJ("plugin.qmessage");
        if (gVar == null) {
            gVar = new g();
            aw.ZE().a("plugin.qmessage", gVar);
        }
        AppMethodBeat.o(24088);
        return gVar;
    }

    public static e cca() {
        AppMethodBeat.i(24089);
        com.tencent.mm.kernel.g.RN().QU();
        if (cbZ().psR == null) {
            g cbZ = cbZ();
            aw.ZK();
            cbZ.psR = new e(c.Ru());
        }
        e eVar = cbZ().psR;
        AppMethodBeat.o(24089);
        return eVar;
    }

    public final void onAccountRelease() {
        AppMethodBeat.i(24090);
        e.d.b(Integer.valueOf(36), this.psS);
        e.d.b(Integer.valueOf(39), this.psS);
        a.xxA.d(this.psT);
        a.xxA.d(this.psU);
        AppMethodBeat.o(24090);
    }

    static {
        AppMethodBeat.i(24095);
        HashMap hashMap = new HashMap();
        eaA = hashMap;
        hashMap.put(Integer.valueOf("QCONTACT_TABLE".hashCode()), new d() {
            public final String[] Af() {
                return e.fnj;
            }
        });
        AppMethodBeat.o(24095);
    }

    public final HashMap<Integer, d> Jx() {
        return eaA;
    }

    public final void iy(int i) {
        AppMethodBeat.i(24091);
        ab.d("MicroMsg.SubCoreQMsg", "clear plugin");
        if ((i & 32) != 0) {
            ccc();
        }
        AppMethodBeat.o(24091);
    }

    public static void ccb() {
        AppMethodBeat.i(24092);
        aw.ZK();
        if (c.XR().aoZ("qmessage") == null) {
            ak akVar = new ak();
            akVar.setUsername("qmessage");
            akVar.setContent("");
            akVar.eD(bo.anU());
            akVar.hO(0);
            akVar.hM(0);
            aw.ZK();
            c.XR().d(akVar);
            AppMethodBeat.o(24092);
            return;
        }
        String str;
        aw.ZK();
        bi Rb = c.XO().Rb("qmessage");
        ak akVar2 = new ak();
        akVar2.setUsername("qmessage");
        if (Rb == null) {
            str = "";
        } else {
            str = Rb.field_content;
        }
        akVar2.setContent(str);
        akVar2.eD(bo.anU());
        akVar2.hO(0);
        akVar2.hM(0);
        aw.ZK();
        c.XR().a(akVar2, "qmessage");
        AppMethodBeat.o(24092);
    }

    public static void ccc() {
        AppMethodBeat.i(24093);
        bf.aab();
        aw.ZK();
        c.XR().aoY("@qqim");
        aw.ZK();
        c.XR().aoX("qmessage");
        AppMethodBeat.o(24093);
    }

    public final void bz(boolean z) {
        AppMethodBeat.i(24094);
        e.d.a(Integer.valueOf(36), this.psS);
        e.d.a(Integer.valueOf(39), this.psS);
        a.xxA.c(this.psT);
        a.xxA.c(this.psU);
        AppMethodBeat.o(24094);
    }

    public final void bA(boolean z) {
    }
}
