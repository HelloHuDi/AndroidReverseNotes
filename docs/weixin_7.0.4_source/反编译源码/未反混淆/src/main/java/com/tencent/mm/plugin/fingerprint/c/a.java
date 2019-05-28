package com.tencent.mm.plugin.fingerprint.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.soter.b.d;
import com.tencent.mm.plugin.soter.d.e;
import com.tencent.mm.plugin.wallet_core.model.v;
import com.tencent.mm.protocal.protobuf.ccq;
import com.tencent.mm.protocal.protobuf.ccr;
import com.tencent.mm.sdk.platformtools.ab;

public final class a extends d implements k {
    public final b ehh;
    private f ehi;
    public String msn = "";
    public boolean mso = false;

    public a(int i) {
        AppMethodBeat.i(41568);
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.fsJ = new ccq();
        aVar.fsK = new ccr();
        aVar.uri = "/cgi-bin/mmpay-bin/sotergetchallenge";
        aVar.fsI = 1586;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        ccq ccq = (ccq) this.ehh.fsG.fsP;
        e cvQ = com.tencent.mm.plugin.soter.d.d.cvQ();
        ab.i("MicroMsg.NetSceneSoterGetPayChallenge", "hy: cpu_id: %s, uid: %s", cvQ.rOh, cvQ.jSY);
        ccq.rOh = r2;
        ccq.jSY = r1;
        ccq.scene = 0;
        ccq.xbY = i;
        ccq.xbZ = 1;
        AppMethodBeat.o(41568);
    }

    public final int getType() {
        return 1586;
    }

    public final int a(com.tencent.mm.network.e eVar, f fVar) {
        AppMethodBeat.i(41569);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(41569);
        return a;
    }

    public final void d(int i, int i2, String str, q qVar) {
        AppMethodBeat.i(41570);
        ab.d("MicroMsg.NetSceneSoterGetPayChallenge", "hy: onGYNetEnd errType %d errCode%d", Integer.valueOf(i), Integer.valueOf(i2));
        if (i == 0 && i2 == 0) {
            boolean z;
            ccr ccr = (ccr) ((b) qVar).fsH.fsP;
            this.msn = ccr.msn;
            v.tCn.msn = this.msn;
            this.mso = 1 == ccr.xca;
            String str2 = "MicroMsg.NetSceneSoterGetPayChallenge";
            String str3 = "get pay challenge needChangeAuthKey: %b";
            Object[] objArr = new Object[1];
            if (1 == ccr.xca) {
                z = true;
            } else {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            ab.d(str2, str3, objArr);
            v.tCn.mso = this.mso;
            ab.i("MicroMsg.NetSceneSoterGetPayChallenge", "hy: challenge: %s, need auth key: %b", this.msn, Boolean.valueOf(this.mso));
        }
        this.ehi.onSceneEnd(i, i2, str, this);
        AppMethodBeat.o(41570);
    }

    public final void bxO() {
        AppMethodBeat.i(41571);
        ab.e("MicroMsg.NetSceneSoterGetPayChallenge", "hy: auth key expired");
        if (this.ehi != null) {
            this.ehi.onSceneEnd(4, -1, "", this);
        }
        AppMethodBeat.o(41571);
    }

    public final void vL(int i) {
        AppMethodBeat.i(41572);
        if (this.ehi != null) {
            this.ehi.onSceneEnd(4, -1, "", this);
        }
        AppMethodBeat.o(41572);
    }
}
