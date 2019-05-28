package com.tencent.mm.plugin.brandservice.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.azp;
import com.tencent.mm.protocal.protobuf.azq;
import com.tencent.mm.sdk.platformtools.ab;

public final class d extends m implements k {
    public b ehh;
    private f ehi;

    public d(String str) {
        AppMethodBeat.i(13833);
        a aVar = new a();
        aVar.fsJ = new azp();
        aVar.fsK = new azq();
        aVar.uri = "/cgi-bin/mmbiz-bin/usrmsg/getallrecvtmpmsgoption";
        this.ehh = aVar.acD();
        ((azp) this.ehh.fsG.fsP).wxX = str;
        AppMethodBeat.o(13833);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(13834);
        ab.d("MicroMsg.brandservice.NetSceneGetAllRecvTmpMsgOption", "onGYNetEnd code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(13834);
    }

    public final int getType() {
        return 1031;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(13835);
        this.ehi = fVar;
        ab.i("MicroMsg.brandservice.NetSceneGetAllRecvTmpMsgOption", "do scene");
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(13835);
        return a;
    }
}
