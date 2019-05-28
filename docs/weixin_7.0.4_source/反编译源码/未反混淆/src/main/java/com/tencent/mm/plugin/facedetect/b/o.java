package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.m.b;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.facedetect.b.j.a;
import com.tencent.mm.protocal.protobuf.bdv;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class o extends p implements k, e {
    private final q ftU = new f();
    private boolean lSP = false;
    private String lSU = "";

    public final boolean bsg() {
        return true;
    }

    public final String bsh() {
        return this.lSU;
    }

    public o(long j, String str, String str2) {
        AppMethodBeat.i(88);
        a aVar = (a) this.ftU.acF();
        aVar.lSB.wmM = p.lSV;
        aVar.lSB.wmO = j;
        aVar.lSB.wTm = str;
        aVar.lSB.wTn = str2;
        AppMethodBeat.o(88);
    }

    /* Access modifiers changed, original: final */
    public final int g(e eVar) {
        AppMethodBeat.i(89);
        this.ftU.acF();
        int a = a(eVar, this.ftU, this);
        AppMethodBeat.o(89);
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
        AppMethodBeat.i(90);
        ab.d("MicroMsg.NetSceneFaceRegFaceRsa", "hy: onGYNetEnd  errType:" + i + " errCode:" + i2);
        j.b bVar = (j.b) qVar.ZS();
        if (i == 0 && i2 == 0) {
            this.lSP = bVar.lSC.wTp == 0;
            this.lSU = bVar.lSC.wTo;
            i2 = bVar.lSC.wTp;
            String str2 = "MicroMsg.NetSceneFaceRegFaceRsa";
            String str3 = "hy: is verify ok: %b, youtuRet; %d, has random pwd: %b";
            Object[] objArr = new Object[3];
            objArr[0] = Boolean.valueOf(this.lSP);
            objArr[1] = Integer.valueOf(bVar.lSC.wTp);
            if (bo.isNullOrNil(this.lSU)) {
                z = false;
            }
            objArr[2] = Boolean.valueOf(z);
            ab.i(str2, str3, objArr);
        } else if (!(bVar == null || bVar.lSC == null || bVar.lSC.wTp == 0)) {
            ab.i("MicroMsg.NetSceneFaceRegFaceRsa", "hy: has detail ret. use");
            i2 = bVar.lSC.wTp;
        }
        this.ehi.onSceneEnd(i, i2, str, this);
        AppMethodBeat.o(90);
    }

    /* Access modifiers changed, original: final */
    public final void Lo(String str) {
        AppMethodBeat.i(91);
        ((a) this.ftU.acF()).lSB.wmM = str;
        AppMethodBeat.o(91);
    }

    /* Access modifiers changed, original: protected|final */
    public final bdv g(q qVar) {
        AppMethodBeat.i(92);
        bdv bdv = ((j.b) qVar.ZS()).lSC.wmQ;
        AppMethodBeat.o(92);
        return bdv;
    }
}
