package com.tencent.mm.plugin.websearch.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.azx;
import com.tencent.mm.protocal.protobuf.azy;
import com.tencent.mm.sdk.platformtools.ab;

public final class v extends m implements k {
    public int businessType;
    public int cIv;
    private f ehi;
    private b fAT;
    public String nQB;
    public int scene;
    public azy tZT;
    private int tZU;

    public v(int i, int i2, int i3, int i4, String str, long j, String str2) {
        AppMethodBeat.i(124069);
        this.scene = i;
        this.tZU = i3;
        this.cIv = i4;
        this.businessType = i2;
        this.nQB = str2;
        ab.i("MicroMsg.FTS.NetSceneWebSearchGuide", "scene %d, h5Version=%d type=%d", Integer.valueOf(i), Integer.valueOf(i3), Integer.valueOf(i2));
        a aVar = new a();
        aVar.uri = "/cgi-bin/mmsearch-bin/searchguide";
        aVar.fsJ = new azx();
        aVar.fsK = new azy();
        this.fAT = aVar.acD();
        azx azx = (azx) this.fAT.fsG.fsP;
        azx.Scene = i;
        azx.wDH = i3;
        azx.wDI = aa.abJ();
        azx.wDJ = i2;
        azx.luQ = str;
        azx.wDK = j;
        AppMethodBeat.o(124069);
    }

    public final int getType() {
        return 1048;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(124070);
        this.ehi = fVar;
        int a = a(eVar, this.fAT, this);
        AppMethodBeat.o(124070);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(124071);
        ab.i("MicroMsg.FTS.NetSceneWebSearchGuide", "netId %d | errType %d | errCode %d | errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            this.tZT = (azy) this.fAT.fsH.fsP;
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(124071);
            return;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(124071);
    }
}
