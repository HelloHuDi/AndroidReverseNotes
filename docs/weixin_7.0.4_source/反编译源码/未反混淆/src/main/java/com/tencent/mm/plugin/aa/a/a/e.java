package com.tencent.mm.plugin.aa.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.d;
import com.tencent.mm.sdk.platformtools.ab;

public final class e extends m implements k {
    private f ehi;
    private b gme;
    private d gmf;
    public com.tencent.mm.protocal.protobuf.e gmg;
    public int scene;

    public e(String str, int i, String str2) {
        AppMethodBeat.i(40644);
        a aVar = new a();
        aVar.fsJ = new d();
        aVar.fsK = new com.tencent.mm.protocal.protobuf.e();
        aVar.uri = "/cgi-bin/mmpay-bin/newaaclose";
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.gme = aVar.acD();
        this.gmf = (d) this.gme.fsG.fsP;
        this.gmf.vzM = str2;
        this.gmf.vzL = str;
        this.gmf.scene = i;
        this.scene = i;
        ab.d("MicroMsg.NetSceneAAClose", "NetSceneAAClose, billNo: %s, scene: %s", this.gmf.vzL, Integer.valueOf(i));
        AppMethodBeat.o(40644);
    }

    public final int getType() {
        return 1530;
    }

    public final int a(com.tencent.mm.network.e eVar, f fVar) {
        AppMethodBeat.i(40645);
        ab.i("MicroMsg.NetSceneAAClose", "doScene");
        this.ehi = fVar;
        int a = a(eVar, this.gme, this);
        AppMethodBeat.o(40645);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(40646);
        ab.i("MicroMsg.NetSceneAAClose", "onGYNetEnd, errType: %s, errCode: %s", Integer.valueOf(i2), Integer.valueOf(i3));
        this.gmg = (com.tencent.mm.protocal.protobuf.e) ((b) qVar).fsH.fsP;
        ab.i("MicroMsg.NetSceneAAClose", "retcode: %s, retmsg: %s", Integer.valueOf(this.gmg.kCl), this.gmg.kCm);
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(40646);
    }
}
