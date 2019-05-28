package com.tencent.mm.modelmulti;

import com.tencent.mars.comm.WakerLock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.x.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

public final class i extends m implements k {
    private WakerLock ebJ = new WakerLock(ah.getContext(), "MicroMsg.NetSceneSynCheck");
    private f ehi;
    private final q ftU;

    public static class a extends com.tencent.mm.ai.k {
        private final com.tencent.mm.protocal.x.a fIv = new com.tencent.mm.protocal.x.a();
        private final b fIw = new b();

        public a() {
            AppMethodBeat.i(58375);
            AppMethodBeat.o(58375);
        }

        public final d ZR() {
            return this.fIv;
        }

        public final e ZS() {
            return this.fIw;
        }

        public final int getType() {
            return 39;
        }

        public final String getUri() {
            return null;
        }

        public final int acC() {
            return 1;
        }
    }

    public i() {
        AppMethodBeat.i(58376);
        this.ebJ.lock(3000, "NetSceneSynCheck");
        this.ftU = new a();
        g.RQ();
        if (g.RP() != null) {
            g.RQ();
            if (g.RP().Ry() != null) {
                g.RQ();
                com.tencent.mm.protocal.x.a aVar = (com.tencent.mm.protocal.x.a) this.ftU.acF();
                aVar.fIi = bo.anf((String) g.RP().Ry().get(8195, null));
                com.tencent.mm.protocal.x.a aVar2 = (com.tencent.mm.protocal.x.a) this.ftU.acF();
                g.RQ();
                g.RN();
                aVar2.uin = com.tencent.mm.kernel.a.QF();
                ((com.tencent.mm.protocal.x.a) this.ftU.acF()).netType = com.tencent.mm.protocal.a.getNetType(ah.getContext());
                ((com.tencent.mm.protocal.x.a) this.ftU.acF()).vyo = com.tencent.mm.protocal.a.dlZ();
                ab.d("MicroMsg.MMSyncCheck", "NetSceneSynCheck");
                AppMethodBeat.o(58376);
                return;
            }
        }
        ab.e("MicroMsg.NetSceneSynCheck", "[arthurdan.NetSceneSynCheckCrash] Notice!!! MMCore.getAccStg() is null");
        AppMethodBeat.o(58376);
    }

    public final int a(com.tencent.mm.network.e eVar, f fVar) {
        AppMethodBeat.i(58377);
        this.ehi = fVar;
        int a = a(eVar, this.ftU, this);
        if (a == -1 && this.ebJ.isLocking()) {
            this.ebJ.unLock();
        }
        AppMethodBeat.o(58377);
        return a;
    }

    public final boolean acI() {
        return true;
    }

    public final int getType() {
        return 39;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(58378);
        b bVar = (b) qVar.ZS();
        ab.i("MicroMsg.NetSceneSynCheck", "new syncCheck complete, selector=" + bVar.vyM);
        if (g.RK() && !com.tencent.mm.kernel.a.QT()) {
            byte[] bArr2 = ((com.tencent.mm.protocal.x.a) qVar.acF()).eJt;
            if (bo.cb(bArr2)) {
                ab.e("MicroMsg.NetSceneSynCheck", "onGYNetEnd md5 is null");
            }
            bVar.eJt = bArr2;
            ((com.tencent.mm.plugin.zero.b.b) g.K(com.tencent.mm.plugin.zero.b.b.class)).ahW().a(bVar.vyM, 2, bVar.dmu());
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        this.ebJ.unLock();
        AppMethodBeat.o(58378);
    }
}
