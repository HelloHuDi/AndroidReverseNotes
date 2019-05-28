package com.tencent.mm.plugin.backup.bakoldlogic.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.appbrand.jsapi.b.l;
import com.tencent.mm.plugin.backup.b.d;
import com.tencent.mm.protocal.protobuf.ahp;
import com.tencent.mm.protocal.protobuf.ahq;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class f extends m implements k {
    private final b ehh;
    private com.tencent.mm.ai.f ehi;

    public f(String str) {
        AppMethodBeat.i(17895);
        ab.i("MicroMsg.NetSceneGetConnectInfo", "summerbak NetSceneGetConnectInfo init, url[%s], stack[%s]", str, bo.dpG());
        a aVar = new a();
        aVar.fsJ = new ahp();
        aVar.fsK = new ahq();
        aVar.uri = "/cgi-bin/micromsg-bin/getconnectinfo";
        aVar.fsI = l.CTRL_INDEX;
        this.ehh = aVar.acD();
        ((ahp) this.ehh.fsG.fsP).URL = str;
        AppMethodBeat.o(17895);
    }

    public final int getType() {
        return l.CTRL_INDEX;
    }

    public final int a(e eVar, com.tencent.mm.ai.f fVar) {
        AppMethodBeat.i(17896);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(17896);
        return a;
    }

    public final ahq aUU() {
        return (ahq) this.ehh.fsH.fsP;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(17897);
        ab.i("MicroMsg.NetSceneGetConnectInfo", "errType %d,  errCode %d", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 0 && i3 == 0) {
            ahq ahq = (ahq) this.ehh.fsH.fsP;
            d.ao(ahq.vIn.getBuffer().wR);
            ab.i("MicroMsg.NetSceneGetConnectInfo", "id:%s  hello:%s, ok:%s, PCName:%s, PCAcctName:%s, scene:%d", ahq.ID, ahq.vIW, ahq.vIX, ahq.vIP, ahq.vIQ, Integer.valueOf(ahq.Scene));
            ab.i("MicroMsg.NetSceneGetConnectInfo", "resource:%s", ahq.wnV);
            ahq.vIn.getBuffer();
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(17897);
    }
}
