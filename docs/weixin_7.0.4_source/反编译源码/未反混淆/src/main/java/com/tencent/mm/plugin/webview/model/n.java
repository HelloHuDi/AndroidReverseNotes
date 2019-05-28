package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.anc;
import com.tencent.mm.protocal.protobuf.and;

public final class n extends m implements k {
    private f eIc;
    public final b ehh;

    public n(String str) {
        AppMethodBeat.i(6604);
        a aVar = new a();
        aVar.fsJ = new anc();
        aVar.fsK = new and();
        aVar.uri = "/cgi-bin/mmbiz-bin/oauth_getrandomavatar";
        this.ehh = aVar.acD();
        ((anc) this.ehh.fsG.fsP).csB = str;
        AppMethodBeat.o(6604);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(6605);
        this.eIc.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(6605);
    }

    public final int getType() {
        return 2785;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(6606);
        this.eIc = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(6606);
        return a;
    }
}
