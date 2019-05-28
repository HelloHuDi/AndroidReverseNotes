package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.rj;
import com.tencent.mm.protocal.protobuf.rk;
import com.tencent.mm.sdk.platformtools.ab;

public final class bj extends m implements k {
    private f ehi;
    private final b fmP;
    public int fmQ = 0;
    public int fmR = 0;
    public int fmS = 0;
    public int type = 0;

    public bj(int i, String str, String str2, String str3) {
        AppMethodBeat.i(50498);
        rj rjVar = new rj();
        rjVar.Scene = i;
        rjVar.vYA = str;
        rjVar.nqc = str2;
        rjVar.vYB = str3;
        a aVar = new a();
        aVar.fsJ = rjVar;
        aVar.fsK = new rk();
        aVar.uri = "/cgi-bin/micromsg-bin/checkmobilesimtype";
        aVar.fsI = 813;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.fmP = aVar.acD();
        this.fmP.cQh = 1;
        ab.i("MicroMsg.NetSceneGetMobileSIMType", "Check scene[%d] IP[%s] IMEI[%s] IMSI[%s]", Integer.valueOf(i), rjVar.vYA, rjVar.nqc, rjVar.vYB);
        AppMethodBeat.o(50498);
    }

    public final int getType() {
        return 813;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(50499);
        this.ehi = fVar;
        int a = a(eVar, this.fmP, this);
        AppMethodBeat.o(50499);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(50500);
        ab.i("MicroMsg.NetSceneGetMobileSIMType", "summerdiz NetSceneGetMobileSIMType onGYNetEnd netId[%d], errType[%d], errCode[%d], errMsg[%s]", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            rk rkVar = (rk) this.fmP.fsH.fsP;
            this.fmQ = rkVar.vYG;
            this.fmR = rkVar.vYF;
            this.type = rkVar.jCt;
            this.fmS = rkVar.vYE;
            ab.i("MicroMsg.NetSceneGetMobileSIMType", "CheckMobileSIMTypeResp ProductType[%d] expiredTime[%d] flag[%d]", Integer.valueOf(rkVar.vYF), Integer.valueOf(rkVar.vYE), Integer.valueOf(rkVar.vYG));
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(50500);
    }
}
