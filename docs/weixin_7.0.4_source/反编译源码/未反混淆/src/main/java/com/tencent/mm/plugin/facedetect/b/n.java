package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bqx;
import com.tencent.mm.protocal.protobuf.bqy;
import com.tencent.mm.sdk.platformtools.ab;

public final class n extends m implements k, e {
    private b ehh;
    private f ehi;
    private boolean lSP = false;
    private String lST = null;

    public n(long j, String str, String str2) {
        AppMethodBeat.i(85);
        a aVar = new a();
        aVar.fsJ = new bqx();
        aVar.fsK = new bqy();
        aVar.uri = "/cgi-bin/micromsg-bin/registerface";
        aVar.fsI = 918;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        bqx bqx = (bqx) this.ehh.fsG.fsP;
        bqx.wmO = j;
        bqx.wTm = str;
        bqx.wTn = str2;
        AppMethodBeat.o(85);
    }

    public final int getType() {
        return 918;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(86);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(86);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(87);
        bqy bqy = (bqy) ((b) qVar).fsH.fsP;
        if (i2 == 0 && i3 == 0) {
            this.lSP = bqy.wTp == 0;
            this.lST = bqy.wTo;
            i3 = bqy.wTp;
            ab.i("MicroMsg.NetSceneFaceRegFace", "hy: is Verified: %b", Boolean.valueOf(this.lSP));
        } else if (!(bqy == null || bqy.wTp == 0)) {
            ab.i("MicroMsg.NetSceneFaceRegFace", "hy: has detail ret. use");
            i3 = bqy.wTp;
        }
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(87);
    }

    public final boolean bsg() {
        return true;
    }

    public final String bsh() {
        return this.lST;
    }
}
