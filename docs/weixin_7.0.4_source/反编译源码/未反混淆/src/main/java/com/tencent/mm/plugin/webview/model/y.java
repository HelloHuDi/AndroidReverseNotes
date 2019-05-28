package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bna;
import com.tencent.mm.protocal.protobuf.bnb;

public final class y extends m implements k {
    private f eIc;
    public final b ehh;

    public y(String str) {
        AppMethodBeat.i(6637);
        a aVar = new a();
        aVar.fsJ = new bna();
        aVar.fsK = new bnb();
        aVar.uri = "/cgi-bin/mmbiz-bin/qrconnect_authorize";
        this.ehh = aVar.acD();
        ((bna) this.ehh.fsG.fsP).wIH = str;
        AppMethodBeat.o(6637);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(6638);
        this.eIc.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(6638);
    }

    public final int getType() {
        return 2543;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(6639);
        this.eIc = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(6639);
        return a;
    }
}
