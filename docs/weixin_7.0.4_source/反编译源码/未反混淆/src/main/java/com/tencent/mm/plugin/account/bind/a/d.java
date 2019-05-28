package com.tencent.mm.plugin.account.bind.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cja;
import com.tencent.mm.protocal.protobuf.cjb;

public final class d extends m implements k {
    private b ehh;
    private f ehi;

    public d(String str) {
        AppMethodBeat.i(13327);
        a aVar = new a();
        aVar.fsJ = new cja();
        aVar.fsK = new cjb();
        aVar.uri = "/cgi-bin/micromsg-bin/unbindqq";
        aVar.fsI = com.tencent.view.d.MIC_PTU_ZIPAI_OKINAWA;
        this.ehh = aVar.acD();
        ((cja) this.ehh.fsG.fsP).wdB = str;
        AppMethodBeat.o(13327);
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(13328);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(13328);
        return a;
    }

    public final int getType() {
        return com.tencent.view.d.MIC_PTU_ZIPAI_OKINAWA;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(13329);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(13329);
    }
}
