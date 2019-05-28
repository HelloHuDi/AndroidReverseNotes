package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cms;
import com.tencent.mm.protocal.protobuf.cmt;
import com.tencent.mm.sdk.platformtools.ab;

public final class s extends m implements k, e {
    private b ehh;
    private f ehi;
    private boolean lSP = false;

    public s(long j, String str, String str2) {
        AppMethodBeat.i(101);
        a aVar = new a();
        aVar.fsJ = new cms();
        aVar.fsK = new cmt();
        aVar.uri = "/cgi-bin/micromsg-bin/verifyface";
        aVar.fsI = 797;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        cms cms = (cms) this.ehh.fsG.fsP;
        cms.wmO = j;
        cms.wTm = str;
        cms.wTn = str2;
        AppMethodBeat.o(101);
    }

    public final int getType() {
        return 797;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(102);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(102);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(103);
        cmt cmt = (cmt) ((b) qVar).fsH.fsP;
        if (i2 == 0 && i3 == 0) {
            this.lSP = cmt.wTp == 0;
            i3 = cmt.wTp;
            ab.i("MicroMsg.NetSceneFaceVerifyFace", "hy: is Verified: %b", Boolean.valueOf(this.lSP));
        } else if (!(cmt == null || cmt.wTp == 0)) {
            ab.i("MicroMsg.NetSceneFaceVerifyFace", "hy: has DetailRet, use it");
            i3 = cmt.wTp;
        }
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(103);
    }

    public final boolean bsg() {
        return true;
    }

    public final String bsh() {
        return null;
    }
}
