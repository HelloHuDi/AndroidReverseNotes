package com.tencent.mm.plugin.location.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.awl;
import com.tencent.mm.protocal.protobuf.awm;
import com.tencent.mm.sdk.platformtools.ab;

public final class b extends m implements k {
    public String aIm;
    public final com.tencent.mm.ai.b ehh;
    private f ehi;
    public int errCode;
    public int errType;
    private Runnable fPK;
    public String hwA;
    public String nJs = "";

    public b(String str) {
        AppMethodBeat.i(113412);
        a aVar = new a();
        aVar.fsJ = new awl();
        aVar.fsK = new awm();
        aVar.uri = "/cgi-bin/micromsg-bin/jointrackroom";
        aVar.fsI = 490;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        ((awl) this.ehh.fsG.fsP).wAT = str;
        ab.d("MicroMsg.NetSceneJoinTrackRoom", "chatNameId:".concat(String.valueOf(str)));
        AppMethodBeat.o(113412);
    }

    public final int getType() {
        return 490;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(113413);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(113413);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        awm awm;
        AppMethodBeat.i(113414);
        this.errType = i2;
        this.errCode = i3;
        this.aIm = str;
        if (((com.tencent.mm.ai.b) qVar).fsH.fsP != null) {
            awm = (awm) ((com.tencent.mm.ai.b) qVar).fsH.fsP;
        } else {
            awm = null;
        }
        ab.d("MicroMsg.NetSceneJoinTrackRoom", "onGYNetEnd errType %d errCode%d", Integer.valueOf(i2), Integer.valueOf(i3));
        if ((i3 == 0 || i3 >= 1000) && awm != null) {
            this.nJs = awm.weu;
            ab.d("MicroMsg.NetSceneJoinTrackRoom", "get trackRoomid %s", this.nJs);
        }
        if (awm != null) {
            this.hwA = awm.vKq;
        }
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        if (this.fPK != null) {
            this.fPK.run();
        }
        AppMethodBeat.o(113414);
    }
}
