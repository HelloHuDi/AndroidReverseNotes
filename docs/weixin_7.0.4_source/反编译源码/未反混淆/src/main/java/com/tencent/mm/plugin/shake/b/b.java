package com.tencent.mm.plugin.shake.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.byr;
import com.tencent.mm.protocal.protobuf.bys;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class b extends m implements k {
    byte[] cQr;
    private final com.tencent.mm.ai.b ehh;
    private f ehi;
    int ret;

    public b(float f, float f2, int i, int i2, String str, String str2) {
        AppMethodBeat.i(24414);
        a aVar = new a();
        aVar.fsJ = new byr();
        aVar.fsK = new bys();
        aVar.uri = "/cgi-bin/micromsg-bin/shakereport";
        this.ehh = aVar.acD();
        byr byr = (byr) this.ehh.fsG.fsP;
        ab.i("MicroMsg.NetSceneShakeReport", "share reprot %f %f", Float.valueOf(f2), Float.valueOf(f));
        byr.OpCode = 0;
        byr.vRp = f;
        byr.vRq = f2;
        byr.wfG = i;
        byr.wfH = str;
        byr.wfI = str2;
        byr.wfJ = i2;
        aw.ZK();
        byr.wYa = bo.a((Integer) c.Ry().get(4107, null), 0);
        aw.ZK();
        int h = bo.h((Integer) c.Ry().get(4106, null));
        byr.wYb = h;
        h++;
        aw.ZK();
        c.Ry().set(4106, Integer.valueOf(h));
        byr.vIl = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.b.oTO.bVS());
        o.a(2002, f, f2, i);
        AppMethodBeat.o(24414);
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(24415);
        ab.d("MicroMsg.NetSceneShakeReport", "doScene");
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(24415);
        return a;
    }

    public final int getType() {
        return 161;
    }

    public final int cju() {
        return ((byr) this.ehh.fsG.fsP).wfJ;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(24416);
        ab.d("MicroMsg.NetSceneShakeReport", "onGYNetEnd errType:" + i2 + " errCode:" + i3);
        bys bys = (bys) this.ehh.fsH.fsP;
        this.ret = qVar.ZS().vyl;
        if (i2 == 0 && i3 == 0) {
            this.cQr = aa.a(bys.vJd);
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(24416);
    }
}
