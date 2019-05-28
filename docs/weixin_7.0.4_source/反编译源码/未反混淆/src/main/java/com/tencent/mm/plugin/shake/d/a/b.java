package com.tencent.mm.plugin.shake.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aou;
import com.tencent.mm.protocal.protobuf.aov;
import com.tencent.mm.sdk.platformtools.ab;

public final class b extends m implements k {
    public com.tencent.mm.ai.b ehh;
    private f ehi;
    private String qtG;
    private int scene;

    public b(String str, int i) {
        this.qtG = str;
        this.scene = i;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(24604);
        this.ehi = fVar;
        a aVar = new a();
        aVar.fsJ = new aou();
        aVar.fsK = new aov();
        aVar.uri = "/cgi-bin/micromsg-bin/gettvinfo";
        aVar.fsI = 552;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        aou aou = (aou) this.ehh.fsG.fsP;
        aou.wsX = this.qtG;
        aou.Scene = this.scene;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(24604);
        return a;
    }

    public final com.tencent.mm.ai.m.b b(q qVar) {
        AppMethodBeat.i(24605);
        aou aou = (aou) ((com.tencent.mm.ai.b) qVar).fsG.fsP;
        com.tencent.mm.ai.m.b bVar;
        if (aou.Scene < 0 || aou.wsX == null || aou.wsX.length() <= 0) {
            ab.e("MicroMsg.scanner.NetSceneGetTVInfo", "ERR: Security Check Failed, Scene = %s", Integer.valueOf(aou.Scene));
            bVar = com.tencent.mm.ai.m.b.EFailed;
            AppMethodBeat.o(24605);
            return bVar;
        }
        bVar = com.tencent.mm.ai.m.b.EOk;
        AppMethodBeat.o(24605);
        return bVar;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(24606);
        ab.d("MicroMsg.scanner.NetSceneGetTVInfo", "onGYNetEnd errtype:" + i2 + " errcode:" + i3 + " errMsg:" + str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(24606);
    }

    public final int getType() {
        return 552;
    }
}
