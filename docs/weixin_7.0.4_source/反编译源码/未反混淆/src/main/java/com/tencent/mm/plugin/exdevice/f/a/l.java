package com.tencent.mm.plugin.exdevice.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ayg;
import com.tencent.mm.protocal.protobuf.ayh;
import com.tencent.mm.sdk.platformtools.ab;

public final class l extends m implements k {
    public int cKJ;
    private b ehh = null;
    private f ehi = null;
    public String fhH;
    public String lvL;

    public l(String str, String str2, int i, String str3) {
        AppMethodBeat.i(19466);
        this.lvL = str3;
        this.fhH = str2;
        this.cKJ = i;
        this.lvL = str3;
        a aVar = new a();
        aVar.fsJ = new ayg();
        aVar.fsK = new ayh();
        aVar.uri = "/cgi-bin/mmbiz-bin/rank/addlike";
        aVar.fsI = 1041;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        ayg ayg = (ayg) this.ehh.fsG.fsP;
        ayg.lCH = str2;
        ayg.username = str;
        ayg.cKJ = i;
        ayg.fha = str3;
        AppMethodBeat.o(19466);
    }

    public final int getType() {
        return 1041;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(19467);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(19467);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(19468);
        ab.d("MicroMsg.NetSceneUpdateLikeStatus", "hy: end. errType: %d, errCode: %d, errMsg: %s, ", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(19468);
    }
}
