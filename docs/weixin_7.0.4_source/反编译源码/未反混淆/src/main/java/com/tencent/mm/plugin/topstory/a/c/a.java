package com.tencent.mm.plugin.topstory.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cvb;
import com.tencent.mm.protocal.protobuf.cvc;
import com.tencent.mm.sdk.platformtools.ab;

public final class a extends m implements k {
    private b ehh;
    private f ehi;
    public String nQB;
    private long sAZ = System.currentTimeMillis();

    public a(String str, String str2) {
        AppMethodBeat.i(65503);
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.fsI = 2582;
        aVar.uri = "/cgi-bin/mmsearch-bin/searchwebcomm";
        aVar.fsJ = new cvb();
        aVar.fsK = new cvc();
        this.ehh = aVar.acD();
        cvb cvb = (cvb) this.ehh.fsG.fsP;
        cvb.xra = str2;
        cvb.nQB = str;
        this.nQB = str;
        AppMethodBeat.o(65503);
    }

    public final int getType() {
        return 2582;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(65504);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(65504);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(65505);
        ab.i("MicroMsg.TopStory.NetSceneSearchWebComm", "netId %d | errType %d | errCode %d | errMsg %s useTime %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str, Long.valueOf(System.currentTimeMillis() - this.sAZ));
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(65505);
    }

    public final cvc cFs() {
        return (cvc) this.ehh.fsH.fsP;
    }
}
