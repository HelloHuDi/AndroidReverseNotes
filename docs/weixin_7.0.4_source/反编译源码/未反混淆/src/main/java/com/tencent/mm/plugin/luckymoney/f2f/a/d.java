package com.tencent.mm.plugin.luckymoney.f2f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aab;
import com.tencent.mm.protocal.protobuf.aac;
import com.tencent.mm.protocal.protobuf.aw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c.i;

public final class d extends m implements k, i {
    public String czZ;
    private f ehi;
    private b gme;
    public String nSX;
    private aab nUm;
    private aac nUn;
    public String nUo;

    public d(int i, int i2, int i3, int i4) {
        AppMethodBeat.i(42154);
        a aVar = new a();
        aVar.fsJ = new aab();
        aVar.fsK = new aac();
        aVar.uri = "/cgi-bin/mmpay-bin/ftfhb/ffrequestwxhb";
        this.gme = aVar.acD();
        this.nUm = (aab) this.gme.fsG.fsP;
        this.nUm.kCd = i;
        this.nUm.pjg = i2;
        this.nUm.cRT = i3;
        this.nUm.wfj = i4;
        aw cPy = com.tencent.mm.plugin.wallet_core.model.k.cPy();
        if (cPy != null) {
            this.nUm.latitude = cPy.latitude;
            this.nUm.longitude = cPy.longitude;
        }
        AppMethodBeat.o(42154);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(42155);
        ab.i("NetSceneF2FLuckyMoneyPrepare", "errType %d,errCode %d,errMsg %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.nUn = (aac) ((b) qVar).fsH.fsP;
        this.czZ = this.nUn.nYX;
        this.nSX = this.nUn.nSX;
        this.nUo = this.nUn.nZe;
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(42155);
    }

    public final int getType() {
        return 1970;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(42156);
        this.ehi = fVar;
        int a = a(eVar, this.gme, this);
        AppMethodBeat.o(42156);
        return a;
    }
}
