package com.tencent.mm.plugin.aa.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.l;
import com.tencent.mm.sdk.platformtools.ab;

public final class h extends m implements k {
    private f ehi;
    private b gme;
    private l gml;
    public com.tencent.mm.protocal.protobuf.m gmm;

    public h() {
        AppMethodBeat.i(40654);
        a aVar = new a();
        aVar.fsJ = new l();
        aVar.fsK = new com.tencent.mm.protocal.protobuf.m();
        aVar.uri = "/cgi-bin/mmpay-bin/newaaoperation";
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.gme = aVar.acD();
        this.gml = (l) this.gme.fsG.fsP;
        AppMethodBeat.o(40654);
    }

    public final int getType() {
        return 1698;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(40655);
        this.ehi = fVar;
        int a = a(eVar, this.gme, this);
        AppMethodBeat.o(40655);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(40656);
        ab.i("MicroMsg.NetSceneAAOperation", "onGYNetEnd, errType: %s, errCode: %s", Integer.valueOf(i2), Integer.valueOf(i3));
        this.gmm = (com.tencent.mm.protocal.protobuf.m) ((b) qVar).fsH.fsP;
        if (i2 == 0 && i3 == 0) {
            ab.i("MicroMsg.NetSceneAAOperation", "retCode: %s, retMsg: %s, max_payer_num: %s, max_receiver_num: %s, max_total_num: %s, max_total_amount: %s, max_per_amount: %s, notice: %s, notice_url: %s", Integer.valueOf(this.gmm.kCl), this.gmm.kCm, Integer.valueOf(this.gmm.vzZ), Integer.valueOf(this.gmm.vAa), Integer.valueOf(this.gmm.vAb), Long.valueOf(this.gmm.vAc), Long.valueOf(this.gmm.vAd), this.gmm.kCx, this.gmm.kCy);
        }
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(40656);
    }
}
