package com.tencent.mm.plugin.websearch.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bsj;
import com.tencent.mm.protocal.protobuf.bsk;
import com.tencent.mm.sdk.platformtools.ab;

public final class w extends m implements k {
    private f ehi;
    public b fAT;
    private int scene;
    private String tZV;

    public w(bsj bsj) {
        AppMethodBeat.i(124072);
        a aVar = new a();
        aVar.uri = "/cgi-bin/mmsearch-bin/searchreport";
        aVar.fsJ = bsj;
        aVar.fsK = new bsk();
        this.fAT = aVar.acD();
        this.scene = bsj.Scene;
        this.tZV = bsj.wUu;
        AppMethodBeat.o(124072);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(124073);
        ab.i("MicroMsg.FTS.NetSceneWebSearchReport", "netId %d | errType %d | errCode %d | errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            this.ehi.onSceneEnd(i2, i3, str, this);
            an.Il(6);
            an.a(this.scene, 5, i2, i3, this.tZV);
            AppMethodBeat.o(124073);
            return;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        an.Il(7);
        AppMethodBeat.o(124073);
    }

    public final int getType() {
        return 1134;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(124074);
        ab.i("MicroMsg.FTS.NetSceneWebSearchReport", "doScene %d", Integer.valueOf(this.scene));
        an.Il(5);
        an.y(this.scene, 4, this.tZV);
        this.ehi = fVar;
        int a = a(eVar, this.fAT, this);
        AppMethodBeat.o(124074);
        return a;
    }
}
