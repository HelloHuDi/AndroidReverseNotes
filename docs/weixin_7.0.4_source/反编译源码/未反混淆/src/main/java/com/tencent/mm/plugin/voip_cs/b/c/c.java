package com.tencent.mm.plugin.voip_cs.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cot;
import com.tencent.mm.protocal.protobuf.cou;
import com.tencent.mm.sdk.platformtools.ab;

public final class c extends m implements k {
    public b ehh;
    private f ehi;

    public c(int i, String str, int i2, byte[] bArr, byte[] bArr2, String str2) {
        AppMethodBeat.i(135377);
        a aVar = new a();
        aVar.fsJ = new cot();
        aVar.fsK = new cou();
        aVar.uri = "/cgi-bin/micromsg-bin/csvoipinvite";
        this.ehh = aVar.acD();
        cot cot = (cot) this.ehh.fsG.fsP;
        cot.wOQ = i;
        cot.xmv = str;
        cot.vZF = i2;
        cot.xmw = com.tencent.mm.bt.b.bI(bArr);
        cot.xmx = com.tencent.mm.bt.b.bI(bArr2);
        cot.wOP = System.currentTimeMillis();
        if (!(str2 == null || str2.equals(""))) {
            cot.xmy = str2;
        }
        AppMethodBeat.o(135377);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(135378);
        ab.i("MicroMsg.NetSceneVoipCSInvite", "onGYNetEnd, errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(135378);
    }

    public final int getType() {
        return 823;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(135379);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(135379);
        return a;
    }
}
