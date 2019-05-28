package com.tencent.mm.plugin.backup.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.appbrand.jsapi.b.l;
import com.tencent.mm.plugin.backup.b.d;
import com.tencent.mm.protocal.protobuf.ahp;
import com.tencent.mm.protocal.protobuf.ahq;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class e extends m implements k {
    private final b ehh;
    private f ehi;

    public e(String str) {
        AppMethodBeat.i(17658);
        ab.i("MicroMsg.NetSceneGetConnectInfo", "summerbak NetSceneGetConnectInfo init, url[%s], stack[%s]", str, bo.dpG());
        a aVar = new a();
        aVar.fsJ = new ahp();
        aVar.fsK = new ahq();
        aVar.uri = "/cgi-bin/micromsg-bin/getconnectinfo";
        aVar.fsI = l.CTRL_INDEX;
        this.ehh = aVar.acD();
        ((ahp) this.ehh.fsG.fsP).URL = str;
        AppMethodBeat.o(17658);
    }

    public final int getType() {
        return l.CTRL_INDEX;
    }

    public final int a(com.tencent.mm.network.e eVar, f fVar) {
        AppMethodBeat.i(17659);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(17659);
        return a;
    }

    public final ahq aUk() {
        return (ahq) this.ehh.fsH.fsP;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(17660);
        ab.i("MicroMsg.NetSceneGetConnectInfo", "onGYNetEnd errType[%d], errCode[%d]", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 0 && i3 == 0) {
            ahq aUk = aUk();
            d.ao(aUk.vIn.getBuffer().wR);
            ab.i("MicroMsg.NetSceneGetConnectInfo", "onGYNetEnd id[%s], hello[%s], ok[%s], PCName[%s], PCAcctName[%s], scene[%d], resource[%s]", aUk.ID, aUk.vIW, aUk.vIX, aUk.vIP, aUk.vIQ, Integer.valueOf(aUk.Scene), aUk.wnV);
            aUk.vIn.getBuffer();
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(17660);
    }
}
