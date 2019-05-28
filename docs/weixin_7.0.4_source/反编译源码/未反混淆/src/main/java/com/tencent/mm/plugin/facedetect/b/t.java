package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.m.b;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.facedetect.b.k.a;
import com.tencent.mm.protocal.protobuf.bdv;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class t extends p implements k, e {
    private final q ftU = new g();
    private boolean lSP = false;
    private String lSU = "";

    public final boolean bsg() {
        return true;
    }

    public final String bsh() {
        return this.lSU;
    }

    public t(long j, String str, String str2) {
        AppMethodBeat.i(104);
        a aVar = (a) this.ftU.acF();
        aVar.lSD.wmM = p.lSV;
        aVar.lSD.wmO = j;
        aVar.lSD.wTn = str2;
        aVar.lSD.wTm = str;
        AppMethodBeat.o(104);
    }

    /* Access modifiers changed, original: final */
    public final int g(e eVar) {
        AppMethodBeat.i(105);
        this.ftU.acF();
        int a = a(eVar, this.ftU, this);
        AppMethodBeat.o(105);
        return a;
    }

    public final int acn() {
        return 3;
    }

    public final b b(q qVar) {
        return b.EOk;
    }

    public final void a(m.a aVar) {
    }

    public final int getType() {
        return 930;
    }

    public final void c(int i, int i2, String str, q qVar) {
        boolean z = true;
        AppMethodBeat.i(106);
        ab.d("MicroMsg.NetSceneFaceVerifyFaceRsa", "hy: onGYNetEnd  errType:" + i + " errCode:" + i2);
        k.b bVar = (k.b) qVar.ZS();
        if (i == 0 && i2 == 0) {
            this.lSP = bVar.lSE.wTp == 0;
            this.lSU = bVar.lSE.wTo;
            String str2 = "MicroMsg.NetSceneFaceVerifyFaceRsa";
            String str3 = "hy: is verify ok: %b, youtuRet: %d, has random pwd: %b";
            Object[] objArr = new Object[3];
            objArr[0] = Boolean.valueOf(this.lSP);
            objArr[1] = Integer.valueOf(bVar.lSE.wTp);
            if (bo.isNullOrNil(this.lSU)) {
                z = false;
            }
            objArr[2] = Boolean.valueOf(z);
            ab.i(str2, str3, objArr);
            i2 = bVar.lSE.wTp;
        } else if (!(bVar == null || bVar.lSE == null || bVar.lSE.wTp == 0)) {
            ab.i("MicroMsg.NetSceneFaceVerifyFaceRsa", "hy: has detail ret. use");
            i2 = bVar.lSE.wTp;
        }
        this.ehi.onSceneEnd(i, i2, str, this);
        AppMethodBeat.o(106);
    }

    /* Access modifiers changed, original: final */
    public final void Lo(String str) {
        AppMethodBeat.i(107);
        ((a) this.ftU.acF()).lSD.wmM = str;
        AppMethodBeat.o(107);
    }

    /* Access modifiers changed, original: protected|final */
    public final bdv g(q qVar) {
        AppMethodBeat.i(108);
        bdv bdv = ((k.b) qVar.ZS()).lSE.wmQ;
        AppMethodBeat.o(108);
        return bdv;
    }
}
