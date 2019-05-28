package com.tencent.mm.plugin.account.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cgw;
import com.tencent.mm.protocal.protobuf.cgx;
import com.tencent.mm.protocal.z;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class g extends m implements k {
    public b ehh;
    private f ehi;

    public g(String str) {
        AppMethodBeat.i(124685);
        a aVar = new a();
        aVar.fsJ = new cgw();
        aVar.fsK = new cgx();
        aVar.uri = "/cgi-bin/micromsg-bin/thirdappverify";
        this.ehh = aVar.acD();
        ((cgw) this.ehh.fsG.fsP).wfk = str;
        ((cgw) this.ehh.fsG.fsP).xfE = 1;
        ((cgw) this.ehh.fsG.fsP).luQ = aa.dor();
        byte[] dpz = bo.dpz();
        ((cgw) this.ehh.fsG.fsP).vLz = com.tencent.mm.platformtools.aa.ad(dpz);
        this.ehh.a(z.dmx());
        this.ehh.cQh = 1;
        this.ehh.acF().vyi = dpz;
        this.ehh.acF().vyf = 1;
        AppMethodBeat.o(124685);
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(124686);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(124686);
        return a;
    }

    public final int getType() {
        return 755;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(124687);
        ab.i("MicroMsg.NetSceneVerifyThirdApp", "errType %d,errCode %d,errMsg %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(124687);
    }
}
