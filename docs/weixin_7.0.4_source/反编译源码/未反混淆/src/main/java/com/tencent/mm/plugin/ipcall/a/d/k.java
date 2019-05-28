package com.tencent.mm.plugin.ipcall.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bmd;
import com.tencent.mm.protocal.protobuf.bme;
import com.tencent.mm.sdk.platformtools.ab;

public final class k extends m implements com.tencent.mm.network.k {
    private b ehh = null;
    private f ehi = null;
    public bmd nyA = null;
    public bme nyB = null;

    public k(int i, long j, long j2) {
        AppMethodBeat.i(21866);
        a aVar = new a();
        aVar.fsJ = new bmd();
        aVar.fsK = new bme();
        aVar.fsI = 726;
        aVar.uri = "/cgi-bin/micromsg-bin/pstnredirect";
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        this.nyA = (bmd) this.ehh.fsG.fsP;
        this.nyA.wem = i;
        this.nyA.wen = j;
        this.nyA.wOS = j2;
        AppMethodBeat.o(21866);
    }

    public final int getType() {
        return 726;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(21867);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(21867);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(21868);
        ab.i("MicroMsg.NetSceneIPCallRedirect", "onGYNetEnd, errType: %d, errCode: %d", Integer.valueOf(i2), Integer.valueOf(i3));
        this.nyB = (bme) ((b) qVar).fsH.fsP;
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(21868);
    }
}
