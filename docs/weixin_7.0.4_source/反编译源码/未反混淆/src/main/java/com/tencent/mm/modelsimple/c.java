package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.m.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.m.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

public final class c extends m implements k {
    private f ehi;
    private q ftU = new a();

    public static class a extends com.tencent.mm.ai.k {
        private final com.tencent.mm.protocal.m.a fOp = new com.tencent.mm.protocal.m.a();
        private final b fOq = new b();

        public a() {
            AppMethodBeat.i(16553);
            AppMethodBeat.o(16553);
        }

        public final d ZR() {
            return this.fOp;
        }

        public final e ZS() {
            return this.fOq;
        }

        public final int getType() {
            return 0;
        }

        public final String getUri() {
            return null;
        }
    }

    public static void cQ(boolean z) {
        AppMethodBeat.i(16554);
        ab.i("MicroMsg.NetSceneBgFg", "summerbgfg setBgFgForMuteRoom isFg[%s], accHasReady[%s] stack[%s]", Boolean.valueOf(z), Boolean.valueOf(aw.RK()), bo.dpG());
        if (!aw.RK()) {
            AppMethodBeat.o(16554);
        } else if (aw.Rg() == null || aw.Rg().ftA == null || aw.Rg().ftA.adg() == null) {
            ab.i("MicroMsg.NetSceneBgFg", "summerbgfg setBgFgForMuteRoom push not rready");
            AppMethodBeat.o(16554);
        } else {
            aw.Rg().ftA.adg().cE(z);
            if (z) {
                aw.Rg().a(new c(true), 0);
                AppMethodBeat.o(16554);
                return;
            }
            aw.Rg().a(new c(aiS()), 0);
            AppMethodBeat.o(16554);
        }
    }

    private static boolean aiS() {
        int i;
        boolean z;
        AppMethodBeat.i(16555);
        if (ae.gjf != -1) {
            i = ae.gjf;
        } else {
            try {
                i = bo.getInt(g.Nu().getValue("MuteRoomDisable"), 0);
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.NetSceneBgFg", e, "", new Object[0]);
                i = 0;
            }
        }
        ab.i("MicroMsg.NetSceneBgFg", "somr DynamicConfig checkBit:%d TestMuteRoomEnable:%d muteRoomDisable:%d fg:%b", Integer.valueOf(1), Integer.valueOf(ae.gjf), Integer.valueOf(i), Boolean.valueOf(com.tencent.mm.sdk.a.b.foreground));
        if ((i & 1) != 0) {
            z = true;
        } else {
            z = r3;
        }
        AppMethodBeat.o(16555);
        return z;
    }

    private c(boolean z) {
        int i;
        AppMethodBeat.i(16556);
        com.tencent.mm.protocal.m.a aVar = (com.tencent.mm.protocal.m.a) this.ftU.acF();
        aVar.netType = com.tencent.mm.protocal.a.getNetType(ah.getContext());
        if (z) {
            i = 1;
        } else {
            i = 2;
        }
        aVar.vyo = i;
        AppMethodBeat.o(16556);
    }

    public final int a(com.tencent.mm.network.e eVar, f fVar) {
        AppMethodBeat.i(16557);
        this.ehi = fVar;
        int a = a(eVar, this.ftU, this);
        AppMethodBeat.o(16557);
        return a;
    }

    public final int getType() {
        return 0;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(16558);
        ab.d("MicroMsg.NetSceneBgFg", " ret[%d]", Integer.valueOf(((b) qVar.ZS()).vyp.kCl));
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(16558);
    }
}
