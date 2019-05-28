package com.tencent.mm.plugin.account.bind.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.appbrand.jsapi.contact.e;
import com.tencent.mm.protocal.protobuf.ciy;
import com.tencent.mm.protocal.protobuf.ciz;
import com.tencent.mm.sdk.platformtools.ab;

public final class c extends m implements k {
    private final b ehh;
    private f ehi;

    public c() {
        AppMethodBeat.i(13324);
        a aVar = new a();
        aVar.fsJ = new ciy();
        aVar.fsK = new ciz();
        aVar.uri = "/cgi-bin/micromsg-bin/unbindlinkedincontact";
        aVar.fsI = e.CTRL_INDEX;
        this.ehh = aVar.acD();
        ((ciy) this.ehh.fsG.fsP).vIJ = 1;
        AppMethodBeat.o(13324);
    }

    public final int a(com.tencent.mm.network.e eVar, f fVar) {
        AppMethodBeat.i(13325);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(13325);
        return a;
    }

    public final int getType() {
        return e.CTRL_INDEX;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(13326);
        ab.d("MicroMsg.NetSceneUnBindLinkedinContact", "onGYNetEnd errType:" + i2 + " errCode:" + i3);
        if (i2 == 0 && i3 == 0) {
            g.RP().Ry().set(286722, (Object) "");
            g.RP().Ry().set(286721, (Object) "");
            g.RP().Ry().set(286723, (Object) "");
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(13326);
    }
}
