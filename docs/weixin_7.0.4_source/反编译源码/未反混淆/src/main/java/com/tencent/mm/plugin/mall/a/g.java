package com.tencent.mm.plugin.mall.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ame;
import com.tencent.mm.protocal.protobuf.amf;
import com.tencent.mm.sdk.platformtools.ab;

public final class g extends m implements k {
    private f ehi;
    private b gme;
    private ame okU;
    public amf okV;

    public g() {
        AppMethodBeat.i(43102);
        a aVar = new a();
        aVar.fsJ = new ame();
        aVar.fsK = new amf();
        aVar.uri = "/cgi-bin/mmpay-bin/tenpay/getpaymenu";
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.gme = aVar.acD();
        this.okU = (ame) this.gme.fsG.fsP;
        AppMethodBeat.o(43102);
    }

    public final int getType() {
        return 1754;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(43103);
        ab.d("MicroMsg.NetSceneGetPayMenu", "doScene");
        this.ehi = fVar;
        int a = a(eVar, this.gme, this);
        AppMethodBeat.o(43103);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(43104);
        ab.i("MicroMsg.NetSceneGetPayMenu", "onGYNetEnd, errType: %s, errCode: %s", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 0 && i3 == 0) {
            int size;
            this.okV = (amf) this.gme.fsH.fsP;
            String str2 = "MicroMsg.NetSceneGetPayMenu";
            String str3 = "onGYNetEnd, title: %s, sectors: %s, sectors.size: %s";
            Object[] objArr = new Object[3];
            objArr[0] = this.okV.title;
            objArr[1] = this.okV.wrk;
            if (this.okV.wrk != null) {
                size = this.okV.wrk.size();
            } else {
                size = 0;
            }
            objArr[2] = Integer.valueOf(size);
            ab.i(str2, str3, objArr);
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(43104);
    }
}
