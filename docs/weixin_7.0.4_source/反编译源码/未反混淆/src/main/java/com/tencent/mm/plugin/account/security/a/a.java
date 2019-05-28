package com.tencent.mm.plugin.account.security.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.vz;
import com.tencent.mm.protocal.protobuf.wa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class a extends m implements k {
    private String ceI;
    private b ehh;
    private f ehi;

    public a(String str) {
        AppMethodBeat.i(69826);
        this.ceI = str;
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.fsJ = new vz();
        aVar.fsK = new wa();
        aVar.uri = "/cgi-bin/micromsg-bin/delsafedevice";
        this.ehh = aVar.acD();
        ((vz) this.ehh.fsG.fsP).wcI = str;
        AppMethodBeat.o(69826);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(69827);
        ab.d("MicroMsg.NetSceneDelSafeDevice", "NetSceneDelSafeDevice, errType= " + i2 + " errCode = " + i3);
        if (i2 == 0 && i3 == 0) {
            wa waVar = (wa) this.ehh.fsH.fsP;
            g.RP().Ry().set(64, Integer.valueOf(waVar.vCl));
            ab.d("MicroMsg.NetSceneDelSafeDevice", "NetSceneDelSafeDevice, get safedevice state = " + waVar.vCl);
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(69827);
    }

    public final int getType() {
        return 362;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(69828);
        if (bo.isNullOrNil(this.ceI)) {
            ab.e("MicroMsg.NetSceneDelSafeDevice", "null device id");
            AppMethodBeat.o(69828);
            return -1;
        }
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(69828);
        return a;
    }
}
