package com.tencent.mm.plugin.soter.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.clo;
import com.tencent.mm.protocal.protobuf.clp;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.soter.a.f.e.a;

public final class e extends d implements k, com.tencent.soter.a.f.e {
    private b ehh;
    private f ehi;
    private com.tencent.soter.a.f.b<com.tencent.soter.a.f.e.b> msq = null;

    public final /* synthetic */ void bR(Object obj) {
        AppMethodBeat.i(59309);
        a aVar = (a) obj;
        b.a aVar2 = new b.a();
        aVar2.fsJ = new clo();
        aVar2.fsK = new clp();
        aVar2.uri = "/cgi-bin/mmbiz-bin/usrmsg/uploadsoterauthkey";
        aVar2.fsI = 1185;
        aVar2.fsL = 0;
        aVar2.fsM = 0;
        this.ehh = aVar2.acD();
        clo clo = (clo) this.ehh.fsG.fsP;
        clo.xjk = aVar.AvZ;
        clo.xjl = aVar.Awa;
        AppMethodBeat.o(59309);
    }

    public final int getType() {
        return 1185;
    }

    public final int a(com.tencent.mm.network.e eVar, f fVar) {
        AppMethodBeat.i(59304);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(59304);
        return a;
    }

    public final void d(int i, int i2, String str, q qVar) {
        AppMethodBeat.i(59305);
        ab.d("MicroMsg.NetSceneSoterMPUpdateAuthKey", "hy: NetSceneSoterMPUpdateAuthKey onGYNetEnd errType: %d , errCode: %d, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i, i2, str, this);
        }
        if (this.msq != null) {
            if (i == 0 && i2 == 0) {
                this.msq.dd(new com.tencent.soter.a.f.e.b(true));
                AppMethodBeat.o(59305);
                return;
            }
            this.msq.dd(new com.tencent.soter.a.f.e.b(false));
        }
        AppMethodBeat.o(59305);
    }

    public final void bxO() {
        AppMethodBeat.i(59306);
        ab.i("MicroMsg.NetSceneSoterMPUpdateAuthKey", "hy:NetSceneSoterMPUpdateAuthKey authkey required");
        if (this.ehi != null) {
            this.ehi.onSceneEnd(4, -1, "", this);
        }
        if (this.msq != null) {
            this.msq.dd(new com.tencent.soter.a.f.e.b(false));
        }
        AppMethodBeat.o(59306);
    }

    public final void vL(int i) {
        AppMethodBeat.i(59307);
        ab.i("MicroMsg.NetSceneSoterMPUpdateAuthKey", "hy: NetSceneSoterMPUpdateAuthKey onError: errType: %d, errcode: %d", Integer.valueOf(3), Integer.valueOf(i));
        if (this.ehi != null) {
            this.ehi.onSceneEnd(4, -1, "", this);
        }
        AppMethodBeat.o(59307);
    }

    public final void execute() {
        AppMethodBeat.i(59308);
        g.Rg().a((m) this, 0);
        AppMethodBeat.o(59308);
    }

    public final void a(com.tencent.soter.a.f.b<com.tencent.soter.a.f.e.b> bVar) {
        this.msq = bVar;
    }
}
