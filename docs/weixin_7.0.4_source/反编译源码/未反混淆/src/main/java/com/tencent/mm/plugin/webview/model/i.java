package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ve;
import com.tencent.mm.protocal.protobuf.vf;

public final class i extends m implements k {
    private f eIc;
    private final b ehh;

    public i(int i) {
        AppMethodBeat.i(6589);
        a aVar = new a();
        aVar.fsJ = new ve();
        aVar.fsK = new vf();
        aVar.uri = "/cgi-bin/mmbiz-bin/oauth_delavatar";
        this.ehh = aVar.acD();
        ((ve) this.ehh.fsG.fsP).wcA = i;
        AppMethodBeat.o(6589);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(6590);
        this.eIc.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(6590);
    }

    public final int getType() {
        return 2700;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(6591);
        this.eIc = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(6591);
        return a;
    }
}
