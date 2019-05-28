package com.tencent.mm.plugin.location.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.appbrand.jsapi.p.d;
import com.tencent.mm.protocal.protobuf.yy;
import com.tencent.mm.protocal.protobuf.yz;
import com.tencent.mm.sdk.platformtools.ab;

public final class a extends m implements k {
    public final b ehh;
    private f ehi;
    private Runnable fPK;

    public a(String str) {
        AppMethodBeat.i(113409);
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.fsJ = new yy();
        aVar.fsK = new yz();
        aVar.uri = "/cgi-bin/micromsg-bin/exittrackroom";
        aVar.fsI = d.CTRL_INDEX;
        this.ehh = aVar.acD();
        ((yy) this.ehh.fsG.fsP).weu = str;
        ab.d("MicroMsg.NetSceneExitTrackRoom", "trackRoomId:".concat(String.valueOf(str)));
        AppMethodBeat.o(113409);
    }

    public final int getType() {
        return d.CTRL_INDEX;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(113410);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(113410);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(113411);
        ab.d("MicroMsg.NetSceneExitTrackRoom", "onGYNetEnd errType %d errCode%d", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        if (this.fPK != null) {
            this.fPK.run();
        }
        AppMethodBeat.o(113411);
    }
}
