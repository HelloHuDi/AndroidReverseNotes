package com.tencent.mm.plugin.ipcall.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bly;
import com.tencent.mm.protocal.protobuf.blz;
import com.tencent.mm.sdk.platformtools.ab;

public final class h extends m implements k {
    private b ehh = null;
    private f ehi = null;
    public bly nyu = null;
    private blz nyv = null;

    public h(int i, long j, long j2) {
        AppMethodBeat.i(21857);
        a aVar = new a();
        aVar.fsJ = new bly();
        aVar.fsK = new blz();
        aVar.fsI = 824;
        aVar.uri = "/cgi-bin/micromsg-bin/pstnheartbeat";
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        long currentTimeMillis = System.currentTimeMillis();
        this.nyu = (bly) this.ehh.fsG.fsP;
        this.nyu.wem = i;
        this.nyu.wen = j;
        this.nyu.wOS = j2;
        this.nyu.wOP = currentTimeMillis;
        ab.d("MicroMsg.NetSceneIPCallHeartBeat", "heartbeat, roomId: %d, roomKey: %d, callSeq: %d, timestamp: %d", Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(currentTimeMillis));
        AppMethodBeat.o(21857);
    }

    public final int getType() {
        return 824;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(21858);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(21858);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(21859);
        ab.i("MicroMsg.NetSceneIPCallHeartBeat", "onGYNetEnd, errType: %d, errCode: %d", Integer.valueOf(i2), Integer.valueOf(i3));
        this.nyv = (blz) ((b) qVar).fsH.fsP;
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(21859);
    }
}
