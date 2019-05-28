package com.tencent.mm.plugin.ext.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.qr;
import com.tencent.mm.protocal.protobuf.qs;
import com.tencent.mm.sdk.platformtools.ab;

public final class a extends m implements k {
    private b ehh;
    public f ehi;
    public int lRf = -1;
    public String mUrl = null;

    public a(String str, int i, int i2) {
        AppMethodBeat.i(20431);
        this.mUrl = str;
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.fsJ = new qr();
        aVar.fsK = new qs();
        aVar.uri = "/cgi-bin/micromsg-bin/checkcamerascan";
        aVar.fsI = 782;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        ab.i("MicroMsg.NetSceneCheckUrlAvailableInWx", "hy: checking url: %s", str);
        qr qrVar = (qr) this.ehh.fsG.fsP;
        qrVar.URL = this.mUrl;
        qrVar.vXI = i;
        qrVar.vXJ = i2;
        AppMethodBeat.o(20431);
    }

    public final int getType() {
        return 782;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(20432);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(20432);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(20433);
        ab.d("MicroMsg.NetSceneCheckUrlAvailableInWx", "hy: on get camera url end. errType; %d, errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        qs qsVar = (qs) ((b) qVar).fsH.fsP;
        if (i2 == 0 && i3 == 0) {
            this.lRf = qsVar.jCt;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(20433);
    }
}
