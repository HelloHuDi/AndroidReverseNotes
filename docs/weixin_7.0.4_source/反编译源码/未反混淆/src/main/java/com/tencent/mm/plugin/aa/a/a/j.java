package com.tencent.mm.plugin.aa.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.u;
import com.tencent.mm.protocal.protobuf.v;
import com.tencent.mm.sdk.platformtools.ab;

public final class j extends m implements k {
    private f ehi;
    private b gme;
    private u gmp;
    public v gmq;

    public j(String str, int i, String str2, String str3, int i2) {
        AppMethodBeat.i(40660);
        a aVar = new a();
        aVar.fsJ = new u();
        aVar.fsK = new v();
        aVar.uri = "/cgi-bin/mmpay-bin/newaaquerydetail";
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.gme = aVar.acD();
        this.gmp = (u) this.gme.fsG.fsP;
        this.gmp.vzL = str;
        this.gmp.scene = i;
        this.gmp.vzM = str2;
        if (i == 5) {
            ab.i("MicroMsg.NetSceneAAQueryDetail", "set sign and ver");
            this.gmp.sign = str3;
            this.gmp.ver = i2;
        }
        ab.i("MicroMsg.NetSceneAAQueryDetail", "NetSceneAAQueryDetail, billNo: %s, scene: %s, groupId: %s", str, Integer.valueOf(i), str2);
        AppMethodBeat.o(40660);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(40661);
        ab.i("MicroMsg.NetSceneAAQueryDetail", "onGYNetEnd, errType: %s, errCode: %s", Integer.valueOf(i2), Integer.valueOf(i3));
        this.gmq = (v) ((b) qVar).fsH.fsP;
        ab.i("MicroMsg.NetSceneAAQueryDetail", "retcode: %s, retmsg: %s", Integer.valueOf(this.gmq.kCl), this.gmq.kCm);
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(40661);
    }

    public final int getType() {
        return 1695;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(40662);
        ab.i("MicroMsg.NetSceneAAQueryDetail", "doScene");
        this.ehi = fVar;
        int a = a(eVar, this.gme, this);
        AppMethodBeat.o(40662);
        return a;
    }
}
