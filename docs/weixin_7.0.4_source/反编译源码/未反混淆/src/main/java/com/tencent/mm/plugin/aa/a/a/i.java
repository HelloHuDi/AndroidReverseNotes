package com.tencent.mm.plugin.aa.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.n;
import com.tencent.mm.protocal.protobuf.o;
import com.tencent.mm.sdk.platformtools.ab;

public final class i extends m implements k, com.tencent.mm.wallet_core.c.i {
    private f ehi;
    private b gme;
    private n gmn;
    public o gmo;

    public i(String str, long j, int i, String str2) {
        AppMethodBeat.i(40657);
        a aVar = new a();
        aVar.fsJ = new n();
        aVar.fsK = new o();
        aVar.uri = "/cgi-bin/mmpay-bin/newaapay";
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.gme = aVar.acD();
        this.gmn = (n) this.gme.fsG.fsP;
        this.gmn.vzL = str;
        this.gmn.vAe = j;
        this.gmn.scene = i;
        this.gmn.vzM = str2;
        ab.i("MicroMsg.NetSceneAAPay", "NetSceneAAPay, bill_no: %s, pay_amount: %s, scene: %s, groupid: %s", this.gmn.vzL, Long.valueOf(this.gmn.vAe), Integer.valueOf(this.gmn.scene), this.gmn.vzM);
        AppMethodBeat.o(40657);
    }

    public final int getType() {
        return 1629;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(40658);
        this.ehi = fVar;
        int a = a(eVar, this.gme, this);
        AppMethodBeat.o(40658);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(40659);
        ab.i("MicroMsg.NetSceneAAPay", "onGYNetEnd, errType: %s, errCode: %s", Integer.valueOf(i2), Integer.valueOf(i3));
        this.gmo = (o) ((b) qVar).fsH.fsP;
        ab.i("MicroMsg.NetSceneAAPay", "retcode: %s, retmsg: %s, paymsgid:%s", Integer.valueOf(this.gmo.kCl), this.gmo.kCm, this.gmo.cJF);
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(40659);
    }
}
