package com.tencent.mm.plugin.shake.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.byk;
import com.tencent.mm.protocal.protobuf.byl;
import com.tencent.mm.sdk.platformtools.ab;

public final class c extends m implements k {
    private final b ehh;
    private f ehi;
    e qsm;

    public c(float f, float f2, int i, String str) {
        AppMethodBeat.i(24514);
        a aVar = new a();
        aVar.fsJ = new byk();
        aVar.fsK = new byl();
        aVar.uri = "/cgi-bin/mmbiz-bin/card/shakecard";
        this.ehh = aVar.acD();
        byk byk = (byk) this.ehh.fsG.fsP;
        byk.cEB = f2;
        byk.cGm = f;
        byk.scene = i;
        byk.wXH = str;
        AppMethodBeat.o(24514);
    }

    public final int getType() {
        return 1250;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(24515);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(24515);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(24516);
        ab.i("MicroMsg.NetSceneShakeCard", "onGYNetEnd, getType = 1250 errType = " + i2 + " errCode = " + i3);
        if (i2 == 0 && i3 == 0) {
            byl byl = (byl) this.ehh.fsH.fsP;
            if (byl != null) {
                this.qsm = new e();
                this.qsm.kdC = byl.kdC;
                this.qsm.kbU = byl.kbU;
                this.qsm.cMD = byl.cMD;
                this.qsm.title = byl.title;
                this.qsm.kbW = byl.kbW;
                this.qsm.kbX = byl.kbX;
                this.qsm.kdg = byl.kdg;
                this.qsm.kbV = byl.kbV;
                this.qsm.color = byl.color;
                this.qsm.qsn = byl.qsn;
                this.qsm.qsq = byl.qsq;
                this.qsm.qsr = byl.qsr;
                this.qsm.qss = byl.qss;
                this.qsm.qst = byl.qst;
                this.qsm.qsu = byl.qsu;
                this.qsm.kbZ = byl.kbZ;
                this.qsm.qsv = byl.qsv;
                this.qsm.qsw = byl.qsw;
                com.tencent.mm.plugin.shake.b.m.cjY().qsp = this.qsm.qsu;
            } else {
                this.qsm = new e();
                this.qsm.kdC = 3;
                this.qsm.qsu = com.tencent.mm.plugin.shake.b.m.cjY().qsp;
            }
        } else {
            this.qsm = new e();
            this.qsm.kdC = 3;
            this.qsm.qsu = com.tencent.mm.plugin.shake.b.m.cjY().qsp;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(24516);
    }
}
