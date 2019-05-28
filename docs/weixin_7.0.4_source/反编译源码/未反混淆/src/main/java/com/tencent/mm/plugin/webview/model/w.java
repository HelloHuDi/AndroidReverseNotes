package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ber;
import com.tencent.mm.protocal.protobuf.bes;

public final class w extends m implements k {
    private f eIc;
    public final b ehh;
    public Object tag;
    public String umb;

    public w(String str, String str2, int i) {
        AppMethodBeat.i(6631);
        a aVar = new a();
        aVar.fsJ = new ber();
        aVar.fsK = new bes();
        aVar.uri = "/cgi-bin/mmbiz-bin/oauth_authorize";
        this.umb = str;
        this.ehh = aVar.acD();
        ber ber = (ber) this.ehh.fsG.fsP;
        ber.wIH = str;
        ber.vNN = str2;
        ber.scene = i;
        AppMethodBeat.o(6631);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(6632);
        this.eIc.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(6632);
    }

    public final int getType() {
        return 1254;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(6633);
        this.eIc = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(6633);
        return a;
    }
}
