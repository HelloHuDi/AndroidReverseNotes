package com.tencent.mm.plugin.sns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.ia;
import com.tencent.mm.g.a.pd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.q;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.protocal.protobuf.cbf;
import com.tencent.mm.protocal.protobuf.cbg;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;

public final class d extends c<ia> implements f {
    private int qBW;
    private cbf qBX;
    private n qBY;
    private ap qBZ;

    public d() {
        AppMethodBeat.i(35604);
        this.xxI = ia.class.getName().hashCode();
        AppMethodBeat.o(35604);
    }

    private boolean a(ia iaVar) {
        AppMethodBeat.i(35605);
        if (iaVar instanceof ia) {
            this.qBW = iaVar.cCX.cyN;
            this.qBY = af.cnF().DK(this.qBW);
            this.qBX = aj.p(this.qBY);
            if (this.qBX == null || ((this.qBX.wGz != 3 || this.qBX.xaB == null || this.qBX.xaB.size() <= 0) && (this.qBX.wGz != 5 || this.qBX.wFp == null || this.qBX.wFp.size() <= 0))) {
                m qVar = new q(this.qBY.field_snsId);
                ((cbg) qVar.ehh.fsG.fsP).xaH = 1;
                g.RQ();
                g.RO().eJo.a(210, (f) this);
                g.RQ();
                g.RO().eJo.a(qVar, 0);
                this.qBZ = new ap(new a() {
                    public final boolean BI() {
                        AppMethodBeat.i(35603);
                        pd pdVar = new pd();
                        pdVar.cLs.cCZ = null;
                        com.tencent.mm.sdk.b.a.xxA.m(pdVar);
                        AppMethodBeat.o(35603);
                        return false;
                    }
                }, false);
                this.qBZ.ae(10000, 10000);
                AppMethodBeat.o(35605);
                return true;
            }
            iaVar.cCY.cCZ = this.qBX;
            AppMethodBeat.o(35605);
            return true;
        }
        ab.f("MicroMsg.GetSnsObjectDetailListener", "mismatched event");
        AppMethodBeat.o(35605);
        return false;
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(35606);
        ab.i("MicroMsg.GetSnsObjectDetailListener", "dz:[onSceneEnd]errType:%d errCode:%d errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
        this.qBZ.stopTimer();
        if (i == 0 && i2 == 0) {
            n kD = af.cnF().kD(this.qBY.field_snsId);
            pd pdVar = new pd();
            pdVar.cLs.cCZ = aj.p(kD);
            com.tencent.mm.sdk.b.a.xxA.m(pdVar);
            AppMethodBeat.o(35606);
            return;
        }
        pd pdVar2 = new pd();
        pdVar2.cLs.cCZ = null;
        com.tencent.mm.sdk.b.a.xxA.m(pdVar2);
        AppMethodBeat.o(35606);
    }
}
