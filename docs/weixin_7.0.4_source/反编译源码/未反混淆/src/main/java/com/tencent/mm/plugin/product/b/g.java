package com.tencent.mm.plugin.product.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.appbrand.jsapi.k.c;
import com.tencent.mm.protocal.protobuf.akb;
import com.tencent.mm.protocal.protobuf.akc;
import com.tencent.mm.protocal.protobuf.cx;
import com.tencent.mm.protocal.protobuf.ze;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

public final class g extends m implements k {
    private b ehh;
    private f ehi;
    public LinkedList<ze> phb;
    public String phj;

    public g(String str, String str2, cx cxVar) {
        AppMethodBeat.i(43985);
        a aVar = new a();
        aVar.fsJ = new akb();
        aVar.fsK = new akc();
        aVar.uri = "/cgi-bin/micromsg-bin/getlastestexpressinfo";
        aVar.fsI = c.CTRL_INDEX;
        this.ehh = aVar.acD();
        akb akb = (akb) this.ehh.fsG.fsP;
        this.phj = str;
        akb.vQq = str;
        ab.d("MicroMsg.NetSceneMallGetLastestExpressInfo", "pid ".concat(String.valueOf(str)));
        akb.vRN = str2;
        akb.wpB = cxVar;
        AppMethodBeat.o(43985);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(43986);
        akc akc = (akc) ((b) qVar).fsH.fsP;
        if (i2 == 0 && i3 == 0 && akc.vKp == 0) {
            ab.d("MicroMsg.NetSceneMallGetLastestExpressInfo", "resp.ExpressCount " + akc.wpD);
            this.phb = akc.wpC;
        }
        if (i3 == 0 && akc.vKp != 0) {
            i3 = akc.vKp;
            str = akc.vKq;
        }
        ab.d("MicroMsg.NetSceneMallGetLastestExpressInfo", "errCode " + i3 + ", errMsg " + str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(43986);
    }

    public final int getType() {
        return c.CTRL_INDEX;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(43987);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(43987);
        return a;
    }
}
