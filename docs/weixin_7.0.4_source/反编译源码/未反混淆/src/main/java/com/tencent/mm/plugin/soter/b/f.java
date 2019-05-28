package com.tencent.mm.plugin.soter.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.protocal.protobuf.ckb;
import com.tencent.mm.protocal.protobuf.ckc;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.soter.a.f.e;
import com.tencent.soter.a.f.e.a;

public final class f extends m implements k, e {
    private b ehh;
    private com.tencent.mm.ai.f ehi;
    private com.tencent.soter.a.f.b<e.b> msq = null;

    public final /* synthetic */ void bR(Object obj) {
        AppMethodBeat.i(59313);
        a aVar = (a) obj;
        b.a aVar2 = new b.a();
        aVar2.fsJ = new ckb();
        aVar2.fsK = new ckc();
        aVar2.uri = "/cgi-bin/micromsg-bin/updatesoterask";
        aVar2.fsI = bc.CTRL_INDEX;
        aVar2.fsL = 0;
        aVar2.fsM = 0;
        this.ehh = aVar2.acD();
        ckb ckb = (ckb) this.ehh.fsG.fsP;
        ckb.Scene = bc.CTRL_INDEX;
        ckb.xil = aVar.Awa;
        ckb.xim = aVar.AvZ;
        ab.i("MicroMsg.NetSceneUploadSoterASK", "alvinluo keyJson: %s, signature: %s", aVar.AvZ, aVar.Awa);
        ab.v("MicroMsg.NetSceneUploadSoterASK", "alvinluo hashCode: %s", Integer.valueOf(hashCode()));
        AppMethodBeat.o(59313);
    }

    public final int getType() {
        return bc.CTRL_INDEX;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ai.f fVar) {
        AppMethodBeat.i(59310);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(59310);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(59311);
        ab.i("MicroMsg.NetSceneUploadSoterASK", "MicroMsg.NetSceneUploadSoterASK errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        if (i2 == 0 && i3 == 0) {
            ab.i("MicroMsg.NetSceneUploadSoterASK", "netscene upload soter ask successfully");
            if (this.msq != null) {
                this.msq.dd(new e.b(true));
                AppMethodBeat.o(59311);
                return;
            }
        }
        ab.e("MicroMsg.NetSceneUploadSoterASK", "netscene upload soter ask failed");
        if (this.msq != null) {
            this.msq.dd(new e.b(false));
        }
        AppMethodBeat.o(59311);
    }

    public final void a(com.tencent.soter.a.f.b<e.b> bVar) {
        this.msq = bVar;
    }

    public final void execute() {
        AppMethodBeat.i(59312);
        ab.v("MicroMsg.NetSceneUploadSoterASK", "alvinluo NetSceneUploadSoterASK execute doScene");
        g.Rg().a((m) this, 0);
        AppMethodBeat.o(59312);
    }
}
