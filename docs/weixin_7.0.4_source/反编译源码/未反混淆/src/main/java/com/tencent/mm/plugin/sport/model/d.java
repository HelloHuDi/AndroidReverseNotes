package com.tencent.mm.plugin.sport.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.sport.a.c;
import com.tencent.mm.protocal.protobuf.aom;
import com.tencent.mm.protocal.protobuf.aon;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.ref.WeakReference;

public final class d extends m implements k {
    private f ehi;
    private b fAT;
    aom rPr;
    aon rPs;
    private WeakReference<c> rPt;

    public d(long j, long j2, c cVar) {
        AppMethodBeat.i(93657);
        this.rPt = new WeakReference(cVar);
        a aVar = new a();
        aVar.uri = "/cgi-bin/mmoc-bin/hardware/getsteplist";
        aVar.fsJ = new aom();
        aVar.fsK = new aon();
        this.fAT = aVar.acD();
        this.rPr = (aom) this.fAT.fsG.fsP;
        this.rPr.wdb = (int) (j / 1000);
        this.rPr.wdc = (int) (j2 / 1000);
        AppMethodBeat.o(93657);
    }

    public final int getType() {
        return 1734;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(93658);
        this.ehi = fVar;
        int a = a(eVar, this.fAT, this);
        AppMethodBeat.o(93658);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(93659);
        ab.i("MicroMsg.Sport.NetSceneGetStepList", "netId %d | errType %d | errCode %d | errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.rPs = (aon) this.fAT.fsH.fsP;
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(93659);
    }

    public final c cwm() {
        AppMethodBeat.i(138291);
        c cVar = (c) this.rPt.get();
        AppMethodBeat.o(138291);
        return cVar;
    }
}
